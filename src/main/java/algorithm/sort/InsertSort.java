package algorithm.sort;


import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 插入排序
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/05 16:10
 */
@Slf4j
public class InsertSort {


    /**
     *
     * 插入排序不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的。
     *
     */
    private static int[] insertSort(int[] arr){

        for(int i=1; i<arr.length; i++) { //假设第一个数位置时正确的；要往后移，必须要假设第一个。

            int j = i;
            int target = arr[i]; //待插入的
            //后移
            while(j>0 && target<arr[j-1] ) {
                arr[j] = arr[j-1];
                j --;
            }

            //插入
            arr[j] = target;
        }


        return arr;
    }


    public static void main(String[] args) {
        int[] a = {9,10,11,1,5,6,3};
        a = insertSort(a);
        log.info("a:{}", JSONArray.toJSONString(a));
    }
}
