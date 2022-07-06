import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class leetcode306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        return backtracking(new LinkedList<>(),num,0);
    }
    public boolean backtracking(List<BigInteger> list, String num, int start){
         if(start == num.length()){
             return true;
         }
        for (int i = start+1; i <= num.length() ; i++) {
            String num1 = num.substring(start,i);
            if(num1.charAt(0)=='0'&&num1.length()!=1){
                continue;
            }
            BigInteger numStr = new BigInteger(num1);
            if(list.size()<2||isAddable(list.get(list.size()-1),list.get(list.size()-2),numStr)){
                list.add(numStr);
            }else {
                continue;
            }
            if(backtracking(list,num,i)&&list.size()>=3){
                return true;
            }
            list.remove(list.size()-1);
        }
        return false;
    }
    boolean isAddable(BigInteger num1,BigInteger num2,BigInteger num3){
        return num3.equals(num1.add(num2));
    }
    int countDigit(int num){
        int count = 0;
        while(num!=0){
            count++;
            num = num/10;
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(isAdditiveNumber("1123581321121"));
    }
}
