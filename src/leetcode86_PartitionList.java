import org.junit.Test;

import java.util.List;

public class leetcode86_PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode stl = new ListNode();
        stl.next = head;

        ListNode before = new ListNode();
        ListNode beforeHead = before;
        ListNode after = new ListNode();
        ListNode afterHead = after;
        while(head.next!=null){
            if(head.val<x){
                before.next = head;
                head = head.next;
                before = before.next;

            }else {
                after.next = head;
                head = head.next;
                after = after.next;
                after.next = null;
            }
        }
        before.next = afterHead.next;
        return beforeHead;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5,l1);
        ListNode l3 = new ListNode(2,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(4, l4);
        ListNode l6 = new ListNode(1,l5);

        ListNode result = partition(l6,3);
        ListNode p = result;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }

}
