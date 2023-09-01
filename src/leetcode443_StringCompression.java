import org.junit.Test;

import java.util.Arrays;

public class leetcode443_StringCompression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while(i+1<chars.length&&chars[i+1]==chars[i]){
                count++;
                i++;
            }
            if(count!=1){
                sb.append(chars[i]+""+count+"");
            }else {
                sb.append(chars[i]);
            }
        }

        char[] result = sb.toString().toCharArray();
        for (int i = 0; i < result.length; i++) {
            chars[i]=result[i];
        }
        return sb.toString().length();
    }
    @Test
    public void test(){
        System.out.println(compress(new char[]{'a','a','a','b','b','b'}));
    }

}
