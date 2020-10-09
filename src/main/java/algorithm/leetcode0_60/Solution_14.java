package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
@Slf4j
public class Solution_14 {

    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0){
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }

        String prefix = strs[0];

        for(int i = 1;i<strs.length;i++){
            prefix = getLongestCommonPrefix(prefix,strs[i]);
            if("".equals(prefix)) break;
        }
        return prefix;
    }

    private String getLongestCommonPrefix(String prefix, String str) {

        int len = Math.min(prefix.length(),str.length());//取最小串的长度

        int index = 0;
        while(index<len && prefix.charAt(index)==str.charAt(index)){
            index++;
        }
        return prefix.substring(0,index);
    }

    public static void main(String[] args) {
        //String[] strs = new String[]{"flower","flow","flight"};
        //String[] strs = new String[]{"dog","racecar","car"};
        String[] strs = new String[]{};
        Solution_14 solution14 = new Solution_14();
        String commonResult = solution14.longestCommonPrefix(strs);
        log.info("commonResult:{}",commonResult);
    }

}
