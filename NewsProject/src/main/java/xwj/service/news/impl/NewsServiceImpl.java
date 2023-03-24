package xwj.service.news.impl;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import xwj.bean.News;
import xwj.mapper.news.NewsMapper;
import xwj.service.news.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;


    @Override
    public int delete(String newsId) {
        return newsMapper.delete(newsId);
    }

    @Override
    public int add(News news) {
        return newsMapper.add(news);
    }

    @Override
    public int updateById(News news) {
        return newsMapper.updateById(news);
    }

    public News selectById(String id) {
        News news = newsMapper.selectById(id);
        return news;
    }

    public List<News> selectAll() {
        List<News> news = newsMapper.selectAllNews();
        return news;
    }

    @Override
    public List<News> selectLike(String like) {
        return newsMapper.selectLike(like);
    }

    @Override
    public List<News> selectAllWithUserId(String userId) {
        return newsMapper.selectAllNewsWithUserId(userId);
    }
}
