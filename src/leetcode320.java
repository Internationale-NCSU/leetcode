import org.junit.Test;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

public class leetcode320 {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new LinkedList<>();
        dfs(result,0,word,"");;
        return result;
    }
    public void dfs(List<String> result, int index, String word,String path){
        result.add(path);
        for (int i = index; i < word.length(); i++) {
            path = path.concat(""+word.charAt(i));
            dfs(result,i+1,word,path);
            path = path.substring(0,path.length()-1);
        }
    }
    @Test
    public void test(){
        generateAbbreviations("word").forEach(a->{
            System.out.println(a);
        });
    }
}
