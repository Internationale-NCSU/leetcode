import java.util.HashMap;
import java.util.Map;

public class leetcode2140 {
    public static long dfs(int[][] questions,Map<Integer,Long> memo,int index){
        if(index>=questions.length){
            return 0;
        }
        if(memo.containsKey(index)){
            return memo.get(index);
        }

        long remainScore = 0;
        remainScore = Math.max( dfs(questions,memo,index+1),
                questions[index][0]+dfs(questions,memo,index+questions[index][1]+1));

        memo.put(index,remainScore);
        return remainScore;
    }
    public static long mostPoints(int[][] questions) {
        long result = 0;
        Map<Integer,Long> memo = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            result = Math.max(result,dfs(questions,memo,i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{
            {3,2},
            {4,3},
            {4,4},
            {2,1},
            {3,1},
            {2,3}
        }));
    }
}
