package xwj;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xwj.config.SpringConfig;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);
    }
}