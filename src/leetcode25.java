import java.util.List;

public class leetcode25 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(5,l1);
        ListNode l3 = new ListNode(4,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(2,l4);
        ListNode l6 = new ListNode(1,l5);

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
