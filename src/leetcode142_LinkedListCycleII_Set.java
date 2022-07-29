import java.util.HashSet;
import java.util.Set;

public class leetcode142_LinkedListCycleII_Set {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
