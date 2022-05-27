import java.util.Scanner;

public class test {
    public static int[][] generateSparsearray(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int val = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    val++;
                }
            }
        }
        int[][] Sparsearray = new int[val + 1][3];
        Sparsearray[0][0] = row;
        Sparsearray[0][1] = col;
        Sparsearray[0][2] = val;

        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    Sparsearray[count][0] = i;
                    Sparsearray[count][1] = j;
                    Sparsearray[count][2] = array[i][j];
                    count++;
                }
            }
        }
        return Sparsearray;
    }

    public static void main(String[] args) {

        int[][] array = new int[5][5];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a location:");
            int x = scanner.nextInt();
            if (x < 0) break;
            int y = scanner.nextInt();

            System.out.println("Input a num:");
            int num = scanner.nextInt();
            array[x][y] = num;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] Sparsearray = generateSparsearray(array);
        for (int i = 0; i < Sparsearray.length; i++) {
            for (int j = 0; j < Sparsearray[i].length; j++) {
                System.out.print(Sparsearray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
