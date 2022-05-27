public class leetcode19_II {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode stl = new ListNode();
        stl.next = head;
        ListNode front = stl;
        ListNode rear = stl.next;
        int count = 0;
        while(rear.next!=null){
            if(count<n-1){
                rear = rear.next;
                count++;
            }else {
                rear = rear.next;
                front = front.next;
            }
        }
        front.next = front.next.next;
        return stl.next;
    }
    public static void main(String[] args) {


        ListNode _l6 = new ListNode(1);

        ListNode merge = removeNthFromEnd(_l6,6);
        while(merge!=null){
            System.out.print(merge.val+",");
            merge = merge.next;
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
