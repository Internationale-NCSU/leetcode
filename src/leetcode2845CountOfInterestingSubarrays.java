import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class leetcode2845CountOfInterestingSubarrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] preSum = new int[nums.size()+1];
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i)%modulo==k){
                preSum[i+1] = preSum[i]+1;
            }else{
                preSum[i+1] = preSum[i];
            }
        }
        int cnt = 0;
        int p1 = 0, p2 = 0;
        while(true){
            if(p1==p2&&p2==preSum.length-1){
                break;
            }
            if(p1==p2){

            }
            while(preSum[p2]-preSum[p1]%modulo<k){
                if(p2+1<preSum.length){
                    p2++;
                }

            }
            while(preSum[p2]-preSum[p1]==modulo+k){
                if(p2+1<preSum.length){
                    p2++;
                }
            }
        }
        return cnt;
    }
    @Test
    public void test(){
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(countInterestingSubarrays(list ,3,0));
    }
}
