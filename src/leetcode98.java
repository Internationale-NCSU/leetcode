public class leetcode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }else if(root.left!=null&&root.left.val<root.val&&root.right==null){
            return isValidBST(root.left);
        }else if(root.right!=null&&root.right.val>root.val&&root.left==null){
            return isValidBST(root.right);
        }else if(root.left!=null&&root.right!=null&&root.right.val>root.val&&root.left.val<root.val){
            return isValidBST(root.left)&&isValidBST(root.right);
        }else {
            return false;
        }
    }
}
