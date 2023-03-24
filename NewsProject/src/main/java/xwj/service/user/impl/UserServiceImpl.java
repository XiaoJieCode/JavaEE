package xwj.service.user.impl;

import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xwj.bean.Result;
import xwj.bean.User;
import xwj.mapper.user.UserMapper;
import xwj.service.user.UserService;
import xwj.util.IdWorker;
import xwj.util.MD5;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private IdWorker idWorker; // 雪花id生成器



    // 登录注册返回结果集

    @Resource
    UserMapper userMapper; // mybatis接口映射代理对象



    @Override
    public Result<User> login(User user){
        Result<User> result = new Result<>();
        // 进一步判空
        if (user==null){
            result.setMessage("登录失败,传入参数为空");
            result.setData(null);
            return result;
        }

        if (user.getUsername()==null||user.getUsername().trim().equals("")){
            result.setMessage("登录失败,用户名为空");
            result.setData(null);
            return result;
        }
        if (user.getPassword()==null||user.getPassword().trim().equals("")){
            result.setMessage("登录失败,密码为空");
            result.setData(null);
            return result;
        }

        // 从数据库查询用户名是否存在
        if (userMapper.selectUsername(user)==null) {
            result.setMessage("用户名不存在");
            result.setData(null);
            return result;
        }
        // 进一步加密
        user.setPassword(MD5.getMd5(user.getPassword()));

        // 数据库检查用户名和密码是否匹配
        User selectUser = userMapper.selectUsernameAndPassword(user);
        if (selectUser ==null){
            result.setMessage("密码错误");
            result.setData(null);
            return result;
        }
        result.setMessage("登陆成功");
        result.setData(selectUser);
        return result;
    }

    // 注册业务逻辑：传入加密后的bean对象，
    // 并判断数据库中是否已存在username，
    // 如存在则注册失败，如不存在则插入数据库
    @Override
    public Result<User> register(User user){
        Result<User> result = new Result<>();
//        进一步判空
        if (user==null){
            result.setMessage("注册失败,传入参数为空");
            result.setData(null);
            return result;
        }

        if (user.getUsername()==null||user.getUsername().trim().equals("")){
            result.setMessage("注册失败,用户名为空");
            result.setData(null);
            return result;
        }
        if (user.getPassword()==null||user.getPassword().trim().equals("")){
            result.setMessage("注册失败,密码为空");
            result.setData(null);
            return result;
        }

        // 从数据库查询用户名是否存在
        if (userMapper.selectUsername(user)!=null) {
            result.setData(null);
            result.setMessage("注册失败,用户名已存在");
            return result;
        }
//         用户名存在则加密密码,
        user.setPassword(MD5.getMd5(user.getPassword()));
        // 生成雪花id作为用户的唯一标识
        long l = idWorker.nextId();
        user.setUserId(String.valueOf(l));
        // 插入数据库
        if(userMapper.insertUser(user)==1){
            user.setPassword(null);
            result.setData(user);
            result.setMessage("注册成功");
        }else {
            result.setMessage("注册失败");
            result.setData(null);
        }
        return result;
    }

    @Override
    public User getById(long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    public List<User> getAllUser(long userId) {
        return userMapper.getAllUser();
    }

    @Override
    public int deleteUser(long userId) {
        return userMapper.deleteUserById(userId);
    }

//
//    public Result<User> login(String username, String password){
//        User user = new User();
//        Result<User> result = new Result<>();
////        判空
//        if (username==null||username.trim().equals("")){
//            result.setMessage("登录失败,用户名为空");
//            result.setData(null);
//            return result;
//        }
//        if (password==null||password.trim().equals("")){
//            result.setMessage("登录失败,密码为空");
//            result.setData(null);
//            return result;
//        }
//        user.setUsername(username);
//        // md5加密
//        user.setPassword(MD5.getMd5(password));
//        user.setUsername(username);
//        // 调用后端登录业务
//        return login(user);
//    }

//    public Result<User> register(String username, String password){
//        User user = new User();
//        Result<User> result = new Result<>();
//        if (username==null||username.trim().equals("")){//        判空
//            result.setMessage("注册失败,用户名为空");
//            result.setData(null);
//            return result;
//        }
//        if (password==null||password.trim().equals("")){
//            result.setMessage("注册失败,密码为空");
//            result.setData(null);
//            return result;
//        }
//        user.setUsername(username);
//        user.setPassword(MD5.getMd5(password));
//        return register(user);// 调用后端注册接口
//    }
}
