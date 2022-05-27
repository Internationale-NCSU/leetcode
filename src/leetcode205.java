import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))&&!map.containsKey(t.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));
            }else if(map.containsKey(t.charAt(i))&&s.charAt(i)!=map.get(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isIsomorphic("paper","title"));
    }

}
