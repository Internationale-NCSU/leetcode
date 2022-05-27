import org.junit.Test;

public class leetcode245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int pos1 = -1, pos2 = -1, same = -1, dis = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if(word1.equals(word2)){
                if(wordsDict[i].equals(word1)){
                    if(same!=-1) {
                        dis = Math.min(dis, i - same);
                    }
                    same = i;
                }
            }else {
                if(word1.equals(wordsDict[i])){
                    pos1 = i;
                }else if(word2.equals(wordsDict[i])){
                    pos2 = i;
                }
                if(pos1!=-1&&pos2!=-1){
                    dis = Math.min(dis,Math.abs(pos1-pos2));
                }
            }
        }
        return dis;
    }
    @Test
    public void test(){
        System.out.println(shortestWordDistance(new String[]{"aaa","b","c","d","b"},"b","b"));
    }
}
