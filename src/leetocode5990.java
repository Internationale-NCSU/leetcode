import javafx.util.Pair;

import java.util.*;

public class leetocode5990 {
    public static List<Integer> findLonely(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if(nums.length==1){
            result.add(nums[0]);
            return result;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }
        if(map.size()==1){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue()==1){
                    result.add(entry.getKey());
                }
                return result;
            }
        }
        List<Integer> list = new LinkedList<>();
        int index = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            list.add(entry.getKey());
            int front;
            int mid;
            int rear;
            if (list.size() == 1) {
                continue;
            } else if (list.size() == 2) {
                front = list.get(0);
                rear = list.get(1);
                if (map.get(front) == 1 && rear - front > 1) {
                    result.add(front);
                }
            } else {
                front = list.get(0);
                mid = list.get(1);
                rear = list.get(2);
                if (map.get(mid) == 1 && mid - front > 1 && rear - mid > 1) {
                    result.add(mid);
                }
            }
            if (list.size() == 3) {
                list.remove(0);
            }
        }
        int front;
        int rear;
        front = list.get(list.size()-2);
        rear = list.get(list.size()-1);
        if (map.get(rear) == 1 && rear - front > 1) {
            result.add(rear);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLonely(new int[]{0,0,1,1}));
    }
}
