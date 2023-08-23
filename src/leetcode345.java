import org.junit.Test;

import java.util.*;

public class leetcode345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        Deque<Integer> indexes = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
                indexes.add(i);
            }
        }
        sb.reverse();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if(sb.length()!=0&&i==indexes.peek()){
                indexes.removeFirst();
                arr[i] = sb.charAt(0);
                sb.deleteCharAt(0);
            }
        }
        return new String(arr);
    }
    @Test
    public void test(){
        System.out.println(reverseVowels(" "));
    }
}
