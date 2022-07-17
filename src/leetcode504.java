public class leetcode504 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToBase7(0));
    }

    static class Solution {
        public String convertToBase7(int num) {
            String result = "";
            String s = "";
            if (num > 0) {
                while (num != 0) {
                    result = result.concat(String.valueOf(num % 7));
                    num = num / 7;
                }

                for (int i = 0; i < result.length(); i++) {
                    s = s.concat(String.valueOf(result.charAt(result.length() - i - 1)));
                }
            } else if (num < 0) {
                num = -num;
                while (num != 0) {
                    result = result.concat(String.valueOf(num % 7));
                    num = num / 7;
                }

                for (int i = 0; i < result.length(); i++) {
                    s = s.concat(String.valueOf(result.charAt(result.length() - i - 1)));
                }
                s = "-" + s;
            } else {
                return "0";
            }

            return s;
        }
    }
}
