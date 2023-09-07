import org.junit.Test;

import java.util.*;

public class leetcode819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] arrs = normalizedStr.split("\\s+");
        for(int i=0; i<arrs.length;i++){
            char c = arrs[i].charAt(arrs[i].length()-1);
        }
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<banned.length;i++){
            bannedSet.add(banned[i]);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (b,a)->{
                    return map.get(a)-map.get(b);
                }
        );
        for(int i=0;i<arrs.length;i++){
            if(map.containsKey(arrs[i])){
                map.put(arrs[i],map.get(arrs[i])+1);
            }else{
                map.put(arrs[i],1);
            }
        }
        pq.addAll(map.keySet());
        while(bannedSet.contains(pq.peek())){
            pq.poll();
        }
        return pq.peek();
    }
    @Test
    public void test(){
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
    }
}
