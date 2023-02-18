package toolbox;

import org.apache.poi.hpsf.Decimal;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode2564_SubstringXORQueries {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                int val = Integer.parseInt(s.substring(i,j),2);
                if(!map.containsKey(val)){
                    map.put(val,new int[]{i,j});
                }else {
                    int[] res = map.get(val);
                    if(j - i + 1 < res[1] - res[0]){
                        map.put(val,new int[]{i,j});
                    }
                }
            }
        }
       int[][] result = new int[queries.length][];
        int index = 0;
        for (int[] query : queries) {
            int val = query[0]^query[1];
            if(map.containsKey(val)){
                int[] res = map.get(val);
                result[index] = res;
            }else {
                result[index] = new int[]{-1,-1};
            }
            index++;
        }
        return result;
    }
    @Test
    public void test(){
        int[][] result = substringXorQueries("101101",new int[][]{{0,5},{1,2}});
    }
}
