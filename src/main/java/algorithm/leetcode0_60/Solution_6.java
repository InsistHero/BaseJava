package algorithm.leetcode0_60;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIR ETOESIIG EDHN"。
 *
 * */

@Slf4j
public class Solution_6 {

    public static String convert(String s, int numRows) {

        return null;
    }

    public static void main(String[] args) {
        String param = "LEETCODEISHIRING";
        String result = convert(param,3);
        log.info("result:{}",result);
    }
}
