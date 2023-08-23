import org.junit.Test;

public class leetcode234_PalindromeLinkedList {
    ListNode front;
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean recurCheckPalindrome(ListNode l){
        if(l!=null){
            if(!recurCheckPalindrome(l.next)) {
                return false;
            }
            if(l.val!=front.val){
                return false;
            }
            front = front.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        front = head;
        return recurCheckPalindrome(head);
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(2,l4);
        ListNode l6 = new ListNode(1,l5);
        System.out.println(isPalindrome(l6));
    }
}
