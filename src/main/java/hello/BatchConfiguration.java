package hello; /**
 * Created by jesse on 2017/2/13.
 */
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<Company> reader() {
        System.out.println("==============执行的先后顺序：这里是read方法");
        FlatFileItemReader<Company> reader = new FlatFileItemReader<Company>();
        reader.setResource(new ClassPathResource("sample-data1.csv"));//加载资源文件
        reader.setLineMapper(new DefaultLineMapper<Company>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "companyNo", "companyName","province","establishDate",
                        "companyType","legalPerson","capital","companyCode","companyAddress","businessScope","operationStartdate",
                        "operationEnddate","authority","companyStatus","companyStatus","companyStatus"});//设置Tokenizer，这里用逗号","作为分割，映射Person中的字段
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Company>() {{
                setTargetType(Company.class);
            }});
        }});
        return reader;
    }

    @Bean
    public CompanyItemProcessor processor(){
        return new CompanyItemProcessor();
    }
//    public PersonItemProcessor processor() {
//        System.out.println("==============执行的先后顺序：这里是processor冯方法");
//        return new PersonItemProcessor();
//    }

    /***
     * 参数是写入的对象类型
     * @return
     */
    @Bean
    public JdbcBatchItemWriter<CompanyEntity> writer() {
        System.out.println("==============执行的先后顺序：这里是writer方法");
        //新建一个写入对象，连接的url:jdbc:hsqldb:mem:testdb
        JdbcBatchItemWriter<CompanyEntity> writer = new JdbcBatchItemWriter<CompanyEntity>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CompanyEntity>());
        writer.setSql("INSERT INTO company (company_name,province,establish_date,company_type,company_address,legal_person) VALUES (:companyName, :province, :establishDate,:companyType,:companyAddress,:legalPerson)");//设置sql语句
        writer.setDataSource(dataSource);//设置数据源,连接了hsqldb
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        System.out.println("==============执行的先后顺序：这里是importUserJob方法");
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        System.out.println("==============执行的先后顺序：这里是Step冯方法");
        return stepBuilderFactory.get("step1") //创建一个builder对象
                .<Company, CompanyEntity> chunk(10) //这个对象调用chunk方法后又返回此对象 参数<I,O>
                .reader(reader())  //读取
                .processor(processor()) //处理过程
                .writer(writer())  //写入
                .build();  //reader,processor,writer构建起来
    }
    // end::jobstep[]
}