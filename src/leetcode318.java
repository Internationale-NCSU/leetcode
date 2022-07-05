import org.junit.Test;

public class leetcode318 {
    public int maxProduct(String[] words) {
        boolean[][] charAppear = new boolean[words.length][26];
        for (int i = 0; i < words.length ; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                charAppear[i][words[i].charAt(j)-'a'] = true;
            }
        }
        int product = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                boolean containingSame = false;
                for (int k = 0; k < 26; k++) {
                    if(charAppear[i][k]==true&&charAppear[j][k]==true){
                        containingSame = true;
                        break;
                    }
                }
                if(!containingSame){
                    product = Math.max(product,words[i].length()*words[j].length());
                }
            }
        }
        return product;
    }
    @Test
    public void test(){
        String[] strings= new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(strings));
    }
}
