public class leetcode142_LinkedLsitCycleII_2Pointers {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fp=head;
        ListNode sp=head;
        while(fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
            if(fp==sp){
                sp=head;
                while(sp!=fp){

                    fp=fp.next;
                    sp=sp.next;

                }
                return sp;
            }
        }
        return null;
    }
}
