public class leetcode2414_LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int len = 1;
        if(s.length()==1){
            return 1;
        }
        int right = 1,left = 0;
        while(right<s.length()){
            if(s.charAt(right)==s.charAt(right-1)+1){
                len = Math.max(len, right-left+1);
            }else {
                left=right;
            }
            right++;
        }
        return len;
    }
}
