public class leetcode725 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode stl = new ListNode();
        stl.next = head;
        int length = 0;
        while(head!=null){
            length++;
            head = head.next;
        }
        if(length<k){
            k = length;
        }
        int reminder = length%k;
        int subLength = length/k;
        for (int i = 0; i < k ; i++) {
            ListNode subList = stl.next;
            ListNode p = subList;
            int curLength = 0;
            if(reminder>0) {
                while (curLength < subLength) {
                    p = p.next;
                    curLength++;
                }
                stl.next = p.next;
                p.next = null;
                result[i] = subList;
                reminder--;
            }else{
                while (curLength < subLength-1) {
                    p = p.next;
                    curLength++;
                }
                stl.next = p.next;
                p.next = null;
                result[i] = subList;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5,l4);
        ListNode l6 = new ListNode(6,l5);
        ListNode[] result = splitListToParts(l6,7);
//        while(l6!=null){
//            System.out.print(l6.val+", ");
//            l6 = l6.next;
//        };
        for (int i = 0; i < result.length; i++) {
            while(result[i]!=null){
                System.out.print(result[i].val+" ,");
                result[i] = result[i].next;
            }
            System.out.println();
        }

    }

}
