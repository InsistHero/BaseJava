package algorithm.leetcode121_180;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */
@Slf4j
public class Solution_141 {


    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null){
            return false;
        }

        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode!=slowNode){
            if(fastNode == null|| fastNode.next == null) return false;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_141 solution141 = new Solution_141();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = node1;
        Boolean flag = solution141.hasCycle(node1);
        log.info("flag:{}",flag);
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
