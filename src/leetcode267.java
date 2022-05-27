import java.util.List;

public class leetcode267 {
    public static List<String> generatePalindromes(String s) {
        return null;
    }
    public static boolean canPalindromes(String s,int[] map){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if(map[s.charAt(i)]%2==0){
                count--;
            }else {
                count++;
            }
        }
        return count<=1;
    }
    public void swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    public static void main(String[] args) {
        int[] map = new int[1024];
        System.out.println(canPalindromes("abb",map));
    }
}
