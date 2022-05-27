import org.junit.Test;

import java.util.*;

public class leetcode2248 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int key = nums[i][j];
                if(map.containsKey(key)){
                    map.replace(key,map.get(key)+1);
                }else {
                    map.put(key,1);
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==len){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
    @Test
    public void test(){
        int[][] nums ={{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(intersection(nums));
    }
}
