import java.util.LinkedList;
import java.util.Queue;

public class leetcode2265 {
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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> queue  = new LinkedList<>();
        inOrderAdd(root,queue);
        int total = 0;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int[] temp = {0,0};
            inOrder(curr,temp);
            int avg = temp[0]/temp[1];
            if(avg == curr.val) {
                total++;
            }
        }
        return total;
    }
    public void inOrderAdd(TreeNode currRoot, Queue<TreeNode> queue){
        if(currRoot==null){
            return;
        }
        inOrderAdd(currRoot.left,queue);
        queue.add(currRoot);
        inOrderAdd(currRoot.right,queue);
    }
    public void inOrder(TreeNode currRoot, int[] temp){
        if(currRoot==null){
            return;
        }
        inOrder(currRoot.left,temp);
        temp[0] += currRoot.val;
        temp[1] += 1;
        inOrder(currRoot.right,temp);
    }
}
