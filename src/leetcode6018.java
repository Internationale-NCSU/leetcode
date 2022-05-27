import java.util.HashMap;
import java.util.Map;

public class leetcode6018 {
    public static class TreeNode {
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
    public static TreeNode createBinaryTree(int[][] descriptions) {
        int root = descriptions[0][0];
        Map<Integer,TreeNode> map = new HashMap<>();
        Map<Integer,Integer> rootMap = new HashMap<>();
        for (int i = 0; i < descriptions.length; i++) {
            if(descriptions[i][1]==root){
                root = descriptions[i][0];
            }
            if(rootMap.containsKey(descriptions[i][0])){
                rootMap.put(descriptions[i][0],rootMap.get(descriptions[i][0])+1);
            }else {
                rootMap.put(descriptions[i][0],2);
            }
            if(rootMap.containsKey(descriptions[i][1])){
                rootMap.put(descriptions[i][1],rootMap.get(descriptions[i][1])-2);
            }else {
                rootMap.put(descriptions[i][1],-2);
            }

            TreeNode parents;
            if(map.containsKey(descriptions[i][0])){
                parents = map.get(descriptions[i][0]);
            }else {
                parents = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0],parents);
            }
            TreeNode child;
            if(map.containsKey(descriptions[i][1])){
                child = map.get(descriptions[i][1]);
            }else {
                child = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1],child);
            }
            if(descriptions[i][2]==0){
                parents.right = child;
            }else {
                parents.left = child;
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : rootMap.entrySet()) {
            if(entry.getValue()>max){
                root = entry.getKey();
                max = entry.getValue();
            }
        }
        return map.get(root);
    }

    public static void main(String[] args) {
        int[][] d = new int[][]{
                {85,82,1},{74,85,1},{39,70,0},{82,38,1},{74,39,0},{39,13,1}
        };
        createBinaryTree(d);
    }
}
