import java.util.HashMap;

public class leetcode0102INTERVIEW {
    public static void main(String[] args) {
        String s1 = "aaebcd", s2 = "badeac";
        System.out.println(CheckPermutation(s1, s2));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        HashMap<Character, Integer> map_s1 = new HashMap<>();
        HashMap<Character, Integer> map_s2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map_s1.containsKey(s1.charAt(i))) {
                map_s1.replace(s1.charAt(i), map_s1.get(s1.charAt(i)) + 1);
            } else {
                map_s1.put(s1.charAt(i), 1);
            }

            if (map_s2.containsKey(s2.charAt(i))) {
                map_s2.replace(s2.charAt(i), map_s2.get(s2.charAt(i)) + 1);
            } else {
                map_s2.put(s2.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!map_s1.containsKey(s2.charAt(i))) return false;
            int value_s1 = map_s1.get(s2.charAt(i));
            int value_s2 = map_s2.get(s2.charAt(i));
            if (value_s1 != value_s2) return false;
        }
        return true;
    }
}
