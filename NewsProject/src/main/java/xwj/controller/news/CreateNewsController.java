package xwj.controller.news;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xwj.bean.News;
import xwj.bean.Result;
import xwj.service.news.NewsService;
import xwj.util.IdWorker;

import static xwj.controller.Code.*;
import static xwj.controller.Message.*;

@RestController
@Controller
public class CreateNewsController {

    @Resource
    NewsService newsService;
    @Resource
    IdWorker idWorker;
    @PutMapping("/news")
    public Result<News> createNews(@RequestBody News news) {
        System.out.println("创建新闻"+news);

//        return null;

        Result<News> result = new Result<>();
        try {
            news.setNewsId(String.valueOf(idWorker.nextId()));
            if (newsService.add(news) != 1) {
                throw new RuntimeException("添加新闻错误");
            }
            result.setData(news);
            result.setCode(SAVE_OK);
            result.setMessage(CREATE_NEWS_OK_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(SAVE_ERR);
            result.setMessage(CREATE_NEWS_ERR_MESSAGE);
        }
        return result;
    }
}
