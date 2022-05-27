import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode253 {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        int maxSize = 1;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{return a[1]-b[1];});
        for (int i = 0; i < intervals.length; i++) {
            priorityQueue.add(intervals[i]);
            if(intervals[i][0]>=priorityQueue.peek()[1]){
                priorityQueue.poll();
            }
            maxSize = Math.max(maxSize,priorityQueue.size());

        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{1,13},{13,15},{2,16}};
        System.out.println(minMeetingRooms(intervals));
    }
}
