public class leetcode868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(2897));
    }

    public static int binaryGap(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s = s.append(String.valueOf(n % 2));
            n = n / 2;
        }
        s.reverse();
        System.out.println(s);
        int index = 0;
        int distance = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int tmp = i - index;
                System.out.println("i:" + i + " tmp:" + tmp);
                if (tmp >= distance) {
                    distance = tmp;
                }
                index = i;
            }
        }
        return distance;

    }
}
