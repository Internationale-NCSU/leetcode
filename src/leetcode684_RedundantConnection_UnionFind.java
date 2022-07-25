public class leetcode684_RedundantConnection_UnionFind {
    class DSU{
        int[] parents;
        int[] ranks;
        public DSU(int N){
            parents = new int[N];
            ranks = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }
        public int find(int x){
            if(parents[x]!=x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        public boolean union(int x,int y){
            int px = find(x);
            int py = find(y);
            if(px==py){
                return false;
            }
            if(ranks[py]>ranks[px]){
                parents[px] = py;
                ranks[py]++;
            }else{
                parents[py] = px;
                ranks[px]++;
            }
            return true;
        }
    }
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL+1);
        for (int[] edge : edges) {
            if(!dsu.union(edge[0],edge[1])){
                return edge;
            }
        }
        throw new Error();
    }
}
