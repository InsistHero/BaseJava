package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 */
@Slf4j
public class Solution_4 {

    /**
     * len = 5
     * i=0 [0,0] [1,1] [2,2] [3,3]  <5-i
     * i=1 [0,1] [1,2] [2,3]        <5-i
     * i=2 [0,2] [1,3]              <5-i
     *
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int len = s.length();
        String ans = "";
        boolean[][] equals = new boolean[len][len];

        for(int i=0;i<len;i++){ //步长
            for(int j=0;j<len-i;j++){
                if(i==0){ //初始化对角线
                    equals[j][j+i] = true;
                }else if(i==1){ // 初始化步长为1的记录
                    equals[j][j+i] = s.charAt(j)==s.charAt(j+i)?true:false;
                }else{// 初始化 非对角线或者步长不为1的记录
                    equals[j][j+i] = equals[j+1][j+i-1] && s.charAt(j)==s.charAt(j+i);
                }
                if(equals[j][j+i] && i+1>ans.length()){
                    ans = s.substring(j,j+i+1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        //String s = "a";
        //String s = "bb";

        String result = longestPalindrome(s);
        log.info("result:{}",result);
    }

}
