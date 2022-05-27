import java.util.Arrays;

public class maxLenSameChaNumSubstring {
    public static int findMaxLen(String s){
        int[][] preSum = new int[s.length()][26];
        char[] charArrays = s.toCharArray();
        //preSum[i][j] represents from 0 to i, times of char j appearing
        for (int i = 0; i < s.length(); i++) {
            if(i==0){
                preSum[i][charArrays[i]-'a']++;
                continue;
            }
            preSum[i] = Arrays.copyOf(preSum[i-1],26);
            preSum[i][charArrays[i]-'a']++;
        }
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < s.length()-1; i++) {
            int[] temp;
            for (int j = i; j < s.length(); j++) {
                temp = Arrays.copyOf(preSum[j],26);
                if(i!=0) {
                    for (int k = 0; k < 26; k++) {
                        temp[k] = temp[k] - preSum[i-1][k];
                    }
                    if (isValid(temp)) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }else {
                    if (isValid(temp)) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }

            }
        }

        return maxLen;
    }
    public static boolean isValid(int[] nums){
        int target = -1;
        for (int num : nums) {
            if(target == -1){
                target = num;
            }else if(num!=target&&num!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLen("afaabbccf"));
    }
}
