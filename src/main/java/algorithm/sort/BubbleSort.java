package algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 冒泡排序
 * @author zhijingzhuo
 * @since 2020/09/05 16:10
 */
@Slf4j
public class BubbleSort {

    /**
     * 0.如果遇到相等的值不进行交换，那这种排序方式是稳定的排序方式。
     *
     * 1.原理：比较两个相邻的元素，将值大的元素交换到右边
     *
     * 2.思路：依次比较相邻的两个数，将比较小的数放在前面，比较大的数放在后面。
     *
     * 　　　　(1)第一次比较：首先比较第一和第二个数，将小数放在前面，将大数放在后面。
     *
     * 　　　　(2)比较第2和第3个数，将小数 放在前面，大数放在后面。
     *
     * 　　　　......
     *
     * 　　　　(3)如此继续，知道比较到最后的两个数，将小数放在前面，大数放在后面，重复步骤，直至全部排序完成
     *
     * 　　　　(4)在上面一趟比较完成后，最后一个数一定是数组中最大的一个数，所以在比较第二趟的时候，最后一个数是不参加比较的。
     *
     * 　　　　(5)在第二趟比较完成后，倒数第二个数也一定是数组中倒数第二大数，所以在第三趟的比较中，最后两个数是不参与比较的。
     *
     * 　　　　(6)依次类推，每一趟比较次数减少依次
     *
     * 3.(1)由此可见：N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
     */

    private static int[] bubbleSort(int[] arr) {

        //一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
        if(arr==null||arr.length<2){
            return arr;
        }

        for(int i = 0;i<arr.length-1;i++){
            for( int j=0;j<arr.length-(i+1);j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {9,10,11,1,5,6,3};
        a = bubbleSort(a);
        log.info("a:{}",JSONArray.toJSONString(a));
    }
}
