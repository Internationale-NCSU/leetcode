public class leetcode79_II {
    public static boolean exist(char[][] board, String word) {
        Integer index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(backTracking(board,word,index,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean backTracking(char[][] board, String word, Integer index, int i, int j){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[i].length){
            return false;
        }
        if(word.charAt(index)==board[i][j]){
            board[i][j] = '*';
            boolean flag = backTracking(board,word,index+1,i+1,j)||
            backTracking(board,word,index+1,i-1,j)||
            backTracking(board,word,index+1,i,j+1)||
            backTracking(board,word,index+1,i,j-1);
            board[i][j] = word.charAt(index);
            return flag;
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board2 = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        System.out.println(exist(board,"ESC"));
    }
}
