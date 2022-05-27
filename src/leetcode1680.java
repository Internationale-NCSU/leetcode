public class leetcode1680 {
    public static int concatenatedBinary(int n) {
        int result = 0;
        for (int i = 1; i < n+1; i++) {
            String sb = Integer.toBinaryString(i);
            for (int j = 0; j < sb.length(); j++) {
                int digit = sb.charAt(j)-'0';
                result = result*2+digit;
                result = result%(1000000000+7);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(12));
    }
}
