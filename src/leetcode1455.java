public class leetcode1455 {
    public static void main(String[] args) {
        String sentence = "i use triple pillow";
        String searchWord = "pill";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] resultSet = sentence.split(" ");
        for (int i = 0; i < resultSet.length; i++) {
            if (resultSet[i].indexOf(searchWord) == 0) return i + 1;
        }
        return -1;
    }
}
