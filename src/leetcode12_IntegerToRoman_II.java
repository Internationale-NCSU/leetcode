public class leetcode12_IntegerToRoman_II {
    public static String intToRoman(int num) {
        int[] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] symbols = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int index = value.length-1;
        String roman = "";
        while(num!=0){
            if(num<value[index]){
                index--;
            }else {
                roman = roman.concat(symbols[index]);
                num = num-value[index];
            }
        }
        return roman;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
    }
}
