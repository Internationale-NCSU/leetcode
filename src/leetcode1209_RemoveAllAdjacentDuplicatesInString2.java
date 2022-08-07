import org.junit.Test;

import java.util.Stack;

public class leetcode1209_RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        if(s.length()<k){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        sb.append(s.charAt(0));
        countStack.push(1);
        charStack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(!charStack.isEmpty()&&s.charAt(i)==charStack.peek()){
                countStack.push(countStack.pop()+1);
            }else {
                countStack.push(1);
                charStack.push(s.charAt(i));
            }
            if(!countStack.isEmpty()){
                if(countStack.peek()==k){
                    sb.delete(sb.length()-k,sb.length());
                    countStack.pop();
                    charStack.pop();
                }
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
}
