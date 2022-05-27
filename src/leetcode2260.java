import org.junit.Test;

import java.util.Arrays;

public class leetcode2260 {
    public int minimumCardPickup(int[] cards) {
        int[] pos = new int[1000000];
        Arrays.fill(pos,-1);
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if(pos[num]==-1){
                pos[num] = i;
            }else {
                int dist = i-pos[num]+1;
                if(dist<len){
                    len = dist;
                }
                pos[num] = i;
            }
        }
        return len==Integer.MAX_VALUE?-1:len;
    }
    @Test
    public void test()
    {
        System.out.println(minimumCardPickup(new int[]{3,4,2,3,4,7}));
    }
}
