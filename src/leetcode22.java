import java.util.LinkedList;
import java.util.List;

public class leetcode22 {
    public static void backTracking(List<String> result , String path, int n, int countLeft,int countRight){
        if(path.length()==n){
            result.add(path);
            return;
        }
        if(countLeft>n/2||countRight>n/2){
            return;
        }
        if(countLeft+1<=n/2){
            path = path.concat("(");
            backTracking(result,path,n,countLeft+1,countRight);
            path = path.substring(0,path.length()-1);
        }
        if(countRight+1<=n/2&&countLeft>countRight){
            path = path.concat(")");
            backTracking(result,path,n,countLeft,countRight+1);
            path = path.substring(0,path.length()-1);
        }

    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backTracking(result,"",n*2,0,0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }
}
