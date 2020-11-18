package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 * 给定一个包括n 个整数的数组nums和 一个目标值target。
 * 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
@Slf4j
public class Solution_16 {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int result= 10000000;

        for(int first=0;first<len;first++){
            if(first>0 && nums[first]==nums[first-1]) continue;
            int second = first+1;
            int third = len-1;
            while(second<third){
                int totalValue = nums[first]+nums[second]+nums[third];
                if(totalValue==target) return target;
                if(totalValue>target){
                    third--;
                    if(Math.abs(totalValue-target)<Math.abs(target-result)){
                        result = totalValue;
                    }
                }else{
                   second++;
                   if(Math.abs(totalValue-target)<Math.abs(target-result)){
                       result = totalValue;
                   }
               }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1,2,1,-4};
        int target = 1;
        //int[] ints = new int[]{1,1,1,0};
        //int target = 100;
        //int[] ints = new int[]{1,2,4,8,16,32,64,128};
        //int target = 82;
        Solution_16 solution16 = new Solution_16();
        int result = solution16.threeSumClosest(ints,target);
        log.info("result:{}",result);
    }
}
