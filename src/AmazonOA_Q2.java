import java.util.List;

public class AmazonOA_Q2 {
    public int getMaximumGreyness(List<String> pixels){
        char[][] arrays = new char[pixels.size()][];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = pixels.get(i).toCharArray();
        }
        int[] oneInCol = new int[arrays.length];
        int[] oneInRow = new int[arrays[0].length];
        return 0;
    }
}
