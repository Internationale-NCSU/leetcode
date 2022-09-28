import java.util.ArrayList;
import java.util.List;

public class leetcode99_RecoverBinarySearchTree {
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
    public void inorder(TreeNode root, List<TreeNode> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root);
        inorder(root.right, nums);
    }
    public TreeNode[] findSwapped(List<TreeNode> list){
        int x = -1, y = -1;
        boolean occurrence = false;
        TreeNode[] result = new TreeNode[2];
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).val>list.get(i+1).val){
                result[1] = list.get(i+1);
                if(!occurrence){
                    result[0] = list.get(i);
                    occurrence = true;
                }else {
                    break;
                }
            }
        }
        return result;
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> nums = new ArrayList();
        inorder(root, nums);
        TreeNode[] nodes = findSwapped(nums);
        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }
}
