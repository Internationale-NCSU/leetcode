import org.junit.Test;

public class leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (String word : words) {
            if(stringCompare(word,chars)){
                sum+=word.length();
            }
        }
        return sum;
    }
    public boolean stringCompare(String s1, String s2){
        int[] dict = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            dict[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            if(--dict[s1.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"},"atach"));
    }
}
