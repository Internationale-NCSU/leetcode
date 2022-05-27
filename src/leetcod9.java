public class leetcod9 {
    public static void main(String[] args) {
        boolean result = solution.isPalindrome(12321);
        System.out.println(result);
    }
}

class solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int n = x;
        int p = 0;

        while (n != 0) {
            p = p * 10 + n % 10;
            n = n / 10;
        }
        if (x == p) return true;
        else return false;
    }
}