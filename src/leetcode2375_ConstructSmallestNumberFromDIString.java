import org.junit.Test;

import java.util.Set;

public class leetcode2375_ConstructSmallestNumberFromDIString {
    String result = "999999999";
    boolean[] visited = new boolean[11];
    public String smallestNumber(String pattern) {
        backtracking(pattern,0,new StringBuilder());
        return result;
    }
    public void backtracking(String pattern, int index,StringBuilder stringBuilder){
        if(stringBuilder.length()==pattern.length()+1){
            if(Integer.valueOf(result)>Integer.valueOf(stringBuilder.toString())){
                result = stringBuilder.toString();
            }
        }
        for (char i = '1'; i <= '9'; i++) {
            if(stringBuilder.length()==0){
                stringBuilder.append(i);
                visited[i - '0'] = true;
                backtracking(pattern,index+1,stringBuilder);
                visited[i - '0'] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }else if(index!=0&&index<=pattern.length()) {
                if(pattern.charAt(index-1)=='I') {
                    if (i > stringBuilder.charAt(index - 1) && !visited[i - '0']) {
                        stringBuilder.append(i);
                        visited[i - '0'] = true;
                        backtracking(pattern, index + 1, stringBuilder);
                        visited[i - '0'] = false;
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }else if(index!=0&&pattern.charAt(index-1)=='D'){
                    if (i < stringBuilder.charAt(index-1) && !visited[i - '0']) {
                        stringBuilder.append(i);
                        visited[i - '0'] = true;
                        backtracking(pattern, index + 1, stringBuilder);
                        visited[i - '0'] = false;
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }
            }
        }
    }
    @Test
    public void test(){
        System.out.println(smallestNumber("D"));
    }
}
