import org.junit.Test;

public class leetcode12_IntegerToRoman_III {
    public String intToRoman(int num) {
        int[] value = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        while(num>0){
            for (int i = value.length-1; i >=0 ; i--) {
                if(num>=value[i]){
                    sb.append(roman[i]);
                    num = num-value[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(intToRoman(999));
    }
}
