import java.util.Deque;
import java.util.LinkedList;

public class leetcode526 {
    static int count = 0;
    public static void backTrack(boolean[] isVisited,Deque<Integer> path,int n,int index){
        if(path.size()==n){
            count++;
        }else if(path.size()>n){
            return;
        }
        for (int i = 1; i < n+1; i++) {
            if(isVisited[i-1]){
                continue;
            }
            if(i%(path.size()+1)==0||(path.size()+1)%i==0){
                path.addLast(i);
                isVisited[i-1] = true;
                backTrack(isVisited,path,n,i+1);
                isVisited[i-1] = false;
                path.removeLast();
            }else {
                continue;
            }
        }

    }
    public static int countArrangement(int n) {
        Deque<Integer> path = new LinkedList<>();
        backTrack(new boolean[n],path,n,1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(1));
    }
}
