package leonardo.ezio.personal.leetcode.algorithm.problem.T200_T400;

/**
 * @Description : Leetcode 234题 题解
 * @Author : LeonardoEzio
 * @Date: 2022-02-18 15:33
 */
public class Solution234 {

    class ListNode {

        int var;

        ListNode next;

        public ListNode() {
        }

        public ListNode(int var) {
            this.var = var;
        }

        public ListNode(int var, ListNode next) {
            this.var = var;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        //双指针 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //前半部分的反转指针
        ListNode reverse = null;

        //遍历反转前半部分
        while (true){
            //暂存slow下一个节点，最终让slow往下走
            ListNode node = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = node;

            //检测是否已经到达链表尾部
            if (fast.next == null){
                //到达尾部，并且链表长度为偶数
                break;
            }

            fast = fast.next.next;
            if (fast == null){
                //到达尾部，此时链表长度为奇数，slow节点需要下移一位，跳过中间节点
                slow = slow.next;
                break;
            }

        }

        //开始对比链表是否是回文链表
        while (slow != null && reverse != null){
            if (slow.var != reverse.var){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
