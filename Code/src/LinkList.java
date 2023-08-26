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
    // ��ת����
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next =null;
        while (head!=null){
            next = head.next;
            head.next =pre;
            pre = head;
            head =next;

        }
        // ע��returnʲô
        return pre;
    }
    //��ת˫��
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
    // ɾ�������ĳһ��ֵ
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


    // ɾ��һ����Ҫ����������ʶ��ɾ����ɾ��Ҫɾ����һ����
    //ע��ͷ�ڵ�

    public static Node removeValue(Node head, int num) {
        // head������һ������Ҫɾ��λ��, ��Ϊ��������ͷ���
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
