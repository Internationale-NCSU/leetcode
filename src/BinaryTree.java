

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0, null, null);
        Tree tree = new Tree();

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

class Tree {
    TreeNode root;
    Scanner sc = new Scanner(System.in);

    void CreateTree() {
        RecurCreate(root);

    }

    TreeNode RecurCreate(TreeNode treeNode) {
        int val = sc.nextInt();
        if (val == 0) return null;
        else {
            treeNode.val = val;
            treeNode.left = RecurCreate(treeNode.left);
            treeNode.right = RecurCreate(treeNode.right);
        }
        return treeNode;
    }

    void PrintTree(TreeNode root) {
        System.out.println(root.val);
        PrintTree(root.left);
        PrintTree(root.right);
    }

}