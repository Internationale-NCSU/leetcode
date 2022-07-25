import org.junit.Test;

public class leetcode947_MostStonesRemovedWithSameRowOrColumn_UnionFind {
    class DisjointUnionSet{
        private int[] rank;
        private int[] parents;
        private int count;
        public DisjointUnionSet(int n){
            rank = new int[n];
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        //flatten the tree;
        private int find(int x){
            if(parents[x]!=x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        //union by rank;
        public void union(int x,int y){
            int px = find(x);
            int py = find(y);
            if(px==py){
                return;
            }
            if(rank[px] <= rank[py]){
                parents[px] = parents[py];
                rank[py]++;
            }else {
                parents[py] = parents[px];
                rank[px]++;
            }
            count--;
        }
    }
    public int removeStones(int[][] stones) {
        DisjointUnionSet dsu = new DisjointUnionSet(stones.length);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    dsu.union(i,j);
                }
            }
        }
        return stones.length-dsu.count;
    }
    @Test
    public void test(){

    }
}
