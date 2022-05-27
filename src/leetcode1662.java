public class leetcode1662 {
    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word_1 = "", word_2 = "";
        for (String s : word1) {
            word_1 = word_1.concat(s);
        }
        for (String s : word2) {
            word_2 = word_2.concat(s);
        }
        if (word_1.equals(word_2)) return true;
        else return false;
    }
}
