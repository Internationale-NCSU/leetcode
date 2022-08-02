import org.junit.Test;

public class leetcode2358MaximumBumberOfGroupsEnteringACompetition {
    public int maximumGroups(int[] grades) {
        int k = 0, total = 0, n = grades.length;
        while (total + k + 1 <= n) {
            total += ++k;
        }
        return k;
    }
    @Test
    public void test(){
        System.out.println(maximumGroups(new int[]{1,2,3,4,5,6,999,666,444,333}));
    }
}
