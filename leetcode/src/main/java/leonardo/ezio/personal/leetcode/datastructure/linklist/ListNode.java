package leonardo.ezio.personal.leetcode.datastructure.linklist;

/**
 * @ClassName : ListNode
 * @Author : LeonardoEzio
 * @Date : 2021-04-20 22:50
 * @Description : Leet Code 链表题 通用数据结构
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
