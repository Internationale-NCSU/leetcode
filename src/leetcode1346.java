import java.util.HashSet;

public class leetcode1346 {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8, 0};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        HashSet hashSet = new HashSet();
        for (int i : arr) {
            if (hashSet.contains(0) && i == 0) return true;
            hashSet.add(i);
        }
        for (int i : arr) {
            if (i != 0 && hashSet.contains(2 * i)) return true;
        }
        return false;
    }
}
