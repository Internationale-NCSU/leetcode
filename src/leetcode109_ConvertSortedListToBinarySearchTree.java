import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.List;

public class leetcode109_ConvertSortedListToBinarySearchTree {
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    public TreeNode sortedListToBST(ListNode head) {
         if(head==null){
             return null;
         }
         if(head.next==null){
             TreeNode t = new TreeNode(head.val);
             return t;
         }
        ListNode mid = findMid(head);
        TreeNode bst = new TreeNode(mid.val);
        bst.left = sortedListToBST(head);
        bst.right = sortedListToBST(mid.next);
        return bst;
    }

    public ListNode findMid(ListNode head){
         ListNode fast = head;
         ListNode slow = head;
         while(fast!=null&&fast.next!=null){
             slow = head;
             head = head.next;
             fast = fast.next.next;
         }
         slow.next=null;
         return head;
    }
    public void print(ListNode node){
         while(node!=null){
             System.out.println(node.val);
             node = node.next;
         }
    }
    @Test
    public void test(){
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);
         ListNode l5 = new ListNode(5);
         ListNode l6 = new ListNode(6);
         ListNode l7 = new ListNode(7);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = l6;
         l6.next = l7;
         ListNode mid = findMid(l1);
         print(mid);

    }
}
