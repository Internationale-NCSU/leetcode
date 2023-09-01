import org.junit.Test;

public class leetcode2696_MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(sb.length()!=0){
                if(s.charAt(i)=='B'&&sb.charAt(sb.length()-1)=='A'){
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
                if(s.charAt(i)=='D'&&sb.charAt(sb.length()-1)=='C'){
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }
            }
            sb.append(s.charAt(i));

        }
        return sb.length();
    }
    @Test
    public void test(){
        System.out.println(minLength("ACBBD"));
    }
}
