import org.junit.Test;

public class leetcode2264 {
    public String largestGoodInteger(String num) {
        int n = -1;
        for (int i = 2; i < num.length(); i++) {
            if(num.charAt(i)==num.charAt(i-1)&&num.charAt(i)==num.charAt(i-2)&&(num.charAt(i)-'0'>n)){
                n = num.charAt(i)-'0';
            }
        }
        if(n==-1){
            return "";
        }else {
            return Integer.toString(n)+Integer.toString(n)+Integer.toString(n);
        }
    }
    @Test
    public void test(){
        System.out.println(largestGoodInteger("000"));
    }
}
