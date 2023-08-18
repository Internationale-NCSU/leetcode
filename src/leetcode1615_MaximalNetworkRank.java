import org.junit.Test;

public class leetcode1615_MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadCount = new int[100];
        boolean [][] isConnected = new boolean[100][100];
        int maxRank = 0;
        for (int i = 0; i < roads.length; i++) {
            roadCount[roads[i][0]]++;
            roadCount[roads[i][1]]++;
            isConnected[roads[i][0]][roads[i][1]] = true;
            isConnected[roads[i][1]][roads[i][0]] = true;
        }
        for (int i = 0; i < roadCount.length-1; i++) {
            for (int j = i+1; j < roadCount.length; j++) {
                if(isConnected[i][j]){
                    maxRank = Math.max(maxRank,roadCount[i]+roadCount[j]-1);
                } else{
                    maxRank = Math.max(maxRank,roadCount[i]+roadCount[j]);
                }
            }
        }
        return maxRank;
    }
    @Test
    public void test(){
        System.out.println(maximalNetworkRank(2,new int[][]{{1,0}}));
    }
}
