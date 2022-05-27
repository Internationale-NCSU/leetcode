import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode155 {
     static class MinStack {

        Deque<Integer> list;

        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int val) {
            list.addLast(val);
        }

        public void pop() {
            list.removeLast();
        }

        public int top() {
          return  list.getLast();
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                min = Math.min(integer,min);
            }
            return min;
        }
    }

}
