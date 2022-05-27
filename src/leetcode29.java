import static java.lang.Double.MAX_VALUE;

public class leetcode29 {
    public static int divide(int dividend, int divisor) {
        double a = dividend;
        double b = divisor;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a/b);
        System.out.println(MAX_VALUE);
        return dividend/divisor;
    }

    public static void main(String[] args) {
        divide(3,4);
    }
}
