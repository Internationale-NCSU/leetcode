import org.junit.Test;

import java.util.*;

public class leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        int[][] pascalTri = new int[rowIndex+1][];
        for (int i = 0; i <= rowIndex; i++) {
            pascalTri[i] = new int[rowIndex+1];
            if(i==0){
                pascalTri[i][0] = 1;
            }else {
                for (int j = 0; j < pascalTri[i].length; j++) {
                    if(j==0||j==pascalTri[i].length-1){
                        pascalTri[i][j] = 1;
                    }else {
                        pascalTri[i][j] = pascalTri[i-1][j-1]+pascalTri[i-1][j];
                    }
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        Arrays.stream(pascalTri[rowIndex]).forEach(a->list.add(a));
        return list;
    }
    @Test
    public void test(){
        System.out.println(getRow(3));
    }
}
