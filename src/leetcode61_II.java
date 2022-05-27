public class leetcode61_II {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }
        ListNode last = new ListNode();
        ListNode stl = new ListNode();
        stl.next = head;
        while(head!=null){
            last = head;
            head = head.next;
        }
        last.next = stl.next;
        int n = 0;
        head = stl.next;
        while(n<k){
            n++;
            head = head.next;
        }
        stl.next = head.next;
        head.next = null;
        return stl.next;
    }
    public static void main(String[] args) {
        //6,5,4,3,2,1
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(4,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1,l5);

        ListNode node = rotateRight(l6,1);
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
