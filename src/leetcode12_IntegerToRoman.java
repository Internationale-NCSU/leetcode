public class leetcode12_IntegerToRoman {
    public static String intToRoman(int num) {
        int[] values = {    1,  4,   5,  9,  10,  40,  50, 90, 100, 400,500,900,1000};
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int res = 12;
        String result = "";
        while(num>0){
            if(num>=values[res]){
                result = result.concat(romans[res]);
                num = num - values[res];
            }else {
                res--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
