import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode227 {
    public static int calculate(String s) {
        Deque<Character> operator = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'){
                operator.push(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))){
                int j = i;
                while(j<s.length()&&Character.isDigit(s.charAt(j))){
                    j++;
                }
                int n;
                if(j==i+1){
                    n = s.charAt(i)-'0';
                }else {
                    n = Integer.valueOf(s.substring(i, j));
                }
                nums.push(n);
                i=j-1;
                if(!operator.isEmpty()&&(operator.peek()=='*'||operator.peek()=='/')){
                    char opt = operator.pop();
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    int result;
                    if(opt=='*'){
                        result = num1*num2;
                        nums.push(result);
                    }else if(opt=='/'){
                        result = num2/num1;
                        nums.push(result);
                    }
                }
            }
        }
        while(!operator.isEmpty()){
            int num1 = nums.pollLast();
            int num2 = nums.pollLast();
            char opt = operator.pollLast();
            int result;
            if(opt=='+'){
                result = num1+num2;
                nums.addLast(result);
            }else if(opt=='-'){
                result = num1-num2;
                nums.addLast(result);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("13-2*2+3*4+15/3"));
    }
}
