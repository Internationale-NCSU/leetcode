import java.util.*;

public class leetcode366_FindLeavesOfBinaryTree {
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
    Set<TreeNode> visited = new HashSet<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        while(!visited.contains(root)){
            List<Integer> list = new LinkedList<>();
            addLeaves(root,list);
            result.add(list);
        }
        return result;
    }
    public void addLeaves(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        if(!visited.contains(node)) {
            if ((visited.contains(node.left) || node.left == null) && (visited.contains(node.right) || node.right == null)) {
                list.add(node.val);
                visited.add(node);
                return;
            }
        }
       addLeaves(node.left,list);
       addLeaves(node.right,list);
    }
}
