public class leetcode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, ugly[index[j]] * primes[j]);
            }
            ugly[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[index[j]] * primes[j] == min) {
                    index[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
