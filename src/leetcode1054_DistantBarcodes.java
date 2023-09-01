import org.junit.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode1054_DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length==0){
            return null;
        }
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            if(freqMap.containsKey(barcodes[i])){
                freqMap.put(barcodes[i],freqMap.get(barcodes[i])+1);
            }else {
                freqMap.put(barcodes[i],1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->{
                    return freqMap.get(b)-freqMap.get(a);
                }
        );
        pq.addAll(freqMap.keySet());
        for (int i = 0; i < barcodes.length; i++) {
            if(pq.size()>1){
                int num1 = pq.poll();
                int num2 = pq.poll();
                barcodes[i] = num1;
                barcodes[++i] = num2;
                int count1 = freqMap.get(num1);
                int count2 = freqMap.get(num2);
                freqMap.put(num1,count1-1);
                freqMap.put(num2,count2-1);
                if(count1-1!=0){
                    pq.offer(num1);
                }
                if(count2-1!=0){
                    pq.offer(num2);
                }


            }else {
                barcodes[i] = pq.poll();
            }
        }
        return barcodes;
    }
    @Test
    public void test(){
        System.out.println(rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3}));
    }
}
