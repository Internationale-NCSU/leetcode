import org.junit.Test;

import java.util.jar.JarEntry;

public class leetcode369PlusOneLinkedList {
    int carrier = 1;
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode plusOne(ListNode head) {
        recursion(head);
        if(carrier==1){
            ListNode firstDig = new ListNode(1,head);
            return firstDig;
        }
        return head;
    }
    public void recursion(ListNode node){
        if(node.next!=null){
            recursion(node.next);
        }
        node.val = node.val+carrier;
        if(node.val>=10){
            carrier = 1;
        }else {
            carrier = 0;
        }
        node.val = node.val%10;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9,l1);
        ListNode l3 = new ListNode(9,l2);
        ListNode l4 = new ListNode(9,l3);
        ListNode l5 = new ListNode(9,l4);
        ListNode l6 = new ListNode(9,l5);
        ListNode result = plusOne(l6);
        while(result!=null){
            System.out.print(result.val+", ");
            result = result.next;
        }
    }
}
