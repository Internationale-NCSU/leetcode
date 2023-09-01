import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode797_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,new LinkedList<>(),graph,0);
        return result;
    }
    public void backtracking(List<List<Integer>> result, Deque<Integer> path, int[][] graph, int index){
//        if(!path.isEmpty()){
//            System.out.println(path.getLast());
//        }

        if(index==graph.length){
            return;
        }
        path.addLast(index);
        if(!path.isEmpty()&&path.getLast()==graph.length-1){
            result.add(new ArrayList<>(path));
        }
        for (int j = 0; j < graph[index].length; j++) {
            backtracking(result,path,graph,graph[index][j]);
        }
        path.removeLast();
    }
    @Test
    public void test(){
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
