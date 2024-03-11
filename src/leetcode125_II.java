import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

        public class leetcode125_II {
            public boolean isPalindrome(String s) {
                s = s.toLowerCase();
                char[] arr = s.toCharArray();
                String output = s
                        .chars() // 创建一个IntStream
                        .filter(a->{
                            return Character.isLetter(a)||Character.isDigit(a);
                        }) // 过滤，只保留字母
                        .mapToObj(a->String.valueOf((char)a))
                        .collect(Collectors.joining())// 合并StringBuilder
                        .toString(); // 转换为String
        int left = 0, right = output.length()-1;
        while(left<right){
            if(output.charAt(left)!=output.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
