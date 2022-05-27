public class leetcode1688 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
    }

    public static int numberOfMatches(int n) {
        int sumOfContest = 0;
        while (n != 1) {
            sumOfContest += n / 2;
            if (n % 2 == 1) {
                n -= n / 2;
            } else
                n /= 2;
        }
        return sumOfContest;
    }
}
