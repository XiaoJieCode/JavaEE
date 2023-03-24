package xwj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 表的映射类
public class User {
    // 雪花id作为用户主键
    private String userId;
    private String username;
    // MD5加密后储存到数据库中
    private String password;
}
