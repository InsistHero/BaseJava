package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 */
@Slf4j
public class Solution_11 {

    // 双指针解决  [ 1 7 3 5 4 7]
    public static int maxArea(int[] ints) {

        if(ints.length < 1) return 0;

        int start = 0;
        int end = ints.length-1;

        int maxArea = 0;

        while(end > start){
            int span = end-start;
            maxArea = Math.max(maxArea,Math.min(ints[start],ints[end]) * span);

            if(ints[end] > ints[start]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(ints);
        log.info("maxArea:{}",maxArea);
    }

}
