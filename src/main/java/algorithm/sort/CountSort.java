package algorithm.sort;


import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 计数排序
 *
 * 虽然计数排序看上去很强大，但是它存在两大局限性：
 *
 * 1.当数列最大最小值差距过大时，并不适用于计数排序
 *   比如给定20个随机整数，范围在0到1亿之间，此时如果使用计数排序的话，就需要创建长度为1亿的数组，不但严重浪费了空间，而且时间复杂度也随之升高。
 *
 * 2.当数列元素不是整数时，并不适用于计数排序
 *   如果数列中的元素都是小数，比如3.1415，或是0.00000001这样子，则无法创建对应的统计数组，这样显然无法进行计数排序。
 * 正是由于这两大局限性，才使得计数排序不像快速排序、归并排序那样被人们广泛适用。
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/06 16:10
 */
@Slf4j
public class CountSort {


    public static int[] countSort(int[] arr) {
        int b[] = new int[arr.length];
        int max = arr[0];
        int min = arr[0];
        for(int i:arr){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<arr.length;++i){
            c[arr[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        for(int i=arr.length-1;i>=0;--i){
            b[--c[arr[i]-min]]=arr[i];//按存取的方式取出c的元素
        }
        return b;

    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            if(ele > max)
            max = ele;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {9,10,11,1,5,6,3};
        a = countSort(a);
        log.info("a:{}", JSONArray.toJSONString(a));
    }


}
