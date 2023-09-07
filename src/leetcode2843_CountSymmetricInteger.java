import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode2843_CountSymmetricInteger {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++){
            if(helper(i)){
                count++;
            }
        }
        return count;
    }
    public boolean helper(int num){
        List<Integer> arrs = new ArrayList<>();
        while(num!=0){
            arrs.add(num%10);
            num = num/10;
        }
        if(arrs.size()%2!=0){
            return false;
        }
        int lowerSum = 0, upperSum = 0;
        for (int i = 0; i < arrs.size(); i++) {
            if(i<arrs.size()/2){
                lowerSum = lowerSum+arrs.get(i);
            }else {
                upperSum = upperSum+arrs.get(i);
            }
        }
        return lowerSum==upperSum;
    }
    @Test
    public void test(){
        System.out.println(countSymmetricIntegers(1,100));
    }
}
