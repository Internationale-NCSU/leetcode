public class leetcode6001 {
    public static long smallestNumber(long num) {
        long result = 0;
        boolean isMinos = false;
        if (num < 0) {
            isMinos = true;
            num = -num;
        }
        int totalDigits = 0;
        int[] digitsCount = new int[10];
        while (num != 0) {
            int digit = (int)Math.floorMod (num,10);
            totalDigits++;
            digitsCount[digit]++;
            num = num / 10;
        }
        boolean isFirst = true;
        while (totalDigits > 0) {
            if (!isMinos) {
                for (int i = 0; i < digitsCount.length; i++) {
                    if (isFirst && i == 0) {
                        isFirst = false;
                        continue;
                    }
                    if (digitsCount[i] > 0) {
                        result = result * 10 + i;
                        digitsCount[i]--;
                        break;
                    }
                }
            } else {
                for (int i = digitsCount.length-1; i >= 0; i--) {
                    if (digitsCount[i] > 0) {
                        result = result * 10 + i;
                        digitsCount[i]--;
                        break;
                    }
                }
            }
            totalDigits--;
        }
        return isMinos?-result:result;
    }
    public static void main(String[] args) {

        System.out.println(smallestNumber(2170596702l));
    }
}
