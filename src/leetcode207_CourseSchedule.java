import java.util.Stack;

public class leetcode207_CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] coursesMap = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            coursesMap[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        Stack<Integer> stack = new Stack<>();
        int[] inDegree = new int[numCourses];
        //degree[i][0/1] 0-out-degree 1-in-degree
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]] += 1;
        }
        boolean[] visited = new boolean[numCourses];
        int count = 0;
        while(true){
            boolean zeroInDegreeExist = false;
            for (int i = 0; i < inDegree.length; i++) {
                if(inDegree[i]==0&&!visited[i]){
                    zeroInDegreeExist = true;
                    stack.push(i);
                    visited[i] = true;
                    count++;
                }
            }
            if(zeroInDegreeExist==false){
                break;
            }
            while(!stack.isEmpty()){
                int node = stack.pop();
                for (int i = 0; i < numCourses; i++) {
                   if(coursesMap[node][i]==1){
                       inDegree[i]--;
                   }
                }
            }
        }
        if(count==numCourses){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[][] arr ={{0,1},{1,2}};
        System.out.println(canFinish(3,arr));
    }
}
