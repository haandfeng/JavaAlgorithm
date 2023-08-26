public class LinkList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }
    // 反转单链
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next =null;
        while (head!=null){
            next = head.next;
            head.next =pre;
            pre = head;
            head =next;

        }
        // 注意return什么
        return pre;
    }
    //反转双链
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next =null;
        while (head!=null){
            next = head.next;
            pre = head.last;
            head.next = pre;
            head.last = next;
            head =next;
        }
        return pre;
    }
    // 删掉链表的某一个值
//    public static Node removeValue(Node head, int num) {
//        Node temp =head;
//        while (temp != null){
//            if (temp.value== num){
//                if (temp == head){head= head.next;}
//                else if (temp.next != null) {temp.next = temp.next.next;}
//                else {temp =null;}
//                return head;
//            }
//            temp =temp.next;
//        }
//        return head;
//    }


    // 删哪一个数要有清晰的认识，删错了删了要删的下一个数
    //注意头节点

    public static Node removeValue(Node head, int num) {
        // head来到第一个不需要删的位置, 作为最后链表的头结点
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
