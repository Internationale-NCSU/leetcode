import java.util.LinkedList;
import java.util.List;

public class leetcode43 {
    public static String multiply(String num1, String num2) {
        if((num1.length()==1&&Integer.valueOf(num1)==0)||
                (num2.length()==1&&Integer.valueOf(num2)==0)){
            return "0";
        }
        List<String> list = new LinkedList<>();

        for (int i = 0; i < num1.length(); i++) {
            int carrier = 0;
            int a = num1.charAt(num1.length()-i-1)-'0';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(0);
            }
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(num2.length()-j-1)-'0';
                int product = a*b+carrier;
                sb.append(product%10);
                carrier = product/10;
            }
            if(carrier!=0){
                sb.append(carrier);
            };
            list.add(sb.reverse().toString());
        }

        StringBuilder addAllResult = new StringBuilder();
        for (String num : list) {
            int index = 0;
            int len = addAllResult.length()>num.length()?addAllResult.length():num.length();
            int carrier = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                int a = i<num.length()?num.charAt(num.length()-i-1) - '0' : 0;
                int b = i<addAllResult.length()?addAllResult.charAt(addAllResult.length()-i-1) - '0' : 0;
                int sum = a + b +carrier;
                sb.append(sum%10);
                carrier = sum/10;
            }
            if(carrier>0){
                sb.append(carrier);
            }
            addAllResult = sb.reverse();
        }
        return addAllResult.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
}
