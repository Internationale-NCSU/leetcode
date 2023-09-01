import java.util.Stack;

public class leetcode2710_RemoveTrailingZerosFromAString {
    public String removeTrailingZeros(String num) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.add(num.charAt(i));
        }
        while(stack.peek()=='0'){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
