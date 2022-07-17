public class leetcode415 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings("99", "9"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            String result = "";
            if (num1 == "0") return num2;
            if (num2 == "0") return num1;
            String rec = "";
            int length_1 = num1.length();
            int length_2 = num2.length();
            int carry = 0;
            int large_one = num1.length() > num2.length() ? num1.length() : num2.length();
            int small_one = num1.length() < num2.length() ? num1.length() : num2.length();
            while (length_1 != 0 && length_2 != 0) {
                int num_1 = Integer.parseInt(String.valueOf(num1.charAt(length_1 - 1)));
                int num_2 = Integer.parseInt(String.valueOf(num2.charAt(length_2 - 1)));
                //System.out.println("num1:" + num1.charAt(length_1-1) + " num2:" + num2.charAt(length_2-1));
                //System.out.println("num_1:" + num_1 + " num_2:" + num_2);
                int tmp_result = 0;
                if (carry == 0) {
                    if (num_1 + num_2 >= 10) {
                        tmp_result = (num_1 + num_2) % 10;
                        carry = 1;
                    } else {
                        tmp_result = num_1 + num_2;
                        carry = 0;
                    }
                } else if (carry == 1) {
                    if (num_1 + num_2 + 1 >= 10) {
                        tmp_result = (num_1 + num_2 + 1) % 10;
                        carry = 1;
                    } else {
                        tmp_result = num_1 + num_2 + 1;
                        carry = 0;
                    }
                }
                //System.out.println("tmp_result:" +tmp_result);
                result = result.concat(Integer.toString(tmp_result));
                length_1 = length_1 - 1;
                length_2 = length_2 - 1;
            }

            if (length_1 == 0) rec = num2.substring(0, large_one - small_one);
            if (length_2 == 0) rec = num1.substring(0, large_one - small_one);

            //System.out.println(num1.substring(0,large_one-small_one));
            //System.out.println(rec);
            int tmp = large_one - small_one;
            while (tmp != 0) {
                int num = Integer.parseInt(String.valueOf(rec.charAt(tmp - 1)));
                if (carry == 0) {
                    result = result.concat(Integer.toString(num));
                } else if (carry == 1) {
                    if (num + 1 >= 10) {
                        result = result.concat(Integer.toString((num + 1) % 10));
                        carry = 1;
                    } else {
                        result = result.concat(Integer.toString(num + 1));
                        carry = 0;
                    }
                }
                tmp = tmp - 1;
            }
            if (carry == 1) result = result.concat("1");
            String reverse = "";
            for (int i = result.length() - 1; i >= 0; i--) {
                reverse = reverse.concat(String.valueOf(result.charAt(i)));
            }
            return reverse;
        }
    }
}
