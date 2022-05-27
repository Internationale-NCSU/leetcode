import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode93 {
    public static boolean isValid(String s){
        if(s.length()<=3&&s.charAt(0)!='0'&&Integer.valueOf(s)<=255){
            return true;
        }else {
            return false;
        }
    }
    public static void dfs(List<String> result, Deque<String> segments, String s, int i, int j, int dots) {
        if (segments.size() == 4&&j==s.length()+1) {
            String net = segments.stream().collect(Collectors.joining("."));
            result.add(net);
            return;
        }
        if (dots < 0) {
            return;
        }
        for (int k = i+1; k < s.length(); k++) {
            String segment = s.substring(i+1,k);
            if (isValid(segment)) {
                segments.addLast(segment);
                if(dots>=0) {
                    dfs(result, segments, s, j, j + 1, dots - 1);
                }
                segments.removeLast();
            }
        }

    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        Deque<String> segments = new LinkedList<>();
        dfs(result,segments,s,0,1,3);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("2255255255"));
    }
}
