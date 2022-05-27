import java.util.*;

public class leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> tmp = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if(map.containsKey(p.charAt(i))){
                map.replace(p.charAt(i),map.get(p.charAt(i))+1);
            }else {
                map.put(p.charAt(i),1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (tmp.containsKey(s.charAt(i))) {
                tmp.replace(s.charAt(i), tmp.get(s.charAt(i)) + 1);
            } else {
                tmp.put(s.charAt(i), 1);
            }
            if(i>=p.length()){
                char c = s.charAt(i-p.length());
                int num =  tmp.get(c) - 1;
                if(num==0){
                    tmp.remove(c);
                }else {
                    tmp.replace(c,num);
                }
            }
            if(tmp.equals(map)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findAnagrams("aa","bb");
        result.forEach((a)->{
            System.out.print(a+",");
        });
    }
}
