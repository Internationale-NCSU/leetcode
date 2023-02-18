import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode2558_TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        long result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            return a-b;
        });
        for (int i = 0; i < gifts.length; i++) {
            queue.offer(gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            int val = queue.poll();
            double rest =  Math.sqrt(val);
            queue.offer((int)rest);
        }

        while(!queue.isEmpty()){
            result+=queue.poll();
        }
        return result;
    }
}
