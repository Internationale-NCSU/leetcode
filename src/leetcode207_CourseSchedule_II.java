import java.util.*;

public class leetcode207_CourseSchedule_II {
    class Pair<K,V> {
        K k;
        V v;
        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
        public K getK(){
            return k;
        }
        public V getV(){
            return v;
        }
        public void setK(K k){
            this.k = k;
        }
        public void setV(V v){
            this.v = v;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[1];
            if(map.containsKey(to)){
                map.put(to,map.get(to)+1);
            }else {
                map.put(to,1);
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        return true;
    }
}
