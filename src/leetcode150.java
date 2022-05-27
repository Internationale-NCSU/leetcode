import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode150 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new LinkedList<>();
        Integer result = null;
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int number1 = numbers.pop();
                int number2 = numbers.pop();
                switch (tokens[i].charAt(0)){
                    case '+':{
                        result = number1 + number2;
                        break;
                    }
                    case '-':{
                        result = number1 - number2;
                        break;
                    }
                    case '*':{
                        result = number1 * number2;
                        break;
                    }
                    case '/':{
                        result = number2 / number1;
                        break;
                    }
                }
                numbers.addFirst(result);
            }else {
                numbers.addFirst(Integer.valueOf(tokens[i]));
            }
        }
        if(result==null){
            result = numbers.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"4","3","-"};
        System.out.println(evalRPN(tokens));
    }
}
