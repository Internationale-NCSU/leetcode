import java.util.Arrays;

public class leetcode252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if(intervals[i][1]>intervals[j][0]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
