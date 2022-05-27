import java.util.LinkedList;
import java.util.List;

public class meanGroup {
    public static double[] meanGroup(double[][] arr){
        double[] mean = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[i][j];
            }
            mean[i] = sum/arr[i].length;
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < mean.length; i++) {
            if(result.isEmpty()){
                List<Integer> list = new LinkedList<>();
                list.add(i);
                result.add(list);
            }else {
                boolean addFlag = false;
                for (int j = 0; j < result.size(); j++) {
                    if(mean[result.get(j).get(0)]==mean[i]){
                        result.get(j).add(i);
                        addFlag = true;
                        break;
                    }
                }
                if(!addFlag){
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    result.add(list);
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        int[][] meanGroup = new int[result.size()][];
        for (int i = 0; i < meanGroup.length; i++) {
            meanGroup[i] = new int[result.get(i).size()];

        }

        return mean;
    }

    public static void main(String[] args) {
        double[][] a = {{3,3,4,2},{4,4},{4,0,3,3},{2,3},{3,3,3}};
        double[][] b = {{-5,2,3},{0,0},{0},{-100,100}};
        double[] result = meanGroup(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(result[i]);
        }

    }
}
