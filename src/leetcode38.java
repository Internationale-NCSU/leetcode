import java.math.BigInteger;

public class leetcode38 {
    public static String countAndSay(int n) {
        String result = "";
        BigInteger num = new BigInteger("1");
        if(n==1){
            return "1";
        }
        while(n>1){
            result = transForm(num);
            num = new BigInteger(result);
            n--;
        }
        return result;
    }
    public static String transForm(BigInteger n){
        String s = "";
        String value = String.valueOf(n);
        if(value.length()==1){
            return "1"+value;
        }
        int index = 0;
        int count = 0;
        //特殊处理最后一个数
        while(index<value.length()-1){
            count = count + 1;
            if(index+1<value.length()-1&&value.charAt(index+1)==value.charAt(index)){
                index++;
                continue;
            }else {
                s = s.concat(String.valueOf(count)+String.valueOf(value.charAt(index)));
                count = 0;
            }
            index++;
        }
        if(value.charAt(index)==value.charAt(index-1)){
            String lastSec = String.valueOf(s.charAt(s.length()-2)-'0'+1);
            String lastOne = String.valueOf(s.charAt(s.length()-1));
            s = s.substring(0,s.length()-2);
            s = s.concat(lastSec);
            s = s.concat(lastOne);
        }else {
            s = s.concat("1").concat(String.valueOf(value.charAt(value.length()-1)));
        }
        return s;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(countAndSay(i));
        }

    }
}
