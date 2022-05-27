import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode266 {
    public static boolean canPermutePalindrome(String s) {
        Map<Character,Integer> charCount = new HashMap<>();
        boolean isSingle = false;
        for (int i = 0; i < s.length(); i++) {
            if(!charCount.containsKey(s.charAt(i))){
                charCount.put(s.charAt(i),1);
            }else {
                charCount.replace(s.charAt(i),charCount.get(s.charAt(i))+1);
            }
        }
        for (Character character : charCount.keySet()) {

            if(charCount.get(character)%2==0){
                continue;
            }else {
                if(isSingle==false){
                    isSingle = true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("c"));
    }
}
