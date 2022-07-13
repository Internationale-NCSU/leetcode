public class leetcode348 {
    class TicTacToe {
        int winLimit;
        boolean isEnd = false;
        int[] row1;
        int[] row2;
        int[] col1;
        int[] col2;
        int diaLr1 = 0;
        int diaLr2 = 0;
        int diaRl1 = 0;
        int diaRl2 = 0;
        public TicTacToe(int n) {
            winLimit = n;
            row1 = new int[n];
            row2 = new int[n];
            col1 = new int[n];
            col2 = new int[n];
        }
        public int move(int row, int col, int player) {
            if(player==2){
                row2[row]++;
                col2[col]++;
                if(row==col){
                    diaLr2++;
                }
                if(row+col==winLimit-1){
                    diaRl2++;
                }
                if(row2[row]==winLimit|| col2[col]==winLimit|| diaLr2 ==winLimit|| diaRl2 ==winLimit){
                    return player;
                }
            }else {
                row1[row]++;
                col1[col]++;
                if(row==col){
                    diaLr1++;
                }
                if(row+col==winLimit-1){
                    diaRl1++;
                }
                if(row1[row]==winLimit|| col1[col]==winLimit|| diaLr1 ==winLimit|| diaRl1 ==winLimit){
                    return player;
                }
            }
            return 0;
        }
    }
}
