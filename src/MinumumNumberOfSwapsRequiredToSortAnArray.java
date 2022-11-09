import org.junit.Test;

import java.util.ArrayList;
import java.util.*;
public class MinumumNumberOfSwapsRequiredToSortAnArray {
    class Pair<K,V>{
        K k;
        V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
        K getKey(){
            return k;
        }
        V getValue(){
            return v;
        }
    }
    public int minSwaps(int[] arr)
    {
        int n = arr.length;
        ArrayList <Pair <Integer, Integer> > elemPosPairs = new ArrayList <> ();
        for (int i = 0; i < n; i++) {
            elemPosPairs.add(new Pair<>(arr[i], i));
        }
        elemPosPairs.sort((a,b)-> {
                    return b.getKey() - a.getKey();
                });
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (vis[i] || elemPosPairs.get(i).getValue() == i){
                continue;
            }
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;
                j = elemPosPairs.get(j).getValue();
                cycle_size++;
            }
            if(cycle_size > 0)
            {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(minSwaps(new int[]{1,5,4,3,2}));
    }
}
