import org.junit.Test;

import java.util.*;

public class leetcode621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for (char task : tasks) {
            if(map.containsKey(task)){
                map.put(task,map.get(task)+1);
            }else {
                map.put(task,1);
            }
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
                (a,b)->b.getValue()-a.getValue()
        );
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int count = 0;
        Map<Map.Entry<Character, Integer>,Integer> cooldown = new HashMap<>();
        while(true){
            count++;
            Map.Entry<Character, Integer> task = pq.poll();
            if(task!=null&&task.getValue()-1>0){
                task.setValue(task.getValue()-1);
                cooldown.put(task,n);
            }
            Iterator<Map.Entry<Map.Entry<Character, Integer>, Integer>> it = cooldown.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Map.Entry<Character, Integer>, Integer> tmp = it.next();
                if(tmp.getValue()==0){
                    pq.offer(tmp.getKey());
                    it.remove();
                }else {
                    tmp.setValue(tmp.getValue()-1);
                }
            }
            if(pq.isEmpty()&&cooldown.isEmpty()){
                break;
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B','C'},2));
    }
}
