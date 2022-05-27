import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode935 {
    static int count = 0;
    final static int[][] board = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
    };
    final static int[][] DIRECTION = new int[][]{
        {2,1},
        {2,-1},
        {1,2},
        {1,-2},
        {-2,1},
        {-2,-1},
        {-1,2},
        {-1,-2}
    };
    public static void dfs(int n, int col, int row, int curLen, StringBuilder sb, Set<String> set){
        if(set.contains(sb.toString())){
            return;
        }else if(curLen>=n&&!set.contains(sb.toString())){
            set.add(sb.toString());
            count=(count+1)%(1000000007);
            return;
        }else if(col>=3||row>=4||col<0||row<0||board[row][col]==-1){
            return;
        }
        sb.append(board[row][col]);
        for (int[] ints : DIRECTION) {
            dfs(n,col+ints[0],row+ints[1],curLen+1,sb,set);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public static int knightDialer(int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(n,j,i,0,new StringBuilder(),new HashSet<>());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(knightDialer(1));
    }
}
