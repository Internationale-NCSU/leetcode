import java.util.*;

public class leetcode49_II {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        List<List<String>> result =new LinkedList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
