package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 */
@Slf4j
public class Solution_3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null){
            return 0;
        }
        if(" ".equals(s) || " ".equals(s.trim())){
            return 1;
        }

        HashSet<Character> set = new HashSet<Character>();
        int len = s.length();
        int resultLen = 0;
        int startIndex = -1;
        for(int i=0;i<len;i++){

            if(i!=0){
                set.remove(s.charAt(i-1));
            }

            while(startIndex+1<=len-1 && !set.contains(s.charAt(startIndex+1))){
                set.add(s.charAt(startIndex+1));
                startIndex++;
            }
            resultLen = Math.max(resultLen,startIndex+1-i);
        }

        return resultLen;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "abcaefgabcjklmnbb";
        //String s = " ";
        String s = "c";
        int result = lengthOfLongestSubstring(s);
        log.info("长度:{}",result);
    }
}
