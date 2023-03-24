package xwj.controller.user;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import xwj.bean.User;
import xwj.bean.Result;
import xwj.controller.Code;
import xwj.controller.Message;
import xwj.service.user.UserService;
import xwj.service.user.impl.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/{userId}")
    public Result<User> getUserById(@PathVariable long userId) {
        Result<User> result = new Result<>();
        try {
            User user = userService.getById(userId);
            if (user == null) {
                throw new RuntimeException("根据用户id获取用户失败，传入的userId：" + userId);
            }
            result.setData(user);
            result.setCode(Code.GET_OK);
            result.setMessage(Message.GET_USER_OK_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(Code.GET_ERR);
            result.setMessage(Message.GET_USER_ERR_MESSAGE);
        }
        return result;
    }

    @PostMapping("/login")
    public Result<User> login(User user) {
        Result<User> result = new Result<>();
        try {
            Result<User> login = userService.login(user);
            if (login.getData() == null) {
                result.setCode(Code.GET_ERR);
            } else {
                result.setCode(Code.GET_OK);
            }
            result.setMessage(login.getMessage());
            result.setData(login.getData());
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(Code.GET_ERR);
            result.setMessage(Message.GET_USER_ERR_MESSAGE);
        }
        return result;
    }

    @DeleteMapping("/{userId}")
    public Result<Boolean> deleteUserById(@PathVariable long userId) {
        Result<Boolean> result = new Result<>();
        try {
            int i = userService.deleteUser(userId);
            if (i != 1) {
                throw new RuntimeException("根据用户id获取用户失败，传入的userId：" + userId);
            }
            result.setData(true);
            result.setCode(Code.DELETE_OK);
            result.setMessage(Message.UPDATE_USER_OK_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            result.setData(false);
            result.setCode(Code.DELETE_ERR);
            result.setMessage(Message.UPDATE_USER_ERR_MESSAGE);
        }
        return result;
    }

    @PutMapping("/register")
    public Result<User> addUser(@RequestBody User user) {
        Result<User> result = new Result<>();
        try {
            Result<User> register = userService.register(user);

            if (register.getData() == null) {
                result.setCode(Code.SAVE_ERR);
            } else {
                result.setCode(Code.SAVE_OK);
            }
            result.setMessage(register.getMessage());
            result.setData(register.getData());
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(Code.SAVE_ERR);
            result.setMessage(Message.UPDATE_USER_ERR_MESSAGE);
        }
        return result;
    }

    @PostMapping
    public Result<User> updateUser(@RequestBody User user) {
        Result<User> result = new Result<>();
        try {


        } catch (Exception e) {
            e.printStackTrace();


        }
        return result;
    }

}
