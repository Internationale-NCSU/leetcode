import java.util.LinkedList;
import java.util.Stack;

public class leetcode20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                switch (c){
                    case ')':{
                        Character left = stack.pop();
                        if(left!='('){
                            return false;
                        }
                        break;
                    }
                    case ']':{
                        Character left = stack.pop();
                        if(left!='['){
                            return false;
                        }
                        break;
                    }
                    case '}':{
                        Character left = stack.pop();
                        if(left!='{'){
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid(")]"));
    }
}
