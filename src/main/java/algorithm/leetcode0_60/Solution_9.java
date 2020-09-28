package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 */
@Slf4j
public class Solution_9 {

    // 按照这2种情况 12321   123321
    public static boolean isPalindrome(int x) {

        // 负数 和 取余=0 肯定不是回文数
        if(x<0 || (x>0 && x%10==0)){
            return false;
        }

        int revertedNumber = 0;

        while(x>revertedNumber){
            int remainder = x % 10;
            revertedNumber = revertedNumber * 10 + remainder;

            x = x / 10;
        }

        return x==revertedNumber/10 || x==revertedNumber;
    }

    public static void main(String[] args) {
        boolean flag = isPalindrome(10);
        log.info("flag:{}",flag);
    }

}
