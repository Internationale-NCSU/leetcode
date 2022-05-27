public class leetcode82 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode stl = new ListNode(-1);
        stl.next = head;
        ListNode first = stl;
        ListNode second = head;
        while(second!=null&&second.next!=null){
            if(second.val==second.next.val){
                while(second.next.val==second.val&&second!=null){
                    second = second.next;
                }
                first.next = second.next;
                second = second.next;
            }else {
                first = second;
                second = second.next;
            }
        }
        return stl.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(2,l2);
        ListNode l4 = new ListNode(2,l3);
        ListNode l5 = new ListNode(2,l4);
        ListNode l6 = new ListNode(2,l5);
        deleteDuplicates(l6);
        while(l6!=null){
            System.out.print(l6.val+", ");
            l6 = l6.next;
        }
    }
}
