import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class leetcode151 {
    public static String reverseWords(String s) {
        Deque<String> deque = new LinkedList<>();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            while(i<s.length()&&s.charAt(i)!=' '){
                tmp = tmp.concat(String.valueOf(s.charAt(i)));
                i++;
            }
            if(tmp.length()!=0) {
                deque.push(tmp);
                tmp = "";
            }
        }
        tmp = "";
        while(!deque.isEmpty()){
            tmp = tmp.concat(deque.pop());
            if(!deque.isEmpty()){
                tmp = tmp.concat(" ");
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
