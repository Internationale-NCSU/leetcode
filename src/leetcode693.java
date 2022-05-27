import java.sql.SQLOutput;

public class leetcode693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n) {
        int flag = 0;
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s = s.append(n % 2);
            n = n / 2;
        }

        s.reverse();
        //  System.out.println(s.indexOf("0"));
        //  System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) != '1') {
                return false;
            }
            if (i % 2 == 1 && s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
