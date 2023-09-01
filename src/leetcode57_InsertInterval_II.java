import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode57_InsertInterval_II {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int first = newInterval[0];
        int second = newInterval[1];
        int start = -1;
        int end = -1;
        boolean intersectionStart = false;
        boolean intersectionEnd = false;
        boolean isAddedInterval = false;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(!intersectionStart&&!intersectionEnd&&(first<=intervals[i][0]||first<=intervals[i][1])){
                if(first<=intervals[i][0]) {
                    start = first;
                }else {
                    start = intervals[i][0];
                }
                intersectionStart = true;

            }
            if(intersectionStart&&!intersectionEnd&&second<=intervals[i][0]){
                if(i-1>=0&&second==intervals[i][0]){
                    end = intervals[i][1];
                    if(i+1<intervals.length){
                        i++;
                    }
                }else if(i-1>=0&&second<=intervals[i-1][1]){
                    end = intervals[i-1][1];
                }else if(i-1>=0&&second>intervals[i-1][1]){
                    end = second;
                }else{

                    end = second;
                }
                intersectionStart = false;
                intersectionEnd = true;
            }
            if(intersectionEnd&&!intersectionStart&&!isAddedInterval){
                list.add(new int[]{start,end});
                isAddedInterval = true;
            }
            if(!intersectionStart){
                list.add(intervals[i]);
            }
        }
        if(!intersectionStart&&!intersectionEnd){
            start = first;
            end = second;
            list.add(new int[]{start,end});
        }
        if(intersectionStart&&!intersectionEnd){
            end = second;
            list.add(new int[]{start,end});
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
        System.out.println(insert(new int[][]{{1,5},{6,7},{8,10},{12,16}},new int[]{2,8}));
    }
}
