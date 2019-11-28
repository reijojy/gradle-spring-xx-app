package cradle.spring.xx.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/datasource.properties")
public class DataSourceConfig {

    // Tested 9th October works with an annotation from a property file.
    @Value("${user}")
    private String dbUserName;

    @Bean
    public DataSource getDataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
        //dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.url("jdbc:mysql://jyrki.mysql.database.azure.com:3306/hb-04-one-to-many-uni");
        // Korvattu arvolla properties tiedostosta
        dataSourceBuilder.username(dbUserName);
        dataSourceBuilder.password("f8WtS!29");
        return dataSourceBuilder.build();

    }
}
