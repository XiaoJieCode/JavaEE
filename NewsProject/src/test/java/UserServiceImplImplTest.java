import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xwj.config.SpringConfig;

import xwj.service.news.impl.NewsServiceImpl;
import xwj.service.user.impl.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceImplImplTest {
    @Resource
    UserServiceImpl userServiceImpl;

    @Resource
    NewsServiceImpl service;
    @Value("${mysql.driver}")
    private String driver;

    @Test
    public void testLogin() throws ClassNotFoundException {
//        System.out.println(userServiceImpl.login("xwj", MD5.getMd5("123456")));
        //
//        System.out.println(Class.forName(driver));
    }

    @Test
    public void testRegister() {

    }

    @Test
    public void testAll() {

    }


}
