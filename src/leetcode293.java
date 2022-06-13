import org.junit.Test;

import java.util.*;

public class leetcode293 {

    public List<String> generatePossibleNextMoves(String currentState) {
        var result = new ArrayList<String>();

        if (currentState == null || currentState.length() < 2) {
            return result;
        }

        var prev = currentState.charAt(0);
        for (var i = 1; i < currentState.length(); i++) {
            if (prev == '+' && prev == currentState.charAt(i)) {
                if (i == 1) {
                    result.add(
                            "--"
                                    + currentState.substring(i + 1)
                    );
                } else {
                    result.add(
                            currentState.substring(0, i - 1)
                                    + "--"
                                    + currentState.substring(i + 1)
                    );
                }
            }
            prev = currentState.charAt(i);
        }

        return result;
    }
    @Test
    public void test(){
        System.out.println(generatePossibleNextMoves("+++++++"));
    }
}
