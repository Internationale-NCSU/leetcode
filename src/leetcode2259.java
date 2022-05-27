import org.junit.Test;

public class leetcode2259 {
    public String removeDigit(String number, char digit) {
        char[] num = number.toCharArray();
        int index=0;
        for(int i = 0; i<number.length(); i++){
            if(num[i] - digit == 0){
                index = i;
                if(i != number.length()-1 && num[i] < num[i+1]){
                    break;
                }
            }
        }
        return number.substring(0,index)+number.substring(index+1,number.length());
    }
    @Test
    public void test(){
        System.out.println(removeDigit("3953",'3'));
    }
}
