import java.util.ArrayList;
import java.util.List;

public class leetcode2830MaximizeTheProfitAsTheSalesman {


    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // Firstly we iterate offers,
        // and arrange offers in a list m,
        // where m[end] is the list of offers ending at end.
        // Secondly we go through end from 1 to n,
        // For each end,
        // we initialize dp[end] = dp[end - 1],
        // since we can remain the endth house.
        // Then we check each offer ending at end,
        // we update dp[end] = max(dp[end], dp[start] + gold)
        // Finally we return dp[n] as result.
        List<List<List<Integer>>> m = new ArrayList<>();
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            m.add(new ArrayList<>());
        }
        for (List<Integer> offer : offers) {
            m.get(offer.get(1)).add(offer);
        }
        for (int end = 1; end <= n; end++) {
            dp[end] = dp[end-1];
            for (List<Integer> a : m.get(end - 1)) {
                dp[end] = Math.max(dp[end], dp[a.get(0) + dp[a.get(2)]]);
            }
        }
        return dp[n];
    }
}
