import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode1405LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character,Integer> freqMap = new HashMap<>();
        freqMap.put('a',a);
        freqMap.put('b',b);
        freqMap.put('c',c);
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (num1,num2)->{
                return freqMap.get(num2) - freqMap.get(num1);
            }
        );
        pq.offer('a');
        pq.offer('b');
        pq.offer('c');
        boolean[] isUsedForOnce = new boolean[3];
        StringBuilder sb = new StringBuilder();
        while(pq.size()>=2){
            char c1 = pq.poll();
            char c2 = pq.poll();
            if(freqMap.get(c1)>=2){
                sb.append(c1).append(c1);
                freqMap.put(c1,freqMap.get(c1)-2);
                pq.offer(c1);
            }else if(freqMap.get(c1)==1&&!isUsedForOnce[c1-'a']){
                isUsedForOnce[c1-'a'] = true;
                sb.append(c1);
                freqMap.put(c1,freqMap.get(c1)-1);
            }
            if(freqMap.get(c2)>=2){
                sb.append(c2).append(c2);
                freqMap.put(c2,freqMap.get(c2)-2);
                pq.offer(c2);
            }else if(freqMap.get(c2)==1&&!isUsedForOnce[c1-'a']){
                isUsedForOnce[c2-'a'] = true;
                sb.append(c2);
                freqMap.put(c2,freqMap.get(c2)-1);
            }
        }
        char c1 = pq.poll();
        if(c1!=sb.charAt(sb.length()-1)) {
            if (freqMap.get(c1) >= 2) {
                sb.append(c1).append(c1);
                freqMap.put(c1, freqMap.get(c1) - 2);
                pq.offer(c1);
            } else if (freqMap.get(c1) == 1 && !isUsedForOnce[c1 - 'a']) {
                isUsedForOnce[c1 - 'a'] = true;
                sb.append(c1);
                freqMap.put(c1, freqMap.get(c1) - 1);
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(longestDiverseString(1,1,7));
    }
}
