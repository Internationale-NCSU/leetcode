public class leetcode1491 {
    public static void main(String[] args) {

    }

    class Solution {
        public double average(int[] salary) {
            int min = 2147483647;
            int max = 0;
            int sum = 0;
            for (int i = 0; i < salary.length; i++) {
                if (salary[i] > max) max = salary[i];
                if (salary[i] < min) min = salary[i];
                sum = sum + salary[i];
            }
            sum = sum - max - min;
            int average = sum / (salary.length - 2);
            return average;
        }
    }
}
