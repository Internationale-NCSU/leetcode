public class leetcode441 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.arrangeCoins(5));
    }

    static class Solution {
        public int arrangeCoins(int n) {
            int total = 0;
            int ini = 1;
            for (int i = 0; ; i++) {
                if (n < ini) break;
                n = n - ini;
                total = total + 1;
                ini = ini + 1;
            }
            return total;
        }
    }
}
