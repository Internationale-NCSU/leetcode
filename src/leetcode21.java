public class leetcode21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode stl = new ListNode();
        ListNode p = stl;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
            p.next =null;
        }
        if(p1!=null){
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return stl.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(5,l1);
        ListNode l3 = new ListNode(4,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(2,l4);
        ListNode l6 = new ListNode(1,l5);

        ListNode _l1 = new ListNode(6);
        ListNode _l2 = new ListNode(5,_l1);
        ListNode _l3 = new ListNode(4,_l2);
        ListNode _l4 = new ListNode(3,_l3);
        ListNode _l5 = new ListNode(2,_l4);
        ListNode _l6 = new ListNode(1,_l5);

        ListNode merge = mergeTwoLists(l6,null);
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
