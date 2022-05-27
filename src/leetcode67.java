public class leetcode67 {
    public static void main(String[] args) {
        String a = "11", b = "11";
        Solution s = new Solution();
        String result = s.addBinary(a, b);
        System.out.println(result);
    }

    static class Solution {
        public String addBinary(String a, String b) {

            String result = "";
            System.out.println("a.len:" + a.length() + " b.len:" + b.length());
            int len = a.length() > b.length() ? a.length() : b.length();
            System.out.println("len:" + len);
            int flag = 0;
            for (int i = 0; i < len; i++) {
                System.out.println("i:" + i);
                if (i < a.length() && i < b.length()) {

                    if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                        if (flag == 0) {

                            result = result.concat("0");
                            flag = 1;
                        } else {
                            result = result.concat("1");
                            flag = 0;
                        }
                    } else if ((a.charAt(i) == '1' && b.charAt(i) == '0') || a.charAt(i) == '0' && b.charAt(i) == '1') {
                        if (flag == 0)
                            result = result.concat("1");
                        else {
                            result = result.concat("0");
                            flag = 0;
                        }
                    } else {
                        if (flag == 0)
                            result = result.concat("0");
                        else {
                            result = result.concat("1");
                            flag = 0;
                        }
                    }
                } else {
                    if (i >= a.length()) {
                        System.out.println("Part II is on processing");
                        if (flag == 0) {
                            result = result.concat(String.valueOf(b.charAt(i)));
                        } else if (flag == 1) {
                            if (b.charAt(i) == '0') {
                                result = result.concat("1");
                                flag = 0;
                            } else if (b.charAt(i) == '1') {
                                result = result.concat("0");
                                flag = 0;
                            }
                        }
                    } else if (i >= b.length()) {

                        if (flag == 0) {

                            result = result.concat(String.valueOf(a.charAt(i)));
                        } else if (flag == 1) {

                            if (a.charAt(i) == '0') {
                                result = result.concat("1");
                                flag = 0;
                            } else {
                                System.out.println("Part III is on processing");
                                if (i != len - 1) {
                                    result = result.concat("0");
                                    flag = 0;
                                } else {
                                    result = result.concat("01");
                                }
                            }
                        }
                    }

                }
            }
            if (flag == 1) result = result.concat("1");
            return result;
        }

    }
}
