import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class leetcode7 {
    public static int reverse(int x) {
        List<Integer> list = new LinkedList<>();
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        while(x>0){
            list.add(x%10);
            x = x/10;
        }
        long result = 0;
        for (Integer integer : list) {

            result = result*10+integer;
        }
        if(result>=MAX_VALUE){
            return 0;
        }
        return sign*(int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1563847412));
    }
}
