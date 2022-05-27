import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class leetcode989 {
    public static void main(String[] args) {
        int[] a = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        Solution s = new Solution();
        List<Integer> resutlList = s.addToArrayForm(a, k);


    }

    static class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> resutlList = new ArrayList<>();

            String s = "";
            int num_A = 0;
            for (int i = 0; i < A.length; i++) {
                num_A = num_A * 10 + A[i];
                s = s.concat(Integer.toString(A[i]));
            }
            BigDecimal bigDecimal = new BigDecimal(s);
            ;
            //  System.out.println(s);
            StringBuilder stringBuilder = new StringBuilder();
            // System.out.println(num_A);

            BigDecimal result = new BigDecimal(0);
            BigDecimal k = new BigDecimal(K);

            // System.out.println(k);

            result = result.add(bigDecimal);
            result = result.add(k);
            // System.out.println(result);

            stringBuilder.append(result.toString());
            //System.out.println(stringBuilder.toString());

            for (int i = 0; i < stringBuilder.length(); i++) {
                resutlList.add(stringBuilder.charAt(i) - '0');
            }
            Iterator iterator = resutlList.iterator();

            while (iterator.hasNext()) {
                int n = (int) iterator.next();
                // System.out.print(n);
            }


            return resutlList;
        }
    }

}
