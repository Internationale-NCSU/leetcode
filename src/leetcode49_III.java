import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode49_III {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap() ;
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> list = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return list;
    }
    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
