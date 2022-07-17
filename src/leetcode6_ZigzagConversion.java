import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class leetcode6_ZigzagConversion {
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        String[] converts = new String[numRows];
        int i = 0;
        boolean down = true;
        int index = 0;
        while(index<s.length()){
            if(converts[i]==null){
                converts[i] = "";
            }
            converts[i] = converts[i].concat(String.valueOf(s.charAt(index)));
            if(down&&i<converts.length){
                if(i==converts.length-1){
                    down = false;
                    i = i-2;
                }
                index++;
                i++;
            }else if(!down&&i>=0){
                if(i==0){
                    down = true;
                    i = i+2;
                }
                index++;
                i--;
            }
        }
        String result = Arrays.stream(converts).filter(Objects::nonNull).collect(Collectors.joining());
        return result;
    }

    public static void main(String[] args) {
        String s = "P";
        System.out.println(convert(s,2));
    }
}
