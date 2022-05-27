import java.util.LinkedList;
import java.util.List;

public class leetcode6016 {
    public static List<String> cellsInRange(String s) {
        List<String> result = new LinkedList<>();
        String[] splits = s.split(":");
        char begin = splits[0].charAt(0);
        char end = splits[1].charAt(0);
        int rowBegin = splits[0].charAt(1)-'0';
        int rowEnd = splits[1].charAt(1)-'0';
        for (int i = begin; i <= end; i++) {
            char c = (char)i;
            for (int j = rowBegin; j <= rowEnd; j++) {
                String concat = String.valueOf(c)+String.valueOf(j);
                result.add(concat);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(cellsInRange("A1:F1"));
    }
}
