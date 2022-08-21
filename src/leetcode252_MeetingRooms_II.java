public class leetcode252_MeetingRooms_II {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean[] timeline = new boolean[1000000];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1] ; j++) {
                if(!timeline[j]) {
                    timeline[j] = true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
