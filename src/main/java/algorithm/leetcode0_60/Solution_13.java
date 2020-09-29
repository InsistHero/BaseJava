package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution_13 {

    /**
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    public static int romanToInt(String s) {
        int[] vals = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int totalNum = 0;
        for(int i = 0;i<romans.length;i++){
            while (s.startsWith(romans[i])){
                s = s.substring(romans[i].length());
                totalNum = totalNum + vals[i];
            }
        }

        return totalNum;
    }

    public static void main(String[] args) {
        //String s = "III";
        //String s = "IV";
        //String s = "IX";
        String s = "LVIII";
        //String s = "MCMXCIV";
        int result = romanToInt(s);
        log.info("result:{}",result);
    }
}
