import org.junit.Test;

public class AkunaOA_2 {
    public int difference(int[] arr) {
        int indicator1 = 0;
        for (int i = 0; i < arr.length; ) {
            int count = 1;
            int num = arr[i];
            int point = i + 1;
            while (point < arr.length) {
                if (arr[point] == num) {
                    point++;
                    count++;
                } else {
                    break;
                }
            }
            i = point;
            if (count == num) {
                indicator1++;
            }
        }

        int indicator2 = 0;
        for (int i = 1; i <= Math.min(15, arr.length); i++) {
            if (check(arr, i)) {
                indicator2++;
            }
        }
        return indicator1-indicator2;
    }

    private boolean check(int[] arr, int i) {
        int start = i - 1;
        int end = Math.min(i + i - 1, arr.length);
        for (int j = start; j < end; j++) {
            if (arr[j] != i) {
                return false;
            }
        }
        if (end < arr.length && arr[end] == i) {
            return false;
        }
        return true;
    }



    @Test
    public void test(){
        System.out.println(difference(new int[]{3, 3, 2, 2, 5, 5, 5, 5, 5, 3, 3, 3, 2, 2}));

    }
}
