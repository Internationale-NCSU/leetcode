import java.util.*;
import java.util.stream.Collectors;

public class leetcode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            String s = Arrays.stream(strs[i].split("")).sorted().collect(Collectors.joining());
            if(map.containsKey(s)){
                List<String> list = map.get(s);
                list.add(strs[i]);
            }else {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(s,list);
            }
        }
        for (Map.Entry<String, List<String>> listEntry : map.entrySet()) {
            result.add(listEntry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"tan","ant","eat","tea","a"};
        System.out.println(groupAnagrams(strings));
    }
}
