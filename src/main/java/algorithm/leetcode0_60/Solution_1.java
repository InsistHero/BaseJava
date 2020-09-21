package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
@Slf4j
class Solution_1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        int len = nums.length;
        for(int i=0;i<len;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<len;i++){
            int other = target - nums[i];

            if(map.get(other)!=null){
                if(i!=map.get(other)){//排除 1个数字多次使用
                    result[0]=i;
                    result[1]=map.get(other);
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //int[] nums = new int[]{2,7,11,15};
        //int target = 9;
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum(nums,target);
        log.info("result:{}",result);
    }

}