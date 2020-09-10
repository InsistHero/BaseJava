package algorithm.sort;


import lombok.extern.slf4j.Slf4j;

/**
 * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 *
 * 比较各自的优劣、各种算法的思想及其使用场景。还有要会分析算法的时间和空间复杂度
 *
 * @author zhijingzhuo
 * @since 2020/09/09 16:10
 */
@Slf4j
public class ShellSort {

}
