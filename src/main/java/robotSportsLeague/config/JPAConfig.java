package robotSportsLeague.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import robotSportsLeague.db.JdbcRobotTeamRepository;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class JPAConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private JdbcTemplate jdbc = new JdbcTemplate();

    @Bean
    public JdbcRobotTeamRepository jdbcRobotTeamRepo() {
        return new JdbcRobotTeamRepository(jdbc);
    }

    @Bean(name = "datasource")
    public DataSource h2Datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setSchema(environment.getProperty("spring.datasource.initialization-mode"));

        return dataSource;
    }
}
