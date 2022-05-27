import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode299 {
    public static String getHint(String secret, String guess) {
        int bulls = 0,cows = 0;
        int[] records = new int[secret.length()];
        for (int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                records[i] = 1;
            }
        }
        Map<Character,Integer> secretMap = new HashMap<>()
                              , guessMap = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            if(records[i]==0){
                if(!secretMap.containsKey(secret.charAt(i))){
                    secretMap.put(secret.charAt(i),1);
                }else {
                    secretMap.replace(secret.charAt(i),secretMap.get(secret.charAt(i))+1);
                }

                if(!guessMap.containsKey(guess.charAt(i))){
                    guessMap.put(guess.charAt(i),1);
                }else {
                    guessMap.replace(guess.charAt(i),guessMap.get(guess.charAt(i))+1);
                }
            }
        }
        for (Character character : guessMap.keySet()) {
            if(secretMap.containsKey(character)){
                cows = cows + Math.min(secretMap.get(character),guessMap.get(character));
            }
        }
        return bulls+"A"+cows+"B";

    }

    public static void main(String[] args) {
        System.out.println(getHint("11","11"));
    }
}
