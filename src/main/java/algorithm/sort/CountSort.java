package algorithm.sort;


import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 计数排序
 *
 * 计数排序是一个非基于比较的排序算法。
 * 它的优势在于在对一定范围内的整数排序时，它的复杂度为Ο(n+k)（其中k是整数的范围），快于任何比较排序算法。
 * 当然这是一种牺牲空间换取时间的做法，而且当O(k)>O(n*log(n))的时候其效率反而不如基于比较的排序
 * （基于比较的排序的时间复杂度在理论上的下限是O(n*log(n)), 如归并排序，堆排序）
 *
 * 虽然计数排序看上去很强大，但是它存在两大局限性：
 * 1.当数列最大最小值差距过大时，并不适用于计数排序
 *   比如给定20个随机整数，范围在0到1亿之间，此时如果使用计数排序的话，就需要创建长度为1亿的数组，不但严重浪费了空间，而且时间复杂度也随之升高。
 *
 * 2.当数列元素不是整数时，并不适用于计数排序
 *   如果数列中的元素都是小数，比如3.1415，或是0.00000001这样子，则无法创建对应的统计数组，这样显然无法进行计数排序。
 *
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

        // 创建统计数组并计算统计对应元素个数
        for(int i=0;i<arr.length;++i){
            c[arr[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }

        // 统计数组变形，后面的元素等于前面的元素之和
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }

        // 倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组
        for(int i=arr.length-1;i>=0;--i){
            b[--c[arr[i]-min]]=arr[i];//按存取的方式取出c的元素
        }
        return b;

    }

    public static void main(String[] args) {
        int[] a = {9,10,11,1,5,6,3};
        a = countSort(a);
        log.info("a:{}", JSONArray.toJSONString(a));
    }


}
