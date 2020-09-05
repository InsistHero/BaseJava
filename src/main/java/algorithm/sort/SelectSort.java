package algorithm.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 直接选择排序 [ 冒泡的改进版 ]  选择排序算法有两种：直接选择排序和堆排序
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/05 16:10
 */
@Slf4j
public class SelectSort {

    /**
     *
     * 直接选择排序（Straight Select Sort）算法思想：
     * 第一趟从n个元素的数据序列中选出关键字最小/大的元素并放在最前/后位置，
     * 下一趟从n-1个元素中选出最小/大的元素并放在最前/后位置。以此类推，经过n-1趟完成排序。
     *
     */


    private static int[] selectSort(int[] arr){

        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
        if(arr==null||arr.length<2){
            return arr;
        }

        int tmp;
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = {9,10,11,1,5,6,3};
        a = selectSort(a);
        log.info("a:{}", JSONArray.toJSONString(a));
    }

}
