import org.junit.Test;

public class leetcode148 {
    static ListNode left;
    static ListNode right;
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        ListNode front;
        ListNode back;
        while(p!=null){
            p = p.next;
            len++;
        }
        if(len==0||len==1){
            return head;
        }
        ListNode[] result = split(head,len);
        front = result[0];
        back = result[1];
        front = sortList(front);
        back = sortList(back);
        return merge(front,back);
    }
    public ListNode merge(ListNode left,ListNode right){
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else {
            ListNode tmp;
            if(left.val<right.val){
                tmp = left;
                tmp.next = merge(left.next,right);
            }else {
                tmp = right;
                tmp.next = merge(left,right.next);
            }
            return tmp;
        }

    }
    public ListNode[] split(ListNode head, int len){
        ListNode[] result = new ListNode[2];
        ListNode p = head;
        int half = len/2;
        int count = 0;
        left = head;
        while(count<half){
            ListNode tmp = new ListNode();
            if(count==half-1){
                tmp = p;
            }
            p = p.next;
            if(count==half-1){
                tmp.next = null;
            }
            count++;
        }
        right = p;
        result[0] = left;
        result[1] = right;
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
        p = sortList(p);
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
        split(l5,5);
    }
}
