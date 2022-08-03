import org.junit.Test;

public class leetcode231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        while(true){
            if(n==1){
                return true;
            }else if(n==0){
                return false;
            }
            if(n%2==0){
                n = n/2;
            }else {
                return false;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(isPowerOfTwo(1));
    }
}
