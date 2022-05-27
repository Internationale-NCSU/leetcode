import java.util.List;

public class leetcode24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode stl = new ListNode();
        if(head==null){
            return head;
        }
        stl.next = head;
        ListNode first= stl;//first指向节点不操作
        ListNode second = head;//second记录第一个元素
        while(second!=null&&second.next!=null){
            ListNode tmp = second.next;//tmp记录第二个元素
            second.next = second.next.next;
            tmp.next = second;
            first.next = tmp;
            first = second;
            second = second.next;
        }
        return stl.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5,l4);
        ListNode l6 = new ListNode(6,l5);

        swapPairs(l6);
        while(l6!=null){
            System.out.print(l6.val+", ");
            l6 = l6.next;
        }
    }
}
