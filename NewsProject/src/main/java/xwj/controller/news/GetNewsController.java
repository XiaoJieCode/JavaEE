package xwj.controller.news;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xwj.bean.News;
import xwj.bean.Result;
import xwj.service.news.NewsService;

import java.util.ArrayList;
import java.util.List;


import static xwj.controller.Code.*;
import static xwj.controller.Message.*;
import static xwj.util.ExceptionUtil.notNull;


@RestController
@RequestMapping("/news")
public class GetNewsController {
    @Resource
    private NewsService newsService;
//    // 获取新闻
//    @GetMapping("/top")
//    public Result<List<News>> getNews() {
//        Result<List<News>> result = new Result<>();
//        try {
//            List<News> news = newsService.selectAll();
//            result.setData(news);
//            result.setCode(GET_OK);
//            result.setMessage(GET_NEWS_OK_MESSAGE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setData(null);
//            result.setCode(GET_ERR);
//            result.setMessage(GET_NEWS_ERR_MESSAGE);
//        }
//        return result;
//    }
    // 获取所有新闻
    @GetMapping("/all")
    public Result<List<News>> getAllNews(){
        Result<List<News>> result = new Result<>();

        try {
            List<News> newsList = newsService.selectAll();
            result.setCode(GET_OK);
            result.setMessage(GET_NEWS_OK_MESSAGE);
            result.setData(newsList);
        }catch (RuntimeException e){
            result.setCode(GET_ERR);
            result.setMessage(GET_NEWS_ERR_MESSAGE);
            result.setData(null);
        }
        return result;
    }
    @GetMapping("/all/{userId}")
    public Result<List<News>> getAllNewsWithUserId(@PathVariable String userId){
        Result<List<News>> result = new Result<>();

        try {

            List<News> newsList = newsService.selectAllWithUserId(userId);
            result.setCode(GET_OK);
            result.setMessage(GET_NEWS_OK_MESSAGE);
            result.setData(newsList);
        }catch (RuntimeException e){
            result.setCode(GET_ERR);
            result.setMessage(GET_NEWS_ERR_MESSAGE);
            result.setData(null);
        }
        return result;
    }


    // 根据newsId获取新闻内容,传递路径变量
    @GetMapping("/{newsId}")
    public Result<News> getNewsByNewsId(@PathVariable String newsId) {
        Result<News> result = new Result<>();
        try {
            notNull(newsId);
            News news = newsService.selectById(newsId);
            if (news == null){
                throw new RuntimeException("获取新闻错误，传入newsId异常？传入的newsId:"+newsId);
            }
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

    // 模糊查询
    @GetMapping("/like")
    public Result<List<News>> getNews(String newsName){
        Result<List<News>> result = new Result<>();
        String like = newsName;
        try {

            notNull(like);
            if (like.equals("")) {
                result.setData(new ArrayList<>());
                result.setCode(GET_OK);
                result.setMessage(GET_NEWS_OK_MESSAGE);
                return result;
            }
            List<News> news = newsService.selectLike(like);
            System.out.println(news);
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

    //    @GetMapping("/1")
//    public Result<News> getTestNews() {
//        Result<News> result = new Result<>();
//        News data = new News();
//        data.setNewsId(1L);
//        data.setNewsTitle("<h1> 北方高温明日达鼎盛 京津冀多地地表温度将超60℃</h1>");
//        data.setNewsTimestamp(new Date());
//        data.setNewsContent("""
//                <p>中国天气网讯
//                            今天（3日），华北、黄淮多地出现高温天气，截至下午2点，北京、天津、郑州等地气温突破35℃。预报显示，今后三天（3-5日），这一带的高温天气将继续发酵，高温范围以及强度将在4日达到鼎盛，预计北京、天津、石家庄、济南等地明天的最高气温有望突破38℃，其中北京和石家庄的最高气温还有望创今年以来的新高。
//                        </p>
//
//                        <h4>气温41.4℃！地温66.5！北京强势迎七月首个高温日</h4>
//
//                        <p>今天，华北、黄淮一带的高温持续发酵，截至今天下午2点，陕西北部、山西西南部、河北南部、北京、天津、山东西部、河南北部最高气温已普遍超过35℃。大城市中，北京、天津、郑州均迎来高温日。</p>
//
//                        <p class="pic">
//                            <img src="res/pic.jpeg" alt="">
//                        </p>
//
//                        <p>在阳光暴晒下，地表温度也逐渐走高。今天下午2点，华北黄淮大部地区的地表温度都在50℃以上，部分地区地表温度甚至超过60℃。其中，河北衡水地表温度高达68.3℃，天津站和北京站附近的地表温度分别高达66.6℃和66.5℃。
//                        </p>
//
//                        <h4>明日热度再升级！京津冀携手冲击38℃+</h4>
//                        <p>中国天气网气象分析师王伟跃介绍，明天（4日），华北、黄淮地区35℃以上的高温天气还将继续升级，并进入鼎盛阶段，高温强度和范围都将发展到最强。
//                            明天，北京南部、天津大部、河北中部和南部、山东中部和西部、山西南部局地、河南北部、东北部分地区的最高气温都将达到或超过35℃。</p>
//
//                        <p> 不过，专家提醒，济南被雨水天气完美绕开，因此未来一周，当地的高温还会天天上岗。在此提醒当地居民注意防暑降温，防范持续高温带来的各种不利影响。</p>
//                        """);
//
//        result.setData(data);
//        result.setCode(200);
//        result.setMessage("获取新闻成功");
//        System.out.println(result);
//        return result;
//    }
}
