import org.junit.Test;

import java.util.PriorityQueue;

public class leetcode23_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b)->a.val-b.val
        );
        for (ListNode list : lists) {
            while(list!=null){
                ListNode node = list;
                list = list.next;
                node.next = null;
                pq.offer(node);
            }
        }
        ListNode stl = new ListNode();
        ListNode p = pq.poll();
        stl.next = p;
        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
        }
        return stl.next;
    }
    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2,l1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6,l5);
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l2;
        listNodes[1] = l4;
        listNodes[2] = l6;
        ListNode result = mergeKLists(listNodes);
        while(result!=null){
            System.out.print(result.val+", ");
            result = result.next;
        }
    }
}
