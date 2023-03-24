package xwj.service.user;

import org.springframework.transaction.annotation.Transactional;
import xwj.bean.User;
import xwj.bean.Result;

import java.util.List;

@Transactional
public interface UserService {

    //
    Result<User> login(User user);

    Result<User> register(User user);

    User getById(long userId);
    List<User> getAllUser(long userId);

    int deleteUser(long userId);


    // 登录注册返回结果集

}
