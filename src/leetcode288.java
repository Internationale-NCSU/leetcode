import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode288 {
    class ValidWordAbbr {

        private Map<String, String> map = new HashMap<>();

        public String keyTransform(String s) {
            if (s.length() <= 2) {
                return s;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
                return sb.toString();
            }
        }

        public ValidWordAbbr(String[] dictionary) {
            for (String s : dictionary) {
                map.put(keyTransform(s), s);
            }
        }

        public boolean isUnique(String word) {
            if(map.containsKey(keyTransform(word))&&map.get(keyTransform(word))!=word){
                return false;
            }
            return true;
        }
    }
    @Test
    public void test(){
        System.out.println(new ValidWordAbbr(new String[]{"deer","door","cake","card"}).isUnique("cake"));
    }
}
