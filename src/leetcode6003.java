public class leetcode6003 {
    public static int minimumTime(String s) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                num[i] = -1;
            }else {
                num[i] = 1;
            }
        }
        int[] dp = new int[s.length()];
        dp[0] = num[0];
        for (int i = 1; i < dp.length ; i++) {
            dp[i] = Math.min(num[i],num[i]+dp[i-1]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime("111100"));
    }
}
