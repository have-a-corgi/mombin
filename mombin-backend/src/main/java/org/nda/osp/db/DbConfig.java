package org.nda.osp.db;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().url("jdbc:h2:mem:testdb")
                .driverClassName("org.h2.Driver")
                .username("sa").password("sa").build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(ds);
        managerFactoryBean.setPackagesToScan("org.nda.osp");
        managerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return managerFactoryBean;
    }

}
