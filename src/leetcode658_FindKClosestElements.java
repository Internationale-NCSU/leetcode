import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            (a,b)->{
                if(Math.abs(a-x)!=Math.abs(b-x)){
                    return Math.abs(a-x)-Math.abs(b-x);
                }else {
                    return a-b;
                }
            }
        );
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll());
        }
        Collections.sort(list);
        return list;
    }
    @Test
    public void test(){
        System.out.println(findClosestElements(new int[]{0,0,3,3,7,8,9,10},3,5));
    }
}
