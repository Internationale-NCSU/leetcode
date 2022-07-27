public class leetcode19_RemoveNthNodeFromEndofList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null||head==null) {
            return null;
        }
        ListNode quickPointer = head;
        ListNode slowPointer = head;
        for (int i = 0; i < n; i++) {
            quickPointer = quickPointer.next;
        }
        if(quickPointer==null){
            return head.next;
        }
        while(quickPointer.next!=null){
            slowPointer = slowPointer.next;
            quickPointer = quickPointer.next;

        }
        slowPointer.next = slowPointer.next.next;

        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,null);
        ListNode l5 = new ListNode(5,l4);
        ListNode l6 = new ListNode(6,l5);
        l6 =  removeNthFromEnd(l6,3);
        while(l6!=null){
            System.out.println(l6.val+",");
            l6 = l6.next;
        }
    }
}
