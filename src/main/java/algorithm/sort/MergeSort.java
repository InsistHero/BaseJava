package algorithm.sort;


import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 归并排序
 * 归并排序使用了递归分治的思想，所以理解起来比较容易。
 * 其基本思想是，先递归划分子问题，然后合并结果。把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。
 * 倒着来看，其实就是先两两合并，然后四四合并。
 * 最终形成有序序列。空间复杂度为O(n)，时间复杂度为O(nlogn)。
 *
 * https://zhuanlan.zhihu.com/p/124356219
 * https://github.com/francistao/LearningNotes/blob/master/Part3/Algorithm/Sort/%E9%9D%A2%E8%AF%95%E4%B8%AD%E7%9A%84%2010%20%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93.md
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/15 16:10
 */
@Slf4j
public class MergeSort {


    /**
     * 递归分治
     * @param arr 待排数组
     * @param left 左指针
     * @param right 右指针
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if(arr==null||arr.length<2) return;
        if(left >= right) return ;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid); //递归排序左边
        mergeSort(arr, mid+1, right); //递归排序右边
        merge(arr, left, mid, right); //合并
    }

    /**
     * 合并两个有序数组
     * @param arr 待合并数组
     * @param left 左指针
     * @param mid 中间指针
     * @param right 右指针
     *
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        //[left, mid] [mid+1, right]
        int[] temp = new int[right - left + 1]; //中间数组

        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= right) {
            temp[k++] = arr[j++];
        }

        for(int p=0; p<temp.length; p++) {
            arr[left + p] = temp[p];
        }

    }

    public static void main(String[] args) {
        int[] arr = {9,10,11,1,5,6,3};
        mergeSort(arr,0,arr.length-1);
        log.info("a:{}", JSONArray.toJSONString(arr));
    }

}
