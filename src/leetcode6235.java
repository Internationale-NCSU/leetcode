import java.util.*;

public class leetcode6235 {
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
    public int minSwaps(int[] nums)
    {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        int result = 0;
        for(int i=0;i<len;i++) {
            if(visited[i] || map.get(nums[i]) == i){
                continue;
            }
            int j = i, size = 0;
            while(!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                size++;
            }
            if(size > 0) {
                result += (size - 1);
            }
        }
        return result;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int[] nums = null;
        while(queue.size()!=0) {
            int s = queue.size();
            nums= new int[s];
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                nums[i] = node.val;
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            count+= minSwaps(nums);
        }
        return count;
    }
}



