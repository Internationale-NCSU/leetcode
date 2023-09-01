import org.junit.Test;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.PriorityQueue;

public class leetccode451_SortCharacterByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a,b)->freqMap.get(b)-freqMap.get(a)
        );

        for (int i = 0; i < s.length(); i++) {
            if(freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i),freqMap.get(s.charAt(i))+1);
            }else {
                freqMap.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            pq.offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()!=0){
            sb.append( pq.poll() );
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }
}
