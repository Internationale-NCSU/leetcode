import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode2325 {
    public String decodeMessage(String key, String message) {
        key = key.replaceAll(" ","");
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < key.length() ; i++) {
            if(map.size()==26){
                break;
            }
            if(map.containsKey(key.charAt(i))){
                continue;
            }else {
                int n = map.size();
                map.put(key.charAt(i),(char)('a'+n));
            }
        }
        StringBuilder secret = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)==' '){
                secret.append(" ");
                continue;
            }else {
                secret.append(map.get(message.charAt(i)));
            }
        }
        return secret.toString();
    }
    @Test
    public void test(){
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));
    }
}
