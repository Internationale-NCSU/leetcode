import java.util.LinkedList;
import java.util.List;

public class leetcode254 {
    public static void findResult(int n,int factor,List<List<Integer>> result,List<Integer> path){
        for (int i = factor; i*i<=n ; i++) {
            if(n%i!=0){
                continue;
            }else {
                path.add(i);
                List<Integer> res = new LinkedList<>(path);
                res.add(n / i);
                result.add(res);
                if(i*i<=n/i) {
                    findResult(n/factor, i, result, path);
                }
                path.remove(path.size()-1);
            }
        }
    }
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        if(n>3) {
            findResult(n, 2, result, path);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getFactors(36));
    }
}
