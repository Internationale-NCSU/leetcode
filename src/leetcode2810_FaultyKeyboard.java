import org.junit.Test;

public class leetcode2810_FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='i'){
                sb.reverse();
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(finalString("poiinter"));
    }
}
