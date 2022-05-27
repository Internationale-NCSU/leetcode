import java.util.*;

public class leetcode368 {
//    public static void dfs(int[] nums, int index, Deque<Integer> deque){
//        if(deque.size()>result.size()){
//            result = new LinkedList<>(deque);
//        }
//        for (int i = index; i < nums.length; i++) {
//            if(deque.isEmpty()){
//                deque.addLast(nums[i]);
//            }else {
//                int num = deque.getLast();
//                if(nums[i]%num==0){
//                    deque.addLast(nums[i]);
//                }
//            }
//            dfs(nums,i+1,deque);
//            if(!deque.isEmpty()&&deque.getLast()!=1){
//                deque.removeLast();
//            }
//        }
//    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result;
        if(nums.length==0){
            return new ArrayList<>();
        }
        int indexOfLongestLen = 0;
        int longestLen = 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new ArrayList<>());
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> longestSubset = new ArrayList<>();
            int longestSubLen = 0;
            for (int j = 0; j < i; j++) {
                int lastNum = list.get(j).get(list.get(j).size()-1);
                if(nums[i]%lastNum==0&&list.get(j).size()+1>longestSubLen){
                    longestSubset = new ArrayList<>(list.get(j));
                    longestSubset.add(nums[i]);
                    longestSubLen = longestSubset.size();
                }
            }
            if(longestSubset.isEmpty()){
                longestSubset.add(nums[i]);
            }
            list.set(i,longestSubset);
            if(longestSubLen>longestLen){
                longestLen = longestSubLen;
                indexOfLongestLen = i;
            }
        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        dfs(nums,0,deque);
        result = list.get(indexOfLongestLen);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1}));
    }

}
