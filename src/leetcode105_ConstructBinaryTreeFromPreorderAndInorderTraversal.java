public class leetcode105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int s, int e, int s1, int e1) {
        if(s>e||s1>e1){
            return null;
        }

        TreeNode root = new TreeNode(preorder[s]);

        if(s==e||s1==e1) {
            return root;
        }
        int left=-1;
        for(int i=s1;i<=e1;i++){
            if(preorder[s]==inorder[i]){
                left =i;
                break;
            }
        }
        left = left-s1;

        root.left = buildTree(preorder,inorder,s+1,s+left,s1,s1+left-1);
        root.right = buildTree(preorder,inorder,(s+left+1),e, s1+left+1,e1);

        return root;
    }
}
