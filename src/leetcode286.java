import java.util.*;

public class leetcode286 {
    class Pair<K,V>{
        K k;
        V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
        public K getKey(){
            return this.k;
        }
        public V getValue(){
            return this.v;
        }
    }

    private final List<int[]> DIRECTION = Arrays.asList(
            new int[] {1,0},
            new int[] {0,1},
            new int[] {-1,0},
            new int[] {0,-1}
    );
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int stepCount = 1;
        int m = rooms.length,n =rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rooms[i][j]==0){
                    queue.add(new Pair<>(i,j));
                }
            }
        }
        while(queue.size()>0){
            int s = queue.size();
            while (s-->0){
                Pair<Integer,Integer> pos = queue.remove();
                int row = pos.getKey();
                int col = pos.getValue();
                for (int[] ints : DIRECTION) {
                    int r = row+ints[0];
                    int c = col+ints[1];
                    if(r>=0&&r<m&&c>=0&&c<n&&rooms[r][c]!=0&&rooms[r][c]!=-1){
                        if(stepCount<rooms[r][c]){
                            rooms[r][c] = stepCount;
                            queue.add(new Pair<>(r,c));
                        }
                    }
                }
            }
            stepCount++;
        }
    }

}
