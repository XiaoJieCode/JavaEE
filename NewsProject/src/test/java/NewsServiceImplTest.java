import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xwj.bean.News;
import xwj.config.SpringConfig;
import xwj.service.news.NewsService;
import xwj.service.news.impl.NewsServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class NewsServiceImplTest {
    @Resource
    NewsService service;
    @Test
    public void testUpdateNews(){
        News news = new News();
        news.setNewsId("1");
        news.setNewsContent("TEstTETTETETTT");
        System.out.println(service.updateById(news));
    }
}
