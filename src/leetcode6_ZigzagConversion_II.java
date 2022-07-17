import java.util.Arrays;

public class leetcode6_ZigzagConversion_II {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[][] charArray = new char[numRows][1000];
        for(char[] arr: charArray){
            Arrays.fill(arr,'*');
        }
        int index = 0;
        int[][] direction = {
                {1,0},{-1,1}
        };
        int i = 0, j = 0, d = 1;
        while(index<s.length()){
            charArray[i][j] = s.charAt(index);
            if(i==numRows-1||i==0){
                d = (d+1)%2;
            }
            i = i+direction[d][0];
            j = j+direction[d][1];
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i_=0;i_<charArray.length;i_++){
            for(int j_ = 0;j_<charArray[i_].length;j_++){
                if(charArray[i_][j_]!='*'){
                    sb.append(charArray[i_][j_]);
                }
            }
        }
        return sb.toString();
    }
}
