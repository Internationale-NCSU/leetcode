import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode78 {
    public static void dfs(int index, int[] nums, Deque<Integer> path,List<List<Integer>> result){
        List<Integer> list = new LinkedList<>(path);
        result.add(list);
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(i+1,nums,path,result);
            path.removeLast();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(0,nums,path,result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(subsets(arr));
    }
}
