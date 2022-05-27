import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode77 {
    public static void dfs(List<List<Integer>> result, Deque<Integer> path,int index,int n,int k){
        if(path.size()==k){
            List<Integer> list = new LinkedList<>(path);
            result.add(list);
            return;
        }
        for (int i = index; i < n+1; i++) {
            path.addLast(i);
            dfs(result,path,i+1,n,k);
            path.removeLast();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(result,path,1,n,k);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
