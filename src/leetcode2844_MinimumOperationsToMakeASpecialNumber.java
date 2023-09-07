import org.junit.Test;

public class leetcode2844_MinimumOperationsToMakeASpecialNumber {
    public int minimumOperations(String num) {
        int indexOfFive = num.lastIndexOf('5');
        int indexOfZero = num.lastIndexOf('0');
        int ans1 = num.length(), ans2 = num.length();

        if(indexOfZero!=-1){
            for (int i = indexOfZero-1; i >=0 ; i--) {
                if(num.charAt(i)=='5'||num.charAt(i)=='0'){
                    ans1 = num.length()-(indexOfZero+1) + indexOfZero - (i+1);
                    break;
                }
            }
            ans1 = Math.min(ans1,num.length()-1);
        }
        if(indexOfFive!=-1){
            for (int i = indexOfFive-1; i >=0 ; i--) {
                if(num.charAt(i)=='7'||num.charAt(i)=='2'){
                    ans2 = num.length()-(indexOfFive+1) + indexOfZero - (i+1);
                    break;
                }
            }
        }
        return Math.min(ans1,ans2);
    }
    @Test
    public void test(){
        System.out.println(minimumOperations("10"));
    }
}
