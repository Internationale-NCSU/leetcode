import java.util.*;

public class leetcode2368_ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize>0){
                qSize--;
                int node = q.poll();
                if(set.contains(node)){
                    continue;
                }
                visited[node] = true;
                for (int i = 0; i < list[node].size(); i++) {
                    int dstNode = list[node].get(i);
                    if(!visited[dstNode]&&!set.contains(dstNode)){
                        q.add(dstNode);
                    }
                }
            }
        }
        int ans = 0;
        for (boolean b : visited) {
            if(b){
                ans++;
            }
        }
        return ans;
    }
}
