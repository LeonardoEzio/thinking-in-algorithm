package leonardo.ezio.algorithm.leetcode.problem;

/**
 * @ClassName : Solution21
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:48
 * @Description : Leet code 21题 题解
 *
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */
public class Solution21 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
    * description : <递归实现>
    *
    * @methodName : mergeTwoLists
    * @param l1 链表1
    * @param l2 链表2
    * @return {@link ListNode }
    * @date : 2020/11/20 22:50
    **/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return  l2;
        }else if (l2 == null){
            return  l1;
        }else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
    * description : <迭代实现>
    *
    * @methodName : mergeTwoLists2
    * @param l1 链表1
    * @param l2 链表2
    * @return {@link ListNode }
    * @date : 2020/11/20 22:53
    **/
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pre = result;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            //将结果连接起来
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node1_1 = new ListNode(2);
        ListNode node1_2 = new ListNode(4);
        node1_1.next = node1_2;
        node1.next = node1_1;


        ListNode node2 = new ListNode(1);
        ListNode node2_1 = new ListNode(3);
        ListNode node2_2 = new ListNode(4);
        node2_1.next = node2_2;
        node2.next = node2_1;

        ListNode node = mergeTwoLists(node1, node2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
