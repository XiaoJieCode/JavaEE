package xwj.util;

public class ExceptionUtil {
    public static void notNull(Object ...objects){
        for (Object object : objects) {
            if (null==object){
                throw new RuntimeException("参数为null");
            }
        }

    }
}
