import java.util.HashSet;
import java.util.Set;

public class leetcode141 {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p!=null){
            if(set.contains(p)){
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }

}
