package algorithm.leetcode0_60;

import lombok.extern.slf4j.Slf4j;

/**
 *
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
@Slf4j
class Solution_2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int next = 0;// 下一进位
        ListNode result = null;
        ListNode curNode = null;

        while (l1!=null || l2!=null){
            int val1 = 0;
            int val2 = 0;
            int cur = 0;

            if(l1!=null){
                val1 = l1.val;
            }

            if(l2!=null){
                val2 = l2.val;
            }

            int total = val1 + val2 + next;
            next = total/10;
            cur = total%10;

            if(result==null){
                result = new ListNode(cur);

                curNode = result;
            }else{
                ListNode res = new ListNode(cur);

                curNode.next = res;
                curNode = curNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(node1,node2);
        while(result!=null){
            log.info(result.val+"");
            result = result.next;
        }

    }

}


