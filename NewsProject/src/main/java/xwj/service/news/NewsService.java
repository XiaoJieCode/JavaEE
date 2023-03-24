package xwj.service.news;

import org.springframework.transaction.annotation.Transactional;
import xwj.bean.News;

import java.util.List;


@Transactional
public interface NewsService {
    public int delete(String newsId);
    public int add(News news);
    public int updateById(News news);
    public News selectById(String id);

    public List<News> selectAll();

    List<News> selectLike(String like);

    List<News> selectAllWithUserId(String userId);
}
