import java.util.Deque;
import java.util.LinkedList;

public class leetcode_988SmallestStringStartingFromLeaf {
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
    String result = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,""+root.val);
        return result;
    }
    public void dfs(TreeNode node, String s){
        if(node.left==null&&node.right==null){
            s = (char)('a'+node.val)+s;
            if(s.compareTo(result)==-1){
                result = s;
            }
            return;
        }

        if(node.left!=null){
            dfs(node.left,(char)('a'+node.val)+s);
        }
        if(node.right!=null){
            dfs(node.right, (char)('a'+node.val)+s);
        }
    }
}
