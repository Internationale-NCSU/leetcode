import java.util.Scanner;

public class leetcode104 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        CreateBinaryTree(tree);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void CreateBinaryTree(TreeNode treeNode) {
        System.out.println("input node num");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) return;
        treeNode.val = n;
        CreateBinaryTree(treeNode.left);
        CreateBinaryTree(treeNode.right);

    }

}
