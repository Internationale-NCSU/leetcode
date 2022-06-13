
import java.util.List;
import java.util.ListIterator;

public class leetcode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryBit = 0;
        ListNode stl = new ListNode();
        stl.next = l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = stl;
        while(p1!=null||p2!=null){
            int x = (p1!=null)? p1.val : 0;
            int y = (p2!=null)? p1.val : 0;
            int sum = x+y+carryBit;
            carryBit = sum>=10 ? 1 : 0;
            sum = sum>=10 ? sum%10 : sum;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(p1!=null){
                p1 = p1.next;
            }
            if(p2!=null){
                p2 = p2.next;
            }
        }
        if(carryBit>=1){
            curr.next = new ListNode(1);
        }
        return stl.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(5,l1);
        ListNode l3 = new ListNode(4,l2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4,l4);
        ListNode l6 = new ListNode(2,l5);

        ListNode _l1 = new ListNode(6);
        ListNode _l2 = new ListNode(5,_l1);
        ListNode _l3 = new ListNode(4,_l2);
        ListNode _l4 = new ListNode(4);
        ListNode _l5 = new ListNode(6,_l4);
        ListNode _l6 = new ListNode(5,_l5);

        ListNode merge = addTwoNumbers(l6,_l6);
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
