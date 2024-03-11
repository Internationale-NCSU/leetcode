import java.util.Stack;
public class leetcode71 {
    public static String simplifyPath(String path) {
        StringBuilder result = new StringBuilder("");
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < directories.length; i++) {
            if(directories[i].equals("..")&&!stack.isEmpty()){
                stack.pop();
            }else if(directories[i].equals(".")||(directories[i].equals("..")&&stack.isEmpty())||directories[i].equals("")){
                continue;
            }else {
                stack.push(directories[i]);
            }
        }
        int size = stack.size();
        if(size==0){
            return "/";
        }
        for (int i = 0; i < size; i++) {
            result = result.insert(0,"/"+stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/"));
    }
}
