import org.junit.Test;

public class leetcode2385_LargestPalindromicNumber_II {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i)-'0']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isOddMiddle = false;
        for (int i = 9; i >=0 ; i--) {
            if(i==0&&stringBuilder.length()==0){
                continue;
            }
            if(count[i]%2==0){
                for (int j = 0; j < count[i]/2; j++) {
                    stringBuilder.append(i);
                }
                count[i] = 0;
            }else{
                for (int j = 0; j < (count[i]-1)/2 ; j++) {
                    stringBuilder.append(i);
                }
                count[i] = 1;
            }
        }
        for (int i = 9; i >=0 ; i--) {
            if(count[i]==1){
                stringBuilder.append(i);
                isOddMiddle = true;
                break;
            }
        }
        StringBuilder tmp = null;
        if(isOddMiddle){
            tmp = new StringBuilder(stringBuilder.substring(0,stringBuilder.length()-1));
        }else {
            tmp = new StringBuilder(stringBuilder);
        }
        String res = stringBuilder.append(tmp.reverse()).toString();
        return res.length()==0?"0":res;
    }
    @Test
    public void test(){
        System.out.println(largestPalindromic("00000"));
    }
}
