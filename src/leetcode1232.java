import java.util.Arrays;

public class leetcode1232 {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 1}, {2, 2}, {2, 0}};

        System.out.println(checkStraightLine(coordinates));
    }

    static public boolean checkStraightLine(int[][] coordinates) {
        int x_increment = coordinates[1][0] - coordinates[0][0];
        int y_increment = coordinates[1][1] - coordinates[0][1];
        if (x_increment == 0) {
            int x = coordinates[0][0];
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][0] != x) return false;
            }
            return true;
        } else if (y_increment == 0) {
            int y = coordinates[0][1];
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][1] != y) return false;
            }
            return true;
        }
        int k;
        if (x_increment > y_increment) {

            k = x_increment / y_increment;
            for (int i = 2; i < coordinates.length; i++) {
                if ((coordinates[i][1] - coordinates[i - 1][1]) == 0) return false;
                //System.out.println("differentiate:"+(coordinates[i][0] - coordinates[i-1][0])/(coordinates[i][1] - coordinates[i-1][1]));
                //System.out.println("k:"+k);
                //System.out.println("-------------------");
                if ((coordinates[i][0] - coordinates[i - 1][0]) / (coordinates[i][1] - coordinates[i - 1][1]) != k) {
                    return false;
                }
            }
        } else {
            k = y_increment / x_increment;
            for (int i = 2; i < coordinates.length; i++) {
                if ((coordinates[i][0] - coordinates[i - 1][0]) == 0) return false;
                //System.out.println("differentiate:"+(coordinates[i][0] - coordinates[i-1][0])/(coordinates[i][1] - coordinates[i-1][1]));
                //System.out.println("k:"+k);
                //System.out.println("-------------------");
                if ((coordinates[i][1] - coordinates[i - 1][1]) / (coordinates[i][0] - coordinates[i - 1][0]) != k) {
                    return false;
                }
            }
        }
        /*
        for(int i =0;i<coordinates.length-1;i++){
            for(int j =i+1;j<coordinates.length;j++){
                if(coordinates[i][0]<coordinates[j][0]){
                    int tmp = coordinates[i][0];
                    coordinates[i][0]=coordinates[j][0];
                    coordinates[j][0]=tmp;
                }
            }
        }*/


        return true;


    }
}
