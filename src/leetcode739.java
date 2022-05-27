import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curTemp = temperatures[i];
            while(!deque.isEmpty()&&temperatures[deque.peek()]<curTemp){
                int preDay = deque.pop();
                result[preDay] = i-preDay;
            }
            deque.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        Arrays.stream(result).forEach(
                (a)->{
                    System.out.print(a+",");
                }
        );
    }
}
