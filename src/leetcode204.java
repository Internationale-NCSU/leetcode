import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;

public class leetcode204 {
    public int countPrimes(int n) {
        int[] count = new int[n+1];
        int upper = n;
        for (int i = 2; i <= n; i++) {
            if(count[i]==-1){
                continue;
            }else {
                if(isPrime(i)){
                    count[i]=1;
                    double times = Math.pow(i,2);
                    while(times<n){
                        count[(int)times] = -1;
                        times = Math.pow(times,2);
                    }
                }else {
                    count[i]=-1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if(count[i]==1){
                result++;
            }
        }
        return result;
    }
    boolean isPrime(int n){
        if(n==2){
            return true;
        }
        double sqrt = Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(countPrimes(0));
    }
}
