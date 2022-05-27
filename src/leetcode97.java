public class leetcode97 {
    public static boolean isInterleave(String s1, String s2, String s3) {

        boolean dp[][] = new  boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                if(i==0 && j==0){
                    //System.out.print(dp[i][j]+", ");
                    continue;
                }
                //初始化第一行与第一列i=0,j=0
                else if(j==0){
                    dp[i][j] = s1.substring(0,i).equals(s3.substring(0,i));
                }else if(i==0){
                    dp[i][j] = s2.substring(0,j).equals(s3.substring(0,j));
                }else {
                    //状态转移方程 s1或s2与当前字符相同 && 上一子串是s3子串
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
                            || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                //System.out.print(dp[i][j]+", ");
            }

            //System.out.println();

        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void dfs(boolean dp[][],char[] s1, char[] s2, char[] s3,int i ,int j,int cur,Boolean isIntersect){
        if(cur==s3.length){
            isIntersect=true;
            return ;
        }
        if(s1[i]==s3[cur]) {
            dfs(dp,s1, s2, s3, i + 1, j, cur + 1,isIntersect);
        }else if(s2[j]==s3[cur]) {
            dfs(dp,s1, s2, s3, i,j + 1,cur + 1,isIntersect);
        }
        return;
    }
    public static void main(String[] args) {
        System.out.println(isInterleave("","","ad"));
    }
}
