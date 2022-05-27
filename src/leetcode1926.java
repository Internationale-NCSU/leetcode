import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode1926 {
    final int DIRECTION[][] = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    public int nearestExit(char[][] maze, int[] entrance) {
        Stack<Integer> stack = new Stack<>();

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]]='+';
        Pair<Integer,Integer> entry = new Pair<>(entrance[0],entrance[1]);
        queue.add(entry);
        int stepCount = 0;
        while (queue.size()>0){
            int s = queue.size();
            while (s-->0) {
                Pair<Integer, Integer> pair = queue.remove();
                int row = pair.getKey();
                int col = pair.getValue();
                if ((row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) && stepCount != 0) {
                    return stepCount;
                }
                for (int[] ints : DIRECTION) {
                    int rowNext = row + ints[0];
                    int colNext = col + ints[1];
                    if (rowNext >= 0 && rowNext < maze.length && colNext >= 0 && colNext < maze[0].length && maze[rowNext][colNext] == '.') {
                        maze[rowNext][colNext] = '+';
                        queue.add(new Pair<>(rowNext, colNext));
                    }
                }
            }
            stepCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'+','.','+','+','+','+','+'},
                {'+','.','+','+','+','+','+'},
                {'+','+','.','.','+'},
        };
    }
}
