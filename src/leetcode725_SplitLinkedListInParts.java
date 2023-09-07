import org.junit.Test;

import java.util.List;

public class leetcode725_SplitLinkedListInParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        ListNode counter = head;
        while(counter!=null){
            counter = counter.next;
            len++;
        }
        ListNode pointer = head;
        if(len<=k){
            for (int i = 0; i < len; i++) {
                result[i] = pointer;
                pointer = pointer.next;
                result[i].next = null;
            }
        }else {
            int mod = len%k;
            int groupLen = len/k;
            int index = 0;
            for (int i = 0; i < k; i++) {
                result[i] = pointer;
                ListNode stl = new ListNode();
                stl.next = pointer;
                if(i==0){
                    for (int j = 0; j < mod; j++) {
                        pointer = pointer.next;
                        stl = stl.next;
                    }
                }
                for (int j = 0; j < groupLen; j++) {
                    pointer = pointer.next;
                    stl = stl.next;
                }
                stl.next = null;
            }
        }
        return result;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(2,l3);
        ListNode l5 = new ListNode(1, l4);
        ListNode l6 = new ListNode(15,l5);
        ListNode p = l6;
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }

}
