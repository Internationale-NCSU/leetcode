import java.util.LinkedList;
import java.util.List;

public class leetcode51 {
    public boolean put(int x,int y,int n,List<Integer> col,List<Integer> dialog1,List<Integer> dialog2){
        String s = "";
        for (int i = 0; i < n; i++) {
            if(i==x){
                s = s.concat("Q");
            }else {
               s = s.concat(".");
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<String> row = new LinkedList<>();
        List<Integer> col = new LinkedList<>();
        List<Integer> dialog1 = new LinkedList<>();
        List<Integer> dialog2 = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        return result;
    }
}
