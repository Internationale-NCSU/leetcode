import java.util.Arrays;

public class leetcode274 {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            hIndex = citations[i];
             if(citations[i]>citations.length-i){
                 break;
             }
        }
        return hIndex;
    }
}
