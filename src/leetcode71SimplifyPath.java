import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class leetcode71SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] splits = path.split("/");
        for (int i = 0; i < splits.length; i++) {
            if(splits[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(splits[i].equals(".")){
                continue;
            }else if(!splits[i].equals(" ")&&!splits[i].equals("")) {
                stack.push(splits[i]);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while(!stack.isEmpty()){
            String s = stack.getLast();
            stack.removeLast();
            sb.append(s);
            if(!stack.isEmpty()){
                sb.append("/");
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(simplifyPath("/home/foo"));
    }
}
