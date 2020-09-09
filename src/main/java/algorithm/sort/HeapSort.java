package algorithm.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 堆排序是一种选择排序，整体主要由【构建初始堆】+【交换堆顶元素和末尾元素并重建堆】两部分组成。
 * 其中构建初始堆经推导复杂度为O(n)，
 * 在交换并重建堆的过程中，需交换n-1次，而重建堆的过程中，
 * 根据完全二叉树的性质，[log2(n-1),log2(n-2)...1]逐步递减，近似为nlogn。
 * 所以堆排序时间复杂度一般认为就是O(nlogn)级。
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 * 最佳情况：T(n) = O(nlogn)
 * 最差情况：T(n) = O(nlogn)
 * 平均情况：T(n) = O(nlogn)
 *
 * 不稳定排序
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
     * [比较 实质上是比较每个节点、子节点中的最大节点比较（下面通过index 移动来指向子节点中的最大值）]
     * @param arr
     * @param i
     * @param len
     */
    private static void adjustHeap(int[] arr, int i, int len) {

        int tmp = arr[i];//先取出当前元素i
        for(int k = 2*i+1;k<len;k=2*k+1){

            if(k+1<len && arr[k]<=arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k]>=tmp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = tmp;//将temp值放到最终的位置
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
