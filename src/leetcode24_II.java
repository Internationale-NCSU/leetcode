public class leetcode24_II {
    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode front = head;
        ListNode rear = head.next;
        if(rear==null){
            return head;
        }else {
            head = rear;
        }
        while(true){
            if(rear==null){
                break;
            }
            front.next = rear.next;
            rear.next = sentinel.next;
            sentinel.next = rear;
            front = front.next;
            if(front==null){
                break;
            }else if(front.next!=null){
                rear = front.next;
            }else{
                break;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5,l4);
        ListNode l6 = new ListNode(6,l5);
        swapPairs(l6);
        while(l6!=null){
            System.out.print(l6.val+", ");
            l6 = l6.next;
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
