import java.util.List;

public class leetcode1290 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public void add(int x) {
            if (next == null) {
                next = new ListNode(x);
            } else {
                this.next.add(x);
            }
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] arr = {1, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head.val = arr[i];
            } else
                head.add(arr[i]);
        }


        System.out.println("result:" + getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        int result = 0;
        while (true) {
            result = result * 2 + head.val;
            //System.out.println("__result:"+result+" val:"+head.val);
            if (head.next == null) break;
            head = head.next;
        }
        return result;
    }
}
