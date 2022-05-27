import java.math.BigDecimal;
import java.util.*;

public class leetcode1018 {
    public static void main(String[] args) {
        int[] arrays = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        List<Boolean> bool = prefixesDivBy5(arrays);
        for (Boolean result : bool) {
            System.out.println(result);
        }
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        BigDecimal decimal = new BigDecimal(0);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                decimal = decimal.multiply(BigDecimal.valueOf(2));
                decimal = decimal.add(BigDecimal.valueOf(1));
            } else decimal = decimal.multiply(BigDecimal.valueOf(2));
            System.out.println(decimal);
            if (decimal.remainder(BigDecimal.valueOf(5)).equals(BigDecimal.valueOf(0))) result.add(true);
            else result.add(false);
        }
        return result;
    }
}
