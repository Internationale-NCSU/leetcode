public class leetcode682 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] S = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(s.calPoints(S));
    }

    static class Solution {
        public int calPoints(String[] ops) {
            int sum = 0;
            int i = 0;
            int[] num = new int[ops.length];

            for (String s : ops) {
                //System.out.println("i:"+i);
                switch (s) {
                    case "+": {
                        int tmp = num[i - 1] + num[i - 2];
                        num[i] = tmp;
                        ops[i] = String.valueOf(tmp);
                        i++;
                        break;
                    }
                    case "D": {
                        int tmp = num[i - 1] * 2;
                        num[i] = tmp;
                        i++;
                        break;
                    }
                    case "C": {
                        num[i - 1] = 0;
                        i--;
                        break;
                    }
                    default: {
                        int tmp = Integer.parseInt(s);
                        num[i] = tmp;
                        i++;
                        break;
                    }

                }
            }

            for (int n : num) {
                // System.out.println("num:" +n);
                sum += n;
            }

            return sum;
        }
    }
}
