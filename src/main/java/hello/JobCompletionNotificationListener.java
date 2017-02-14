package hello; /**
 * Created by jesse on 2017/2/14.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /***
     * 处理完成后的工作
     * @param jobExecution
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<CompanyEntity> results = jdbcTemplate.query("SELECT * FROM company", new RowMapper<CompanyEntity>() {  //取出想要字段的数据集
                @Override
                public CompanyEntity mapRow(ResultSet rs, int row) throws SQLException {
                    return new CompanyEntity(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));//从第二列还是取值，第一列是id
                }
            });

            for (CompanyEntity companyEntity : results) {
                log.info("Found <" + companyEntity + "> in the database.");
            }

        }
    }
}