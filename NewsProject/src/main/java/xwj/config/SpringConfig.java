package xwj.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DruidConfig.class, MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
@ComponentScan("xwj.service")
@ComponentScan("xwj.mapper")
@ComponentScan("xwj.util")
@EnableTransactionManagement
public class SpringConfig {

}
