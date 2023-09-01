import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean flag = false;
        int start;
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0]>=intervals[i][1]&&newInterval[1]<=intervals[i][0]){
                // newInterval was included in specific intervals.
                list.add(intervals[i]);
                flag = true;

            }
            if(newInterval[0]<=intervals[i][0]){
                //         |_________|     |__________|
                //  |____________|
                start = newInterval[0];
                while(i<intervals.length&&newInterval[1]>intervals[i][1]){
                    i++;
                }
                if(i==intervals.length){
                    int end = newInterval[1];
                    list.add(new int[]{start,end});
                    flag = true;
                }else {
                    if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]){
                        int end = intervals[i][1];
                        list.add(new int[]{start,end});
                        i++;
                    }
                    else if(newInterval[1]<=intervals[i][0]){
                        int end = newInterval[1];
                        list.add(new int[]{start,end});
                    }
                    flag = true;
                    for(;i<intervals.length;i++){
                        list.add(intervals[i]);
                    }

                }
                break;
            }else if(newInterval[0]<=intervals[i][1]&&newInterval[0]>intervals[i][0]){


                //      |_________|     |__________|
                //             |_____|

                //       |_________|         |__________|
                //  |__|                |__|                |__|

                //      |_________|     |__________|
                //                   |______|
                start = intervals[i][0];
                while(i<intervals.length&&newInterval[1]>intervals[i][1]){
                    i++;
                }
                if(i==intervals.length){
                    int end = newInterval[1];
                    list.add(new int[]{start,end});
                    flag = true;
                }else {
                    //      |_________|     |__________|
                    //             |____________|
                    if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]){
                        int end = intervals[i][1];
                        list.add(new int[]{start,end});
                        i++;
                    }
                    else if(newInterval[1]<=intervals[i][0]){
                        int end = newInterval[1];
                        list.add(new int[]{start,end});
                    }
                    flag = true;
                    for(;i<intervals.length;i++){
                        list.add(intervals[i]);
                    }

                }
                break;
            }else if(newInterval[0]>=intervals[i][1]){
                list.add(intervals[i]);
            }
        }
        if(!flag){
            list.add(newInterval);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        list.forEach(a->{
            System.out.println(a[0]+","+a[1]);
        });
        return result;
    }
    @Test
    public void test(){
        System.out.println(insert(new int[][]{{1,5},{6,7},{8,10},{12,16}},new int[]{0,3}));
    }
}
