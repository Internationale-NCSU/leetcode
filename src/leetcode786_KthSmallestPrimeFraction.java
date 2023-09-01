import java.util.PriorityQueue;

public class leetcode786_KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->{
                    return ((double)a[0]/(double) a[1]-(double)b[0]/(double) b[1])<0?1:-1;
                }
        );
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                pq.offer(new int[]{arr[i],arr[j]});
            }
        }
        int count = 0;
        int[] result = new int[2];
        while(!pq.isEmpty()){
            count++;
            result=pq.poll();
            if(count==k){
                break;
            }
        }
        return result;
    }
}
