package xwj.service.news.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import xwj.bean.News;
import xwj.service.news.NewsTempService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@Service
public class NewsTempServiceImpl implements NewsTempService {
    // news缓存
    private HashMap<String, HashMap<Date, News>> newsTempContainer = new HashMap<>();

    @Override
    public List<News> getTempNewsById(String newsId) {
        HashMap<Date, News> dateNewsHashMap = newsTempContainer.get(newsId);
        return dateNewsHashMap.values().stream().toList();

    }

    @Override
    public boolean setTempNewsById(News news) {
        try {

            // 设置新闻缓存列表，按照时间戳对应
            if (newsTempContainer.containsKey(news.getNewsId())) {
                HashMap<Date, News> dateNewsHashMap = newsTempContainer.get(news.getNewsId());
                dateNewsHashMap.put(new Date(), news);
            } else {
                HashMap<Date, News> value = new HashMap<>();
                value.put(new Date(), news);
                newsTempContainer.put(news.getNewsId(),
                        value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<News> pop(String  newsId) {
        HashMap<Date, News> dateNewsHashMap = newsTempContainer.get(newsId);
        newsTempContainer.remove(newsId);
        return dateNewsHashMap.values().stream().toList();

    }

    @Override
    public boolean remove(String newsId) {
        return newsTempContainer.remove(newsId) != null;
    }
}
