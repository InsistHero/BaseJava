package algorithm.sort;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 快速排序
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * 最佳情况：T(n) = O(nlogn)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(nlogn)
 * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)。
 *
 * @author zhijingzhuo
 * @since 2020/09/06 16:10
 */
@Slf4j
public class QuickSort {

    /**
     *
     *  快速排序 的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
     *  其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     *  算法描述
     *  快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     *  步骤1：从数列中挑出一个元素，称为 “基准”（pivot ）；
     *  步骤2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     *  步骤3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     */

    private static int[] quickSort(int[] arr,int low,int high) {

        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
        if(arr==null||arr.length<2){
            return arr;
        }

        if(high>low){
            int mid = getMiddle(arr,low,high);
            log.info("mid:{}",arr[mid]);
            quickSort(arr,low,mid-1);
            quickSort(arr,mid+1,high);
        }
        return arr;
    }

    private static int getMiddle(int[] arr,int low,int high) {

        int tmp = arr[low];
        while (high>low){
            while (tmp<arr[high] && high>low){
                high--;
            }
            arr[low] = arr[high];

            while (arr[low]<tmp && high>low){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = tmp;
        return high;

    }

    public static void main(String[] args) throws Exception{
        int[] a = {9,10,11,1,5,6,3};
        a = quickSort(a,0,a.length-1);
        log.info("a:{}", JSONArray.toJSONString(a));
    }


}
