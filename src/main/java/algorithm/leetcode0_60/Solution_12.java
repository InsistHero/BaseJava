package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 *
 *
 */
@Slf4j
public class Solution_12 {

    Map<Integer,String> maps = new HashMap<Integer, String>();
    {
        maps.put(1,"I");
        maps.put(4,"IV");
        maps.put(5,"V");
        maps.put(9,"IX");
        maps.put(10,"X");
        maps.put(40,"XL");
        maps.put(50,"L");
        maps.put(90,"XC");
        maps.put(100,"C");
        maps.put(400,"CD");
        maps.put(500,"D");
        maps.put(900,"CM");
        maps.put(1000,"M");
    }


    public String intToRoman(int num) {

        if(!(1<=num && num<=3999)) return "";

        StringBuilder sb = new StringBuilder();

        while (num>0){
            if(num>=1000){
                sb.append(maps.get(1000));
                num = num - 1000;
            }else if(num>=900){
                sb.append(maps.get(900));
                num = num - 900;
            }else if(num>=500){
                sb.append(maps.get(500));
                num = num - 500;
            }else if(num>=400){
                sb.append(maps.get(400));
                num = num - 400;
            }else if(num>=100){
                sb.append(maps.get(100));
                num = num - 100;
            }else if(num>=90){
                sb.append(maps.get(90));
                num = num - 90;
            }else if(num>=50){
                sb.append(maps.get(50));
                num = num - 50;
            }else if(num>=40){
                sb.append(maps.get(40));
                num = num - 40;
            }else if(num>=10){
                sb.append(maps.get(10));
                num = num - 10;
            }else if(num>=9){
                sb.append(maps.get(9));
                num = num - 9;
            }else if(num>=5){
                sb.append(maps.get(5));
                num = num - 5;
            }else if(num>=4){
                sb.append(maps.get(4));
                num = num - 4;
            }else if(num>=1){
                sb.append(maps.get(1));
                num = num - 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_12 solution12 = new Solution_12();
        String s = solution12.intToRoman(1994);
        log.info("s:{}",s);//MCMXCIV
    }
}
