import java.util.HashSet;
import java.util.Set;

public class leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> hasSeen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                if(
                      !hasSeen.add("col "+i+" has seen "+board[i][j])||
                      !hasSeen.add("row "+j+" has seen "+board[i][j])||
                      !hasSeen.add("subBox "+i/3+j/3+" has seen "+board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
