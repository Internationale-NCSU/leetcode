import java.util.List;

public class leetcode2828_CheckIfAStringIsAnAcronymOfWords {
    public boolean isAcronym(List<String> words, String s) {
        if(s.length()!=words.size()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(words.get(i).charAt(0) != c){
                return false;
            }
        }
        return true;
    }
}
