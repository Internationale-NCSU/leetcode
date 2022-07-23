import org.junit.Test;

public class leetcode172_FactorialTrailingZero {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n%5!=0){
            n--;
        }
        while(n>0){
            count = count+countFive(n);
            n = n-5;
        }
        return count;
    }
    int countFive(int num){
        int count = 0;
        while(num>0){
            if(num%5==0) {
                count++;
            }
            num = num/5;
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(trailingZeroes(13));
    }
}
