import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1235_top_down {
    static int[] memo = new int[50001];
    public static int nextAvailableJob(List<List<Integer>> list,int curIndex){
        // available job: startTime > curEndTime || endTime < curStartTime;
        List<Integer> curJob = list.get(curIndex);
        int curEndTime = curJob.get(1);
        int left = 0,right = list.size()-1;
        int nextJobIndex = list.size();
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid).get(0)>=curEndTime){
                nextJobIndex = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nextJobIndex;
    }
    public static int findMaxProfit(List<List<Integer>> list,int n,int position){
        if(position==n){
            return 0;
        }
        if(memo[position]!=-1){
            return memo[position];
        }
        int nextIndex = nextAvailableJob(list,position);
        int maxProfit = Math.max(findMaxProfit(list,n,position+1),list.get(position).get(2)+findMaxProfit(list,n,nextIndex));
        return memo[position]=maxProfit;
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.fill(memo,-1);
        for (int i = 0; i < startTime.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(startTime[i]);
            tmp.add(endTime[i]);
            tmp.add(profit[i]);
            list.add(tmp);
        }

        list.sort((a,b)->{
            return a.get(0)-b.get(0);
        });
        return findMaxProfit(list,list.size(),0);

    }
    public static void main(String[] args) {
        System.out.println(jobScheduling(
                new int[]{1,2,3,3},
                new int[]{3,4,5,6},
                new int[]{50,10,40,70}
        ));
    }
}
