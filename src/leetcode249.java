import java.util.*;

public class leetcode249 {
    public  static boolean isGroup(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.length()==1){
            return true;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        for (int i = 1; i < s1.length(); i++) {
            int diff1 = s1Array[i]-s2Array[i];
            int diff2 = s1Array[0]-s2Array[0];
            diff1 = diff1 > 0 ? diff1 : 26+diff1;
            diff2 = diff2 > 0 ? diff2 : 26+diff2;
            if(diff1!=diff2){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        List<String> list;
        for (int i = 0; i < strings.length; i++) {
            Set<String> keySet = map.keySet();
            boolean isFound = false;
            for (String s : keySet) {
                if(isGroup(s,strings[i])){
                    list = map.get(s);
                    list.add(strings[i]);
                    isFound = true;
                }
            }
            if(!isFound){
                list = new LinkedList<>();
                list.add(strings[i]);
                map.put(strings[i],list);
            }

        }
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            result.add(map.get(s));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = {"abc","def","bcd","xyz","a","e","i","o","u"};
        List<List<String>> result = groupStrings(s);
        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i);
            list.forEach(
                (a)->{
                    System.out.print(a+",");
                }
            );
            System.out.println();
        }

    }
}
