import java.util.Scanner;

/**
 * 对控制台输入代码进行封装成工具类，简化后续代码
 */
public class Util {
    //控制台输入数字的获取
    public static int getInputNumber(String msg, Scanner scanner){
        System.out.println(msg);
        return scanner.nextInt();
    }

    //控制台输入字符串的获取
    public static  String getInputString(String msg, Scanner scanner){
        System.out.println(msg);
        return scanner.next();
    }
}
