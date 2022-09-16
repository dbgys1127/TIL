package com.codestates.config;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
// (1) JpaRepository 활성화
@EnableJpaRepositories(
        basePackages = {"com.codestates.member",
                "com.codestates.stamp",
                "com.codestates.order",
                "com.codestates.coffee"},
        entityManagerFactoryRef = "coffeeOrderEntityManager"
)
@Configuration
public class XaCoffeeOrderConfig {
    // (2) 데이터소스 생성
    @Primary
    @Bean
    public DataSource dataSourceCoffeeOrder() {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/coffee_order" +
                "?allowPublicKeyRetrieval=true" +
                "&characterEncoding=UTF-8");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("72957295");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("xaCoffeeOrder");

        return atomikosDataSourceBean;
    }

    // (3) EntityManagerFactoryBean 설정
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean coffeeOrderEntityManager() {
        LocalContainerEntityManagerFactoryBean emFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        // (4)
        properties.put("hibernate.transaction.jta.platform",
                AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");

        emFactoryBean.setDataSource(dataSourceCoffeeOrder());
        emFactoryBean.setPackagesToScan(new String[]{
                "com.codestates.member",
                "com.codestates.stamp",
                "com.codestates.order",
                "com.codestates.coffee"
        });
        emFactoryBean.setJpaVendorAdapter(vendorAdapter);
        emFactoryBean.setPersistenceUnitName("coffeeOrderPersistenceUnit");
        emFactoryBean.setJpaPropertyMap(properties);

        return emFactoryBean;
    }
}
