import java.util.LinkedList;
import java.util.List;

public class leetcode95 {
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(n);
    }
    public List<TreeNode> dfsGenerate(int start,int end){
        List<TreeNode> all = new LinkedList<>();
        if(start>end){
            all.add(null);
            return all;
        }
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTree = dfsGenerate(start,i-1);
            List<TreeNode> rightTree = dfsGenerate(i+1,end);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = l;
                    curTree.right = r;
                    all.add(curTree);
                }
            }
        }
        return all;
    }
}
