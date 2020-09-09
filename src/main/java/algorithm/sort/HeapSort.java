package algorithm.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 堆排序
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 * 最佳情况：T(n) = O(nlogn)
 * 最差情况：T(n) = O(nlogn)
 * 平均情况：T(n) = O(nlogn)
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
     */


    private static int[] heapSort(int[] arr) {
        int len = arr.length;
        for(int i = len/2-1;i>=0;i--){
            adjustHeap(arr,i,len);
        }

        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
        return arr;
    }



    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param len
     */
    private static void adjustHeap(int[] arr, int i, int len) {

        int tmp = arr[i];

        for(int k = 2*i+1;k<len;k=2*k+1){
            if(k+1<len && arr[k]<arr[k+1]){
                k++;
            }

            if(arr[k]>tmp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = tmp;
    }

    // 交换元素
    private static void swap(int[] arr, int i, int j) {
        int tmp = 0;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {9,10,11,1,5,6,3,13,15};
        a = heapSort(a);
        log.info("a:{}", JSONArray.toJSONString(a));
    }

}
