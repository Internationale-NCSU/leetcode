import org.junit.Test;

import java.util.*;

public class leetcode2385_AmountOfTimeForBinaryTreeToBeInfected {
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
    Map<TreeNode,TreeNode> map = new HashMap<>();
    TreeNode startNode = new TreeNode();
    public int amountOfTime(TreeNode root, int start) {
        int minutes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        findParent(root,start);
        queue.add(startNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(!visited.contains(node.left)&&node.left!=null){
                    queue.add(node.left);
                    visited.add(node);
                }
                if(!visited.contains(node.right)&&node.right!=null){
                    queue.add(node.right);
                    visited.add(node);
                }
                if(!visited.contains(map.get(node))&&map.containsKey(node)){
                    queue.add(map.get(node));
                    visited.add(node);
                }
            }
            minutes++;
        }
        return minutes;
    }
    public void findParent(TreeNode root,int start){
        if(root.val==start){
            startNode = root;
        }
        if(root.left!=null){
            map.put(root.left,root);
            findParent(root.left,start);
        }
        if(root.right!=null){
            map.put(root.right,root);
            findParent(root.right,start);
        }
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4),new TreeNode(5)));
        System.out.println(amountOfTime(root,2));
    }
}
