import java.util.LinkedList;
import java.util.List;

public class leetcode199_BinaryTreeRightSideView {
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
    int curMaxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        res.add(root.val);
        dfs(root,0, res);
        return res;
    }
    public void dfs(TreeNode node, int curDepth,List<Integer> list){
        if(node==null){
            return;
        }
        if(curDepth>curMaxDepth){
            curMaxDepth = curDepth;
            list.add(node.val);
        }
        dfs(node.right,curDepth+1,list);
        dfs(node.left,curDepth+1,list);
    }
}
