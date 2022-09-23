public class leetcode474_OnesAndZeros_DPwithMemo {
    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length][m+1][n+1];
        return calculate(strs,0,m,n,memo);
    }
    public int calculate(String[] strs,int i, int zeros, int ones, int[][][] memo){
        if(i == strs.length){
            return 0;
        }
        if(memo[i][zeros][ones] != 0 ){
            return memo[i][zeros][ones];
        }
        int[] count = strHelper(strs[i]);
        int taken = -1;
        if(zeros - count[0]>=0 && ones - count[1] >= 0){
            taken = calculate(strs, i+1,zeros-count[0], ones - count[1], memo) + 1;
        }
        int notTaken = calculate(strs, i+1, zeros, ones, memo);
        memo[i][zeros][ones] = Math.max(taken,notTaken);
        return memo[i][zeros][ones];
    }
    public int[] strHelper(String s){
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                count[1]++;
            }else {
                count[0]++;
            }
        }
        return count;
    }
}
