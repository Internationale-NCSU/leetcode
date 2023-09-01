import org.junit.Test;

public class leetcode2833_FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int countR = 0, countL = 0, count_ =0;
        for (int i = 0; i < moves.length() ; i++) {
            if(moves.charAt(i)=='R'){
                countR++;
            }else if(moves.charAt(i)=='L'){
                countL++;
            }else {
                count_++;
            }
        }
        return Math.max(count_+countL-countR,count_+countR-countL);
    }
    @Test
    public void test(){
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
    }
}
