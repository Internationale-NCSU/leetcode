import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class leetcode345_II {
    public String reverseVowels(String s) {
        String vowels ="aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if(arr[i]==vowels.charAt(j)){
                    sb.append(arr[i]);
                    arr[i] = '*';
                }
            }
        }
        sb.reverse();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='*'){
                arr[i] = sb.charAt(0);
                sb.deleteCharAt(0);
            }
        }
        return new String(arr);
    }
    @Test
    public void test(){
        System.out.println(reverseVowels("hello"));
    }
}
