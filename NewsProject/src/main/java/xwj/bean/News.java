package xwj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xwj.service.news.NewsTempService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private String newsId;
    private String newsTitle;
    private String newsContent;
    private Date newsTimestamp;
    private String newsIcon;
    private String newsDesc;

    private int newsLevelId;
    private int newsTypeId;
    private String newsTag;
    private String author;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        int n = new Scanner(System.in).nextInt();
        Method[] methods = News.class.getMethods();
//        System.out.println(Arrays.toString(methods));
        Method getAuthor = News.class.getMethod("getAuthor");

        News news = News.class.getConstructor().newInstance();
        Object invoke = getAuthor.invoke(news);
        System.out.println(invoke);
//
//        int[][] agri = new int[100][100];
//        agri[1][1] = 1;
//        agri[2][1] = 1;
//        agri[2][2] = 1;
//
//        int i;
//        int j;
//        for (i = 3; i < agri.length; i++) {
//            for (j=0; j < i; j++) {
//                agri[i][j] = agri[i-1][j-1==-1?0:j-1]+agri[i-1][j];
//            }
//        }
//
//        System.out.println(Arrays.deepToString(agri));
//        /*
//         * 1
//         * 1 1
//         * 1 2 1
//         * 1 3 3 1
//         * 1 4 6 4 1
//         * 1 5 10 10 5 1
//         *
//         *
//         */


    }


}
