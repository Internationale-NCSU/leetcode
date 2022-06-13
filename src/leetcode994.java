
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode994 {
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
    final int[][] DIRECTION = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshCount = 0;
        boolean isAccomplished = false;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==2){
                    queue.add(new Pair<>(i,j));
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0){
            isAccomplished = true;
        }
        while(queue.size()>0){
            int s = queue.size();
            if(freshCount==0){
                isAccomplished = true;
                break;
            }
            while(s-->0){
                Pair<Integer,Integer> pos = queue.remove();
                int col = pos.getValue();
                int row = pos.getKey();
                for (int[] ints : DIRECTION) {
                    int c = col+ints[1];
                    int r = row+ints[0];
                    if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]==1){
                        grid[r][c]=2;
                        freshCount--;
                        queue.add(new Pair<>(r,c));
                    }

                }
            }
            minutes++;
        }
        if(isAccomplished) {
            return minutes;
        }else {
            return -1;
        }
    }
    @Test
    public void test(String[] args) {
        int[][] grid = new int[][]{
                {0,2}
        };
        System.out.println(orangesRotting(grid));
    }
}
