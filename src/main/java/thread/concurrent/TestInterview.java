package thread.concurrent;

import java.util.Calendar;

public class TestInterview {

    private static  int i = 0;

    public static void main1(String[] args) {
        plus(i);
        i = i++;
        System.out.println("i:"+i);
    }

    private static void plus(int i) {
        i++;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一
        //cal.set(Calendar.HOUR_OF_DAY, 0);
        //cal.clear(Calendar.MINUTE);
        //cal.clear(Calendar.SECOND);
        System.out.println("i:"+cal.getTime());
    }
}
