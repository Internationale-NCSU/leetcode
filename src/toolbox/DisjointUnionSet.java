package toolbox;

public class DisjointUnionSet {
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
