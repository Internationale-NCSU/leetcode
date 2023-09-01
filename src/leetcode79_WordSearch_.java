public class leetcode79_WordSearch_ {
    public boolean backtracking(char[][]board, String word,int index, int i, int j){
        if(index==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if(word.charAt(index)!=board[i][j]){
            return false;
        }else {
            board[i][j] = '*';
            boolean flag = backtracking(board,word,index+1,i+1,j)||
                    backtracking(board,word,index+1,i-1,j)||
                    backtracking(board,word,index+1,i,j+1)||
                    backtracking(board,word,index+1,i,j-1);
            board[i][j] = word.charAt(index);
            return flag;
        }
    }
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result = false|backtracking(board,word,0,i,j);
            }
        }
        return result;
    }
}
