//package xwj.controller.news;
//
//import jakarta.annotation.Resource;
//import org.springframework.web.bind.annotation.*;
//import xwj.bean.News;
//import xwj.bean.Result;
//import xwj.service.news.NewsTempService;
//
//import java.util.function.BinaryOperator;
//
//import static xwj.controller.Code.*;
//import static xwj.controller.Code.SAVE_ERR;
//import static xwj.controller.Message.*;
//import static xwj.controller.Message.TEMP_NEWS_ERR_MESSAGE;
//
//@RestController
//@RequestMapping("/news/temp")
//public class NewsTempController {
//    @Resource
//
//    NewsTempService newsTempService;
//    @PutMapping
//    public Result<Boolean> setTemp(@RequestBody News news){
//
//        Result<Boolean> result = new Result<>();
//        try {
//
//            if (news == null) throw new RuntimeException("传入news为空,缓存新闻失败");
//            if (news.getNewsId() == null) throw new RuntimeException("传入news为空,缓存新闻失败");
//            if (!newsTempService.setTempNewsById(news)) {
//                throw new RuntimeException("缓存新闻错误");
//            }
//            result.setData(true);
//            result.setCode(SAVE_OK);
//            result.setMessage(TEMP_NEWS_ERR_MESSAGE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setData(null);
//            result.setCode(SAVE_ERR);
//            result.setMessage(TEMP_NEWS_ERR_MESSAGE);
//        }
//        return result;
//
//
//
//    }
//    @GetMapping
//    public Result<Boolean> getTemp(@PathVariable long newsId){
//
//        Result<Boolean> result = new Result<>();
//        try {
//
//            if (news == null) throw new RuntimeException("传入news为空,缓存新闻失败");
//            if (news.getNewsId() == null) throw new RuntimeException("传入news为空,缓存新闻失败");
//            if (!newsTempService.setTempNewsById(news)) {
//                throw new RuntimeException("缓存新闻错误");
//            }
//            result.setData(true);
//            result.setCode(SAVE_OK);
//            result.setMessage(TEMP_NEWS_ERR_MESSAGE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setData(null);
//            result.setCode(SAVE_ERR);
//            result.setMessage(TEMP_NEWS_ERR_MESSAGE);
//        }
//        return result;
//
//
//
//    }
//
//}
