package xwj.controller.news;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xwj.bean.Result;
import xwj.service.news.NewsService;

import static xwj.controller.Code.*;
import static xwj.controller.Message.*;

@RestController
@Controller
public class DeleteNewsController {

    @Resource
    NewsService newsService;

    @DeleteMapping("/news/{newsId}")
    public Result<Boolean> deleteNews(@PathVariable String newsId) {

        Result<Boolean> result = new Result<>();
        try {
            if (newsId == null) throw new RuntimeException("传入newsId为空,删除新闻失败");
            if (newsService.delete(newsId) != 1) {
                throw new RuntimeException("添加新闻错误");
            }
            result.setData(true);
            result.setCode(DELETE_OK);
            result.setMessage(UPDATE_NEWS_OK_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(false);
            result.setCode(DELETE_ERR);
            result.setMessage(UPDATE_NEWS_ERR_MESSAGE);
        }
        return result;
    }
}
