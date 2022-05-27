import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode401 {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(9));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> result;
        HashMap<Integer, List<String>> statistic = new HashMap<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                int cursor = 0;
                int times = 0;
                String upper = Integer.toBinaryString(i);
                String lower = Integer.toBinaryString(j);
                while (true) {
                    if (cursor >= upper.length()) break;

                    if (upper.charAt(cursor) == '1') times++;
                    cursor++;
                }
                cursor = 0;
                while (true) {
                    if (cursor >= lower.length()) break;

                    if (lower.charAt(cursor) == '1') times++;
                    cursor++;
                }
                String time;
                if (j < 10) {
                    time = i + ":0" + j;
                } else {
                    time = i + ":" + j;
                }
                System.out.println("hours:" + upper + " minutes:" + lower + " " + time + ":" + times);

                if (!statistic.containsKey(times)) {
                    List<String> cur = new ArrayList<>();

                    cur.add(time);
                    statistic.put(times, cur);
                } else {
                    List<String> cur = statistic.get(times);
                    cur.add(time);
                    statistic.replace(times, cur);
                }
            }
        }
        if (statistic.containsKey(num)) {
            result = statistic.get(num);

        } else {
            result = new ArrayList<>();
        }
        return result;
    }
}
