import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode56 {
    public static int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i; j < intervals.length; j++) {
                if(intervals[i][0]>intervals[j][0]){
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
          //  System.out.println(intervals[i][0]);
        }
//        List<int[]> mergeArrays = new LinkedList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            while(i!=intervals.length-1&&intervals[i][1]>=intervals[i+1][0]) {
//                int arr[] = new int[2];
//                arr[0] = intervals[i][0];
//                arr[1] = intervals[i][1] > intervals[i + 1][1] ? intervals[i][1] : intervals[i + 1][1];
//                mergeArrays.add(arr);
//                i++;
//            }
//        }
//        for (int i = 0; i < mergeArrays.size(); i++) {
//            result[i] = mergeArrays.get(i);
//            System.out.println("("+result[i][0]+","+result[i][1]+")");
//        }
        List<int[]> mergeArrays = new LinkedList<>();
        int[][] result = new int[mergeArrays.size()][2];
        int start =0,end = 0;

        for (int i = intervals[0][0]; i < intervals[intervals.length-1][1]; i++) {
            
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3},{3,4}};
        merge(intervals);
    }
}
