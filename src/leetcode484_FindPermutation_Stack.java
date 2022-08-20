import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class leetcode484_FindPermutation_Stack {
    public int[] findPermutation(String s) {
        int[] result = new int[s.length()+1];
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 1; i <= s.length(); i++) {
            if(s.charAt(i-1)=='I'){
                stack.push(i);
                while(!stack.isEmpty()){
                    result[index] = stack.pop();
                    index++;
                }
            }else {
                stack.push(i);
            }
        }
        stack.push(s.length()+1);
        while(!stack.isEmpty()){
            result[index] = stack.pop();
            index++;
        }
        return result;
    }
    @Test
    public void test(){
        Arrays.stream(findPermutation("ID")).forEach(
                a-> System.out.println(a)
        );
    }
}
