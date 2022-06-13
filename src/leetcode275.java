import org.junit.Test;

public class leetcode275 {
    public int hIndex(int[] citations) {
        int idx = citations.length-1;
        while(idx>0){
            if(idx+1<citations[idx]){
                break;
            }else {
                idx = idx/2;
            }
        }
        return idx+2;
    }
    @Test
    public void test(){
        System.out.println(hIndex(new int[]{0}));
    }
}
