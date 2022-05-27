public class leetcode61 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int length = 1;
        ListNode rear = head;
        while(rear.next!=null){
            rear = rear.next;
            length++;
        }
        if(length==1){
            return head;
        }
        //连首位
        rear.next = head;
        int cutPoint = k%length;
        ListNode cutLoc = head;
        //找到正数第length - cutPoint个元素为切割位置
        for (int i = 0; i < length-cutPoint-1; i++) {
            cutLoc = cutLoc.next;
        }
        head = cutLoc.next;
        cutLoc.next = null;
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5,null);
        ListNode l6 = new ListNode(6,l5);
        ListNode head =  rotateRight(l6,1);
        while(head!=null){
            System.out.print(head.val+", ");
            head = head.next;
        }
    }
}
