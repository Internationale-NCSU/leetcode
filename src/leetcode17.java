import java.util.*;

public class leetcode17 {
    public static void dfs(Deque<String> queue,String s,List<String> result,Map<String,String[]> map,int len){
        if(s.length()==len){
            result.add(s);
            return;
        }
        String first = queue.removeFirst();
        String[] characters = map.get(first);
        for (int i = 0; i < characters.length; i++) {
            s = s.concat(characters[i]);
            dfs(queue,s,result,map,len);
            s = s.substring(0,s.length()-1);
        }
        queue.addFirst(first);
    }
    public static List<String> letterCombinations(String digits) {

        Map<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        Deque<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            queue.addLast(String.valueOf(digits.charAt(i)));
        }
        String result = "";
        List<String> results = new LinkedList<>();
        if(digits.length()==0){
            return results;
        }
        dfs(queue,result,results,map,queue.size());
        return results;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}

