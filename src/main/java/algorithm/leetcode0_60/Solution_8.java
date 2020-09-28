package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * "   -32 1 "
 *
 */

@Slf4j
public class Solution_8 {

    private static int BLANK_SIGN = 32;// 空格
    private static int PLUS_SIGN = 43;// 正号
    private static int NEGATIVE_SIGN = 45;// 负号

    // 32 空格  43 +   45 -    48～57  0-9
    public static int myAtoi(String str) {

        if(str==null || "".equals(str.trim())) return 0;
        if(str.isEmpty()) return 0;

        StringBuilder result = new StringBuilder();
        char[] charArrays = str.toCharArray();
        for(int i=0;i<charArrays.length;i++){
            char c = charArrays[i];
            if(c!=BLANK_SIGN){// 非空字符
                if(c==PLUS_SIGN || c==NEGATIVE_SIGN){
                    if(result.length()>0) break;//说明正负号出现在 下表为 0 之外的位置
                    result.append(c);
                }else if(Character.isDigit(c)) {
                    result.append(c);
                }else{
                    break;
                }
            }else{
                if(result.toString().length()>=1){//result中存在有效字符时,遇到空代表结束
                    break;
                }
                continue;
            }

        }

        if(result.toString().length()==0){
            return 0;
        }else if(result.toString().length()==1 && (result.toString().charAt(0)==PLUS_SIGN || result.toString().charAt(0)==NEGATIVE_SIGN)){
            return 0;
        }else{
            String re = result.toString();
            try{
                return Integer.valueOf(re);
            }catch (NumberFormatException e){
                if(re.charAt(0)==45){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }

    }

    public static void main(String[] args) {
        log.info("int max:{}",Integer.MAX_VALUE);
        log.info("int min:{}",Integer.MIN_VALUE);

        //String s ="42";
        //String s ="-42";
        //String s ="4193 with words";
        //String s ="words and 987";
        //String s ="-91283472332";
        //String s ="-91283472332";
        //String s ="+-2";
        //String s = "20000000000000000000";
        //String s = "2147483648";
        String s = "-   234";

        int re = myAtoi(s);
        log.info("int re:{}",re);

    }
}
