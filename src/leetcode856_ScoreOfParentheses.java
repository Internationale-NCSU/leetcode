import org.junit.Test;

import java.util.Stack;

public class leetcode856_ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(score);
                score=0;
            }else{
                score = stack.pop() + Math.max(1,score*2);
            }
        }
        return score;
    }
    @Test
    public void test(){
        System.out.println(scoreOfParentheses("(()()())()"));
    }

}
