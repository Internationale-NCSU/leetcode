import org.junit.Test;

public class leetcode201 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left<right){
            left >>=1;
            right >>=1;
            shift++;
        }
        return left<<shift;
    }
    @Test
    public void test(){
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
