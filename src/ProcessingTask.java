import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProcessingTask {
    public int minimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return a[1] - b[1];
        });
        int time = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < tasks.length; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            int period = tasks[i][2];
            int index = start;
            for (int j = start; j <= end; j++) {
                if (set.contains(j) && period > 0) {
                    period--;
                } else {
                    break;
                }
            }

            for (int j = end; j >= start; j--) {
                if (set.contains(j) && period > 0) {
                    period--;
                } else {
                    index = j;
                    break;
                }
            }

            for (int j = index; j >= index - period + 1; j--) {
                set.add(j);
            }
        }
        return set.size();
    }

    @Test
    public void test() {
        int[][] task = {{1, 3, 2}, {2, 5, 3}, {5, 6, 2}, {2, 6, 5},{2,7,6}};
        System.out.println(minimumTime(task));
    }
}
