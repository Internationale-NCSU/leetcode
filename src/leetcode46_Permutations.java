import java.util.*;

public class leetcode46_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, deque ,0,result,set);
        return result;
    }
    public static void dfs(int[] nums, Deque<Integer> path,int n,List<List<Integer>> result,Set<Integer> set){
        if(path.size()==nums.length){
            List<Integer> list = new LinkedList<>(path);
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(i)) {
                continue;
            }
            path.addLast(nums[i]);
            set.add(i);
            dfs(nums,path,n+1,result,set);
            path.removeLast();
            set.remove(i);
            }
    }

public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(permute(nums));
        }
}
