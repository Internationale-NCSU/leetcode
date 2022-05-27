import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetcode66 {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = digits.length-1; i >= 0 ; i--) {
            int num = digits[i]+carry;
            if(carry==0){
                stack.push(num);
                continue;
            }
            carry = num/10;
            num = num %10;
            stack.push(num);
        }
        if(carry==1){
            stack.push(1);
        }
        int[] arr = new int[stack.size()];
        int count = 0;
        while(!stack.isEmpty()) {
            Integer integer = stack.pop();
            arr[count] = integer;
            count++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        int[] result = plusOne(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+", ");
        }
        System.out.println();
    }
}
