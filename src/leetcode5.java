public class leetcode5 {
    public static String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        if(s.length()==0) {
            return s;
        }
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if(i<s.length()-1) {
                dp[i+1][i] = true;
            }
        }
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if(i<j){
//                    System.out.println("loc: ("+i+","+j+")");
//                    System.out.println("i:" +s.charAt(i)+", j:"+s.charAt(j));
//                    System.out.println("dp[i+1][j-1]="+dp[i+1][j-1]);
                    dp[i][j] = dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                    if(dp[i][j]==true&&(j-i>maxLen)){
                            start = i;
                            end = j;
                            maxLen = j-i;
                    }
                }
            }
        }

//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("baaabrcrcrcrcr"));
    }
}
