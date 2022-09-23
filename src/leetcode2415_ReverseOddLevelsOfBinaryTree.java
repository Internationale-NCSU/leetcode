import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class leetcode2415_ReverseOddLevelsOfBinaryTree {
    class TreeNode {
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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if(node.left!=null){
                    queue.add(node);
                }
                if(node.right!=null){
                    queue.add(node);
                }
            }
            if(level%2==0){
                for (int i = 0; i < Math.pow(2,level-1)/2; i=i+2) {
                    int tmp = list.get(i).val;
                    list.get(i).val = list.get(list.size()-1-i).val;
                    list.get(list.size()-1-i).val = tmp;
                }
            }
            level++;
        }
        return root;
    }
}
