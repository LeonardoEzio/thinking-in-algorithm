package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution147
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:54
 * @Description : Leet code 147题 题解
 * <p>
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * <p>
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution147 {

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //result 引用原始链表 为了方便后续再已排序链表中寻找插入位置
        ListNode result = new ListNode(-1);
        result.next = head;
        //最后一个已排序节点
        ListNode lastSorted = head;
        //当前需要排序的节点
        ListNode current = head.next;
        while (current != null){
            //如果最后一个已排序节点的值小于当前需要排序的节点值，则不需要做任何操作，移动指针即可
            if (lastSorted.val<= current.val){
                lastSorted = lastSorted.next;
            }else {
                //如最后一个已排序节点的值大于当前插入节点的值，则从result里面寻找插入点
                //ListNode pre = result.next;
                //while (pre.val <= current.val){
                //    pre = pre.next;
                //}
                ListNode pre = result;
                while (pre.next.val <= current.val){
                    pre = pre.next;
                }
                //寻找到插入点
                //将最后一个已排序点更新为当前节点
                lastSorted.next = current.next;
                //插入
//                current.next = pre;
//                pre.next = lastSorted.next;
                current.next = pre.next;
                pre.next = current;

            }
            //将当前需要排序的节点更正为 最后一个已排序节点的下一节点
            current = lastSorted.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ListNode node = insertionSortList(node1);
        while (node != null){
            System.out.print(node.val);
            node = node.next;
        }
    }
}
