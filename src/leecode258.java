public class leecode258 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addDigits(38));

    }

    static class Solution {
        public int addDigits(int num) {
            int sum = 999;
            while (sum >= 10) {
                sum = 0;
                while (num > 0) {
                    sum = sum + num % 10;
                    num = num / 10;
                }
                //System.out.println(sum);
                num = sum;
            }
            return sum;
        }
    }
}


