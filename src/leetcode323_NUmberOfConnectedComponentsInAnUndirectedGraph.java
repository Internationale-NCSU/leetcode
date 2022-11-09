public class leetcode323_NUmberOfConnectedComponentsInAnUndirectedGraph {
    class DisjointUnionSet{
        int[] parent;
        int[] rank;
        int count;
        public DisjointUnionSet(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < parent[i]; i++) {
                parent[i] = i;
            }
        }
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px==py){
                return;
            }
            if(rank[px]<=rank[py]){
                parent[px] = parent[py];
                rank[py]++;
            }else {
                parent[py] = parent[px];
                rank[px]++;
            }
            count--;
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x] ;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(n);
        for (int i = 0; i < edges.length; i++) {
            disjointUnionSet.union(edges[i][0],edges[i][1]);
        }
        return disjointUnionSet.count;
    }
}
