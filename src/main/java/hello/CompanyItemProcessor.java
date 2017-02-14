package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jesse on 2017/2/13.
 * ItemProcessor接口，重写其process方法，处理I，返回O
 */
public class CompanyItemProcessor implements ItemProcessor<Company,CompanyEntity>{

    //创建一个log对象，用于打印日志，LoggerFactory类
    public static final Logger log = LoggerFactory.getLogger(CompanyItemProcessor.class); //*

    @Override
    public CompanyEntity process(final Company company) throws Exception {
        System.out.println("============companyName:"+company.getCompanyName());
        final String companyName = company.getCompanyName();
        final String companyAddress = company.getCompanyAddress();
        //final Date establishDate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(company.getEstablishDate());
        final String establishDate = company.getEstablishDate();
        final String province =company.getProvince();
        final String companyType = company.getCompanyType();
        final String legalPerson = company.getLegalPerson();

        final CompanyEntity transformedCompany = new CompanyEntity(companyName,province,establishDate,companyType,companyAddress,legalPerson);

        log.info("Converting:"+ company);
        return transformedCompany;
    }
}
