public class leetcode58 {
    public static int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");
        return splits[splits.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
