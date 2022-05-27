import java.util.HashMap;
import java.util.Map;

public class leecode454 {
    public static void main(String[] args) {
        int[] A = {-1, 1, 1, 1, -1};
        int[] B = {0, -1, -1, 0, 1};
        int[] C = {-1, -1, 1, -1, -1};
        int[] D = {0, 1, 0, -1, -1};
        int times = Solution.fourSumCount(A, B, C, D);
        System.out.println(times);
    }
}

class Solution {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int times = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                if (!map.containsKey(i + j))
                    map.put(i + j, 1);
                else {
                    map.replace(i + j, (map.get(i + j)) + 1);
                }
            }
        }
        for (int k : C) {
            for (int l : D) {
                if (map.containsKey(-k - l)) times = map.get(-k - l) + times;
            }
        }
        /*
        for(int i:A){
            for(int j:B){

            }
        }

        for(int k:C){
            for(int l:D){
                if(k+l==0){
                    System.out.println("("+i+" "+j+" "+k+" "+l+")");

                    times++;
                }
            }
        }*/

        return times;
    }
}