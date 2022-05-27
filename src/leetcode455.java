import java.util.Arrays;

public class leetcode455 {
    public static void main(String[] args) {
        Solution S = new Solution();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(S.findContentChildren(g, s));

    }

    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int content_num = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j] >= g[i]) {
                        s[j] = 0;
                        content_num++;
                        break;
                    }
                }
            }
            return content_num;
        }
    }
}
