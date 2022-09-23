import org.junit.Test;

import java.util.*;

public class leetcode2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {
    class Pair<K,V>{
        K k;
        V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
        public K getKey(){
            return this.k;
        }
        public V getValue(){
            return this.v;
        }
    }
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
    Map<TreeNode, TreeNode> map = new HashMap();
    Set<TreeNode> visited = new HashSet<>();
    TreeNode start = new TreeNode();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Queue<Pair<TreeNode,String>> queue = new LinkedList<>();
        buildMap(root);
        findStart(root,startValue);
        Pair<TreeNode, String> p = new Pair<>(start, "");
        queue.add(p);
        visited.add(start);
        while(queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, String> pair = queue.poll();
                String sb = pair.getValue();
                TreeNode node = pair.getKey();
                visited.add(pair.getKey());
                if(node.val==destValue){
                    return sb.toString();
                }
                if(node.left!=null&&!visited.contains(node.left)){
                    queue.add(new Pair(node.left,sb+"L"));

                }
                if(node.right!=null&&!visited.contains(node.right)){
                    queue.add(new Pair(node.right,sb+"R"));

                }
                if(map.containsKey(node)){
                    if(!visited.contains(map.get(node))){
                        queue.add(new Pair(map.get(node),sb+"U"));
                    }
                }
            }
        }
        return "";
    }

    public void findStart(TreeNode node,int startValue){
        if(node.val==startValue){
           start =  node;
           return;
        }
        if (node.left != null) {
            findStart(node.left, startValue);
        }
        if (node.right != null) {
            findStart(node.right, startValue);
        }
    }
    public void buildMap(TreeNode node){
        if(node.left!=null){
            map.put(node.left,node);
            buildMap(node.left);
        }
        if(node.right!=null){
            map.put(node.right,node);
            buildMap(node.right);
        }
    }
    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1, new TreeNode(3), null), new TreeNode(2, new TreeNode(6), new TreeNode(4)));
        System.out.println(getDirections(treeNode,3,6));
    }
}
