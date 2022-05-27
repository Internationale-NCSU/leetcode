import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class leetcode92 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode frontEnd = null;
        ListNode rearStart = null;
        ListNode reverseStart = null;
        ListNode reverseEnd = null;
        ListNode p = head;
        int count = 1;
        while(p!=null){
            if(count==left-1){
                frontEnd = p;
                reverseStart = p.next;
            }
            if(count==right){
                rearStart = p.next;
                reverseEnd = p;
                break;
            }
            p = p.next;
            count++;
        }
        Stack<ListNode> stack = new Stack<>();
        p = reverseStart;
        while(p!=rearStart){
            ListNode n = p;
            p = p.next;
            n.next = null;
            stack.push(n);
        }
        ListNode newStart = stack.pop();
        p = newStart;
        while(!stack.isEmpty()){
            p.next = stack.pop();
            p = p.next;
        }
        frontEnd.next = newStart;
        p.next = rearStart;
        return head;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5,l4);
        ListNode l6 = new ListNode(6,l5);
        reverseBetween(l6,2,4);
    }

}
