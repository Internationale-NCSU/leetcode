import org.junit.Test;

import java.util.*;

public class leetcode373_II {
    class Cell{
        int i,j;
        Cell(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums1==null||nums2==null){
            return result;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a,b)->(nums1[a.i]+nums2[a.j]-nums1[b.i]-nums2[b.j])
        );
        pq.add(new Cell(0,0));
        HashSet<String> visited = new HashSet<>();
        visited.add(""+0+","+0);
        while(k>0&&!pq.isEmpty()){
            Cell top = pq.poll();
            result.add(Arrays.asList(nums1[top.i],nums2[top.j]));

            Cell pair = new Cell(top.i+1,top.j);
            if(pair.i<nums1.length&&pair.j<nums2.length&&!visited.contains(""+pair.i+","+pair.j)){
                visited.add(""+pair.i+","+pair.j);
                pq.offer(pair);
            }
            pair = new Cell(top.i,top.j+1);
            if(pair.i<nums1.length&&pair.j<nums2.length&&!visited.contains(""+pair.i+","+pair.j)){
                visited.add(""+pair.i+","+pair.j);
                pq.offer(pair);
            }
            k--;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(kSmallestPairs(new int[]{1,7,11},new int[]{2},3));
    }
}
