import org.junit.Test;

import java.util.*;

public class leetcode314_BinaryTreeVerticalOrderTraversal {
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        TreeMap<Integer,List<Integer>> map = new TreeMap<>((a,b)->a-b);
        Queue<TreeNode>queue = new LinkedList<>();
        Queue<Integer>columQueue = new LinkedList<>();
        queue.add(root);
        columQueue.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int curColum = columQueue.poll();
                List<Integer> list;
                if(map.containsKey(curColum)){
                    list = map.get(curColum);
                    list.add(node.val);
                }else {
                    list = new ArrayList<>();
                    list.add(node.val);
                    map.put(curColum,list);
                }
                if(node.left!=null){
                    queue.add(node.left);
                    columQueue.add(curColum-1);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    columQueue.add(curColum+1);
                }
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int integer = iterator.next();
            result.add(map.get(integer));
            iterator.remove();
        }
        return result;
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(6),new TreeNode(7)),new TreeNode(3,new TreeNode(4),new TreeNode(5)));
        System.out.println(verticalOrder(root));
    }
}
