package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 */
@Slf4j
public class Solution_7 {


    // 1321  -->  1231
    public static int reverse(int x) {

        int last = 0;//反转的数字
        int result = 0;// 最后反转后的整数

        // 1321  [1,132] [2,13] [3,1] [1,0]
        while(x != 0){
            last = x % 10;
            x = x / 10;

            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && last>7)) return 0;
            if(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && last<-8)) return 0;

            result = result * 10 + last;
        }
        return result;
    }


    public static void main(String[] args) {
        int result = reverse(1463847412);
        log.info("result:{}",result);
        log.info("int max:{}",Integer.MAX_VALUE);
        log.info("int min:{}",Integer.MIN_VALUE);
        log.info("long max:{}",Long.MAX_VALUE);
        log.info("long min:{}",Long.MIN_VALUE);

    }
}
