import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class leetcode143_II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        int len =0;
        ListNode stl = new ListNode(0,head);
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        if(len<=2){
            return;
        }
        int mid = len/2;
        p = head;
        ListNode rear;
        for (int i = 0; i < mid; i++) {
            p = p.next;
        }
        rear = p.next;
        rear = reverseList(rear);
        p.next = null;
        stl = new ListNode();
        p = stl;
        boolean isFront = true;
        while(rear!=null&&p!=null){
            if(isFront){
                p.next = head;
                head = head.next;
                isFront = false;
            }else {
                p.next = rear;
                rear = rear.next;
                isFront = true;
            }
            p = p.next;
        }
        if(rear!=null){
            p.next = rear;
        }else if(head!=null){
            p.next = head;
        }
        head = stl.next;
    }
    public ListNode reverseList(ListNode head){
        ListNode stl = new ListNode();
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();
        while(p!=null){
            ListNode tmp = p.next;
            p.next = null;
            stack.push(p);
            p = tmp;
        }
        p = stack.pop();
        stl.next = p;
        while(!stack.isEmpty()){
            ListNode tmp = stack.pop();
            p.next = tmp;
            p = tmp;
        }
        return stl.next;
    }
    @Test
    public void test(){
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(4,l2);
        ListNode l4 = new ListNode(3,l3);
        ListNode l5 = new ListNode(2,l4);
        ListNode l6 = new ListNode(1,l5);
        reorderList(l6);

    }
}
