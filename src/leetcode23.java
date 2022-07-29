import java.util.Arrays;

public class leetcode23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1) {
            return lists[0];
        }
        if(lists.length==2) {
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }
        for (int i = mid,j=0; i < lists.length; i++) {
            right[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(left),mergeKLists(right));

    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
       if(l1==null) {
           return l2;
       }
       if(l2==null){
           return l1;
       }
       ListNode head = new ListNode();
       if(l1.val>l2.val){
           head = l2;
           head.next = mergeTwoLists(l1,l2.next);
       }else {
           head = l1;
           head.next = mergeTwoLists(l1.next,l2);
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

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        ListNode result = mergeKLists(listNodes);
        while(result!=null){
            System.out.print(l6.val+", ");
            result = result.next;
        }
    }

}
