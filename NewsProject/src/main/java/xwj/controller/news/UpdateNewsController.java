package xwj.controller.news;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import xwj.bean.News;
import xwj.bean.Result;
import xwj.service.news.NewsService;

import static xwj.controller.Code.GET_ERR;
import static xwj.controller.Code.GET_OK;
import static xwj.controller.Message.GET_NEWS_ERR_MESSAGE;
import static xwj.controller.Message.GET_NEWS_OK_MESSAGE;

@ResponseBody
@Controller

public class UpdateNewsController {
    @Resource
    NewsService service;
    @PostMapping("/news")
    public Result<News> updateNews(@RequestBody News news){
        System.out.println(news);
//        return null;
        Result<News> result = new Result<>();
        try {
            int i = service.updateById(news);
            if (i!=1) throw new RuntimeException("更新新闻异常");
            result.setData(news);
            result.setCode(GET_OK);
            result.setMessage(GET_NEWS_OK_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(GET_ERR);
            result.setMessage(GET_NEWS_ERR_MESSAGE);
        }
        return result;
    }

}
