import java.util.*;

public class leetcode40 {
    public static void backTracking(int[] candidates,int target,Deque<Integer> path,List<List<Integer>> result,int index,int curSum,List<Map.Entry<Integer,Integer>> mapEntry){
        if(curSum==target){
            List<Integer> list = new LinkedList<>(path);
            result.add(list);
            return;
        }else if(curSum>target){
            return;
        }
        for (int i = index; i < mapEntry.size(); i++) {
            path.addLast(mapEntry.get(i).getKey());
            int value = mapEntry.get(i).getValue();
            if(value-1>=0) {
                mapEntry.get(i).setValue(value-1);
                backTracking(candidates, target, path, result, i, curSum + mapEntry.get(i).getKey(), mapEntry);
                mapEntry.get(i).setValue(value);
            }
            path.removeLast();
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        Map<Integer,Integer> counter = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            counter.put(candidates[i],counter.getOrDefault(candidates[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> mapEntry = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:counter.entrySet()){
            mapEntry.add(entry);
        };
        backTracking(candidates,target,path,result,0,0,mapEntry);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
