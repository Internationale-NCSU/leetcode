import org.junit.Test;

import java.util.*;

public class leetcode267 {
    Map<Character,Integer> map = new HashMap<>();
    char oddChar = ' ';
    public boolean isPalindromes(String s){
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int oddCount = 0;
        for (Integer value : map.values()) {
            if(value%2==1){
                oddCount++;
            }
            if(oddCount>1){
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2==1){
                oddChar = entry.getKey();
                map.replace(entry.getKey(),map.get(entry.getKey())-1);
            }
            map.replace(entry.getKey(),map.get(entry.getKey())/2);
        }
        return true;
    }
    public List<String> generatePalindromes(String s) {
        List<String> result = new LinkedList<>();
        if(isPalindromes(s)){
            backtrack(result,s.length()/2,new StringBuilder());
        }
        return result;
    }
    public void backtrack(List<String> result, int n, StringBuilder sb){
        if(sb.length()==n){
            String s = "";
            StringBuilder copy = new StringBuilder(sb);
            if(oddChar==' '){
                s =copy.toString()+copy.reverse().toString();
            }else {
                s =copy.toString()+String.valueOf(oddChar)+copy.reverse();
            }
            result.add(s);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = ' ';
            if(map.get(entry.getKey())!=0){
                key = entry.getKey();
                sb.append(entry.getKey());
                map.replace(entry.getKey(),map.get(entry.getKey())-1);
            }else {
                continue;
            }
            backtrack(result,n,sb);
            if(key!=' '){
                map.replace(entry.getKey(),map.get(entry.getKey())+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(generatePalindromes("abc"));;
    }
}
