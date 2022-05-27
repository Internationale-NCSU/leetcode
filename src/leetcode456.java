import java.util.Deque;
import java.util.LinkedList;

public class leetcode456 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Deque<Integer> path = new LinkedList<>();
        dfs(nums,path);
        System.out.println(path);
        if (path.size()==3){
            return true;
        }else return false;
    }
    public static void dfs(int[] nums, Deque<Integer> path){
        if(path.size()==3){
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            switch (path.size()){
                case 0:{
                    path.addLast(nums[i]);
                    break;
                }
                case 1:{
                    if(path.getLast()<nums[i]){
                        path.addLast(nums[i]);
                    }
                    break;
                }
                case 2:{
                    if(path.getLast()>nums[i]&&path.getFirst()<nums[i]){
                        path.addLast(nums[i]);
                    }
                    break;
                } default:continue;

            }
        }
    }

}
