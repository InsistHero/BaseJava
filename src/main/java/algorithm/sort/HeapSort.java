package algorithm.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 堆排序
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/06 16:10
 */
@Slf4j
public class HeapSort {

    /**
     *
     * 该数组从逻辑上讲就是一个堆结构，我们用简单的公式来描述一下堆的定义就是：
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     *
     *
     */
    private static int[] heapSort(int[] a, int i, int i1) {

        return  null;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {9,10,11,1,5,6,3};
        a = heapSort(a,0,a.length-1);
        log.info("a:{}", JSONArray.toJSONString(a));
    }

}
