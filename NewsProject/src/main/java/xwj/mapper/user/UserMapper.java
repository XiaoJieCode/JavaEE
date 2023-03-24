package xwj.mapper.user;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xwj.bean.User;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    // UserMapper.xml接口映射
    User selectUsernameAndPassword(User user);
    User selectUsername(User user);
    int insertUser(User user);

    User getByUserId(long userId);

    List<User> getAllUser();

    int deleteUserById(long userId);



}
