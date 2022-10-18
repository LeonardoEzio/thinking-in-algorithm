package leonardo.ezio.personal.leetcode.datastructure;


/**
 * @ClassName : MyLinkedList
 * @Author : LeonardoEzio
 * @Date : 2021-03-09 21:41
 * @Description : Leet code 707题 设计链表
 */
public class MyLinkedList {

    /**
     * 链表长度
     * */
    private int size = 0;

    /**
     * 头节点
     * */
    private MyNode head;

    /**
     * 尾节点
     * */
    private MyNode tail;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > size-1 || index <0){
            return -1;
        }
        if (index == 0){
            if (head == null){
                return -1;
            }
            return head.val;
        }
        if (index == size -1){
            return tail.val;
        }
        int cnt = 0;
        MyNode current = head;
        while (cnt != index){
            current = current.next;
            cnt++;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null){
            head = new MyNode(val, null);
            tail = head;
        }else {
            MyNode cur = new MyNode(val, head);
            head = cur;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyNode cur = new MyNode(val,null);
        if (size == 0){
            head = tail = cur;
        }else {
            tail.next = cur;
            tail = cur;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        int cnt = 1;
        MyNode pre = head;
        while (cnt != index){
            pre = pre.next;
            cnt++;
        }
        MyNode cur = new MyNode(val,pre.next);
        pre.next = cur;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size-1){
            return;
        }
        if (index == 0 || size == 1){
            head = head.next;
        }else {
            //寻找当前要删除的前一个节点
            int cnt = 0;
            MyNode pre = head;
            while (cnt+1 != index){
                pre = pre.next;
                cnt++;
            }
            MyNode cur = pre.next;
            //当前要删除节点是尾节点
            if (cur == tail){
                tail = pre;
                cur = null;
            }else {
                pre.next = cur.next;
                cur.next = null;

            }
        }
        size--;
    }

    private static class MyNode{

        private int val;

        private MyNode next;

        public MyNode(int val, MyNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(4);
        String[] op = new String[]{"MyLinkedList", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "get", "addAtTail", "addAtHead", "get", "addAtTail", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "get", "addAtIndex", "addAtHead", "get", "addAtHead", "deleteAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtHead", "addAtTail", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "deleteAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "deleteAtIndex", "get", "get", "addAtHead", "get", "addAtTail", "addAtTail", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "addAtTail", "get", "addAtIndex", "addAtHead", "deleteAtIndex", "addAtTail", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtTail", "addAtTail"};
        String[] pa = new String[]{"","38","66","61","76","26","37","8","5","4","45","4","85","37","5","93","10,23","21","52","15","47","12","6,24","64","4","31","6","40","17","15","19,2","11","86","17","55","15","14,95","22","66","95","8","47","23","39","30","27","0","99","45","4","9,11","6","81","18,32","20","13","42","37,91","36","10,37","96","57","20","89","18","41,5","23","75","7","25,51","48","46","29","85","82","6","38","14","1","12","42","42","83","13","14,20","17,34","36","58","2","38","33,59","37","15","64","56","0","40","92","63","35","62","32"};
        run(op,pa);
    }

    public static void run(String [] op , String [] pa){
        MyLinkedList linkedList = null;
        for (int i = 0; i < op.length; i++) {
            String operation = op[i];
            switch (operation){
                case "MyLinkedList":
                    linkedList = new MyLinkedList();
                    break;
                case "addAtHead":
                    linkedList.addAtHead(Integer.valueOf(pa[i]));
                    break;
                case "addAtIndex":
                    String[] split = pa[i].split(",");
                    linkedList.addAtIndex(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
                    break;
                case "addAtTail":
                    linkedList.addAtTail(Integer.valueOf(pa[i]));
                    break;
                case "get":
                    System.out.println(linkedList.get(Integer.valueOf(pa[i])));
                    break;
                case "deleteAtIndex":
                    linkedList.deleteAtIndex(Integer.valueOf(pa[i]));
                    break;
                default:
                    System.out.println("default");
            }

        }
    }
}
