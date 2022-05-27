import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        dfs(nums,path,list,0);
        return list;
    }
    public static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> list, int index){
        if(path.size()>1){
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(!path.isEmpty()){
                if(nums[i]>path.getLast()) {
                    path.add(nums[i]);
                    dfs(nums, path, list, i + 1);
                    path.removeLast();
                }
            }else {
                path.add(nums[i]);
                dfs(nums,path,list,i+1);
                path.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
