import org.junit.Test;

import java.util.*;

public class leetcode1090_LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] pairs = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
        }
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        Map<Integer,Integer> label = new HashMap<>();
        int sum = 0;
        int index = 0;
        while(numWanted>0&&index<pairs.length){
            if(!label.containsKey(pairs[index][1])){
                sum+=pairs[index][0];
                label.put(pairs[index][1],1);
                numWanted--;
            }else if(label.get(pairs[index][1])<useLimit) {
                label.put(pairs[index][1],label.get(pairs[index][1])+1);
                sum+=pairs[index][0];
                numWanted--;
            }else {
                index++;
                continue;
            }
            index++;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(largestValsFromLabels(new int[]{4,6,3,9,2},new int[]{2,0,0,0,2},4,2));
    }
}
