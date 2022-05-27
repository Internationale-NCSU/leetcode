import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;

public class leetcode244 {
    public static class WordDistance {
        Map<String, List<Integer>> dictionary;
        public WordDistance(String[] wordsDict) {
            dictionary = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                List<Integer> list;
                if(dictionary.containsKey(wordsDict[i])){
                    list = dictionary.get(wordsDict[i]);
                    list.add(i);
                }else{
                    list = new LinkedList<>();
                    list.add(i);
                    dictionary.put(wordsDict[i],list);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1Position = dictionary.get(word1);
            List<Integer> word2Position = dictionary.get(word2);
            int shortestDis = MAX_VALUE;
            for (Integer integer1 : word1Position) {
                for (Integer integer2 : word2Position) {
                    shortestDis = Math.min(Math.abs(integer2-integer1),shortestDis);
                }
            }
            return shortestDis;
        }
    }

    public static void main(String[] args) {
        String[] s = {"practice","makes","perfect","coding","makes"};
        WordDistance wordDistance = new WordDistance(s);
        System.out.println(wordDistance.shortest("coding","practice"));
    }

}
