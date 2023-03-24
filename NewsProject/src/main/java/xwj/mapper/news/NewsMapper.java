package xwj.mapper.news;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xwj.bean.News;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    public int add(News news);
    public int updateById(News news);
    News selectById(String newsId);

    List<News> selectAllNews();


    List<News> selectLike(String like);

    int delete(String newsId);

    List<News> selectAllNewsWithUserId(String userId);
}
