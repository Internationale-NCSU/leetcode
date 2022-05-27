import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode2250 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = rectangles.length;
        List<Integer>[] bucket = new ArrayList[101];
        for (int i = 1; i <= 100; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int w = rectangles[i][0], h = rectangles[i][1];
            bucket[h].add(w);
        }
        for (int i = 1; i <= 100; i++) {
            Collections.sort(bucket[i]);
        }

        int m = points.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = points[i][0], y = points[i][1];
            int count = 0;
            for (int h = y; h < bucket.length; h++) {
                int index = ceiling(bucket[h], x);
                count += bucket[h].size() - index;
            }
            res[i] = count;
        }
        return res;
    }

    int ceiling(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    @Test
    public void test(){

    }
}
