package xwj.service.news;

import xwj.bean.News;

import java.util.List;


public interface NewsTempService {
    List<News> getTempNewsById(String newsId);

    boolean setTempNewsById(News news);

    List<News> pop(String  newsId);

    boolean remove(String newsId);


}
