import org.junit.Test;

import java.util.Stack;

public class leetcode402_RemoveKDigits_MonotonicStackSolution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length() ; i++) {
            int digit = num.charAt(i)-'0';
            while(!stack.isEmpty()&&stack.peek()>digit&&k>0){
                stack.pop();
                k--;
            }
            if(stack.isEmpty()&&digit==0){
                continue;
            }
            stack.push(digit);
        }

        while(k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    @Test
    public void test(){
        System.out.println(removeKdigits("1432219",3));
    }
}
