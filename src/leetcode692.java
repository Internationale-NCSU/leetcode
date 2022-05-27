import javafx.util.Pair;

import java.util.*;

public class leetcode692 {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<Pair<String,Integer>> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            list.add(new Pair<>(entry.getKey(),entry.getValue()));
        }
        Collections.sort(list,(a,b)->{
            if(a.getValue().equals(b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }
            else {
                return b.getValue()-a.getValue();
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(s,4));
    }
}
