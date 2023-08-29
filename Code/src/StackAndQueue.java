import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            // 0����
            if (head == null) {
                head = cur;
                tail = cur;
            }
            // һ����  ���������
//            else if( tail == head){
//                cur.next =head;
//                head =cur;
//                tail.last= head;
//            }
            // �����
            else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }

        }

        public T popFromHead() {
            // Ϊ�յ����
            if (head == null) {
                return null;
            }
//            T temp;
//            temp = head.value;
//            head.next.last = head.last;
//            head =head.next;
//            return  temp;
            Node<T> cur = head;
            // ���ҽ���һ�������
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;

        }

        public T popFromBottom() {
//            T temp;
//            temp = tail.value;
//            tail.last.next = tail.last;
//            tail =tail.last;
//            return  temp;
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public static class MyStack<T> {
            private DoubleEndsQueue<T> queue;

            public MyStack() {
                queue = new DoubleEndsQueue<T>();
            }

            public void push(T value) {
                queue.addFromHead(value);
            }

            public T pop() {
                return queue.popFromHead();
            }

            public boolean isEmpty() {
                return queue.isEmpty();
            }

        }

        public static class MyQueue<T> {
            private DoubleEndsQueue<T> queue;

            public MyQueue() {
                queue = new DoubleEndsQueue<T>();
            }

            public void push(T value) {
                queue.addFromHead(value);
            }

            public T poll() {
                return queue.popFromBottom();
            }

            public boolean isEmpty() {
                return queue.isEmpty();
            }

        }
    }


    // ��ջʵ�ֶ���
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        // pushջ��popջ��������
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            pushToPop();
            return stackPop.peek();
        }
    }

}



