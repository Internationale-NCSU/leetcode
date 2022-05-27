public class leetcode999 {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    static class Solution {
        public int numRookCaptures(char[][] board) {
            int[] loc = new int[2];
            int pawn_num = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'R') {
                        loc[0] = i;
                        loc[1] = j;
                    }
                }
            }
            //South
            for (int i = loc[0]; i < Math.abs(board.length); i++) {
                if (board[i][loc[1]] == 'B') break;
                if (board[i][loc[1]] == 'p') {
                    pawn_num++;
                    break;
                }
            }
            //North
            for (int i = loc[0]; i >= 0; i--) {
                if (board[i][loc[1]] == 'B') break;
                if (board[i][loc[1]] == 'p') {
                    pawn_num++;
                    break;
                }
            }
            //East
            for (int i = loc[1]; i < Math.abs(board.length); i++) {
                if (board[loc[0]][i] == 'B') break;
                if (board[loc[0]][i] == 'p') {
                    pawn_num++;
                    break;
                }
            }
            //West
            for (int i = loc[1]; i >= 0; i--) {
                if (board[loc[0]][i] == 'B') break;
                if (board[loc[0]][i] == 'p') {
                    pawn_num++;
                    break;
                }
            }
            return pawn_num;

        }
    }
}
