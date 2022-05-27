public class leetcode926 {

    public static int minFlipsMonoIncr(String s) {
        int[] prefixSum = new int[s.length()+1];
        prefixSum[0] = 0;
        for (int i = 1; i < s.length()+1; i++) {
            if(s.charAt(i-1)=='1'){
                prefixSum[i] = prefixSum[i-1]+1;
            }else {
                prefixSum[i] = prefixSum[i-1];
            }
        }
        int n = s.length();
        int minFlips=0;
        int moreZeroNeeded = Integer.MAX_VALUE;
        int moreOneNeeded = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            moreOneNeeded = Math.min( moreOneNeeded,prefixSum[i]+n-i-(prefixSum[n]-prefixSum[i]));
        }
        return moreOneNeeded;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00011000"));
    }

}
