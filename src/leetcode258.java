public class leetcode258 {
    public static int addDigits(int num) {
        int tmp;
        while(num/10!=0){
            tmp = num;
            int sum = 0;
            while(tmp!=0){
                sum += tmp%10;
                tmp /=10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(0));
    }
}
