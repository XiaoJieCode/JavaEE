package xwj.config;

import com.alibaba.druid.pool.DruidDataSource;
import jakarta.annotation.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.util.Properties;


@MapperScan("xwj.mapper")
public class MybatisConfig {
    // 配置mybatis
    @Bean
    @Autowired
    public SqlSessionFactoryBean setSqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
//··········································                                        ··········  ··
//        Configuration configuration = build.getConfiguration();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        sqlSessionFactoryBean.setConfiguration(configuration);
//        Properties sqlSessionFactoryProperties = new Properties();
//        sqlSessionFactoryProperties.setProperty("logImpl","Log4j");
//        sqlSessionFactoryBean.setConfigurationProperties(sqlSessionFactoryProperties);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;

    }

//    @Bean
//    @Autowired
//    public SqlSessionFactoryBean setSqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        PathResource configLocation = new PathResource("D:\\Code\\IdeaProject\\JavaEE\\NewsProject\\src\\main\\resources\\mybatis-config.xml");
//        System.out.println(configLocation.getPath());
//        sqlSessionFactoryBean.setConfigLocation (configLocation);
//        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("xwj/mapper/news"));
//        return sqlSessionFactoryBean;
//
//    }

    @Bean
    @Autowired
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
