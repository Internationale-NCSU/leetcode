import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode143 {
    public static ListNode reorderList(ListNode head) {
        Stack<ListNode> front = new Stack<>();
        Queue<ListNode> rear = new LinkedList<>();
        int frontLength = 0;
        int length = 0;
        ListNode stl = new ListNode();
        stl.next = head;
        while(head!=null){
            head = head.next;
            length++;
        }
        if(length%2==1){
            frontLength = length/2+1;
        }else {
            frontLength = length/2;
        }
        for (int i = 0; i < length; i++) {
            ListNode node = stl.next;
            if(i<frontLength){
                stl.next = stl.next.next;
                node.next = null;
                front.push(node);
            }else {
                stl.next = stl.next.next;
                node.next = null;
                rear.add(node);
            }
        }
        for (int i = 0; i < length; i++) {
            if(length%2==1){
                if(i%2==0){
                    ListNode node = front.pop();
                        node.next = stl.next;
                        stl.next = node;

                }else {
                    ListNode node = rear.poll();
                    node.next = stl.next;
                    stl.next = node;
                }
            }else {
                if(i%2==1){
                    ListNode node = front.pop();
                    node.next = stl.next;
                    stl.next = node;

                }else {
                    ListNode node = rear.poll();
                    node.next = stl.next;
                    stl.next = node;
                }
            }
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
        ListNode head = reorderList(l6);
        while(head!=null){
            System.out.print(head.val+", ");
            head = head.next;
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
