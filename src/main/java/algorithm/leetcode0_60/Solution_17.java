package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
@Slf4j
public class Solution_17 {

    /**
     * 方法一：回溯
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
     * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。
     * 然后进行回退操作，遍历其余的字母排列。
     *
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
     * 在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     *
     * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     * 回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，
     * 就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。许多复杂的，
     * 规模较大的问题都可以使用回溯法，有“通用解题方法”的美称
     *
     */
    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character,String> phoneMap = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }
        };
        backtrack(phoneMap,combinations,digits,0,new StringBuffer());
        return combinations;
    }

    // 23
    // 巧妙之处在于index 为0及递归里的终止条件 index==digits.length()
    private void backtrack(Map<Character, String> phoneMap,List<String> combinations,String digits, int index, StringBuffer combination) {
        if(index==digits.length()){
            combinations.add(combination.toString());
        }else{
            Character ch = digits.charAt(index);
            String values = phoneMap.get(ch);
            for(int i=0;i<values.length();i++){
                combination.append(values.charAt(i));
                backtrack(phoneMap,combinations,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        Solution_17 solution17 = new Solution_17();
        List<String> str = solution17.letterCombinations("23");
        log.info("str:{}",str);
    }
}
