import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String, Character> bimap = new HashMap<>();
        String[] strs = s.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(strs[i])){
                    return false;
                }
            }else{
                map.put(c,strs[i]);
                bimap.put(strs[i],c);
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
