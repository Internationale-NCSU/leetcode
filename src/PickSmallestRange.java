import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PickSmallestRange {
    int[] pick(List<int[]> list){
        // a[0] is the index of specific array, a[1] is the pointer of current index in that arr.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           return list.get(a[0])[a[1]] - list.get(b[0])[b[1]];
        });
        int minRange = Integer.MAX_VALUE;
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int totalSize = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] > max) {
                max = list.get(i)[0];
            }
            pq.offer(new int[]{i, 0});
            totalSize += list.size();
        }
        while (totalSize>0){
            int[] index = pq.poll();
            int curSmallest = list.get(index[0])[index[1]];
            if(max - curSmallest<minRange){
                result[0] = curSmallest;
                result[1] = max;
                minRange = max - curSmallest;
            }
            if(index[1]+1<list.get(index[0]).length){
                index[1]++;
                if(list.get(index[0])[index[1]]>max){
                    max = list.get(index[0])[index[1]];
                }
            }
            pq.offer(index);
            totalSize--;
        }
        return result;
    }
    @Test
    public void test(){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,4,6,7,9,10});
        list.add(new int[]{2,5,6,7,11});
        list.add(new int[]{8,10,15});
        System.out.println(pick(list)[0]+","+pick(list)[1]);
    }
}
