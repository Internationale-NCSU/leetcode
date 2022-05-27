public class leetcode717 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] bits = {1, 1, 1, 0};
        System.out.println(s.isOneBitCharacter(bits));
    }

    static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int flag = 1;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == 1) {
                    i++;
                    flag = 2;
                    //System.out.println("character: "+bits[i-1]+bits[i]);
                    continue;
                } else {
                    // System.out.println("character: "+bits[i]);
                    flag = 1;
                }

            }
            switch (flag) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
            return true;
        }
    }
}
