//import java.util.Deque;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//
//public class leetcode79 {
////    public static class Point{
////        int i;
////        int j;
////        public Point(int i, int j) {
////            this.i = i;
////            this.j = j;
////        }
////    }
//
//    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board2 = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
////        System.out.println(exist(board,"BCCFB"));
//
//    }
//    public static boolean exist(char[][] board, String word) {
////        Deque<Point> path = new LinkedList<>();
////        boolean[][] isTried = new boolean[board.length][board[0].length];
////        for (int i = 0; i < board.length ; i++) {
////            for (int j = 0; j < board[i].length; j++) {
////                dfs(board,isTried,word,0,i,j,path,0);
////                if(path.size()==word.length()){
////                    return true;
////                }
////                path.clear();
////            }
////        }
////        return false;
//    }
//    public static void dfs(char[][] board, boolean [][] isTried,String word, int k, int i, int j, Deque<Point> curPos, int denyDirection){
////        //denyDirection 1:up,2:down,3:left,4:right;
////        if(curPos.size()==word.length()){
////            return;
////        }
////        Point position = new Point(i,j);
////        curPos.addLast(position);
////        isTried[i][j] = true;
////        if(board[i][j]==word.charAt(k)){
////            if(i>0&&denyDirection!= 1&&!isTried[i-1][j]){
////                if(board[i--][j]==word.charAt(k+1)){
////                  dfs(board,isTried,word,k+1,i-1,j,curPos,2);
////                }
////            }
////            if(i>0&&denyDirection!= 1&&!isTried[i-1][j]){
////                if(board[i--][j]==word.charAt(k+1)){
////                    dfs(board,isTried,word,k+1,i-1,j,curPos,2);
////                }
////            }
////            if(i>0&&denyDirection!= 1&&!isTried[i-1][j]){
////                i--;
////                dfs(board,isTried,word,k+1,i,j,curPos,2);
////                i++;
////            }
////            if(i<board.length-1&&denyDirection!=2&&!isTried[i+1][j]){
////                i++;
////                dfs(board,isTried,word,k+1,i,j,curPos,1);
////                i--;
////            }
////            if(j>0&&denyDirection!=3&&!isTried[i][j-1]){
////                j--;
////                dfs(board,isTried,word,k+1,i,j,curPos,4);
////                j++;
////            }
////            if(j<board[0].length-1&&denyDirection!=4&&!isTried[i][j+1]){
////                j++;
////                dfs(board,isTried,word,k+1,i,j,curPos,3);
////                j--;
////
//////            }
////        }else {
////           if(!curPos.isEmpty()){
////               isTried[i][j] = false;
////               curPos.removeLast();
////           }
////        }
////    }
//}
