import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class leetcode223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int length1 = Math.abs(ax1-ax2);
        int length2 = Math.abs(bx1-bx2);
        int width1 = Math.abs(ay1-ay2);
        int width2 = Math.abs(by1-by2);
        int widDiff = 0;
        int lenDiff = 0;
        if(bx1>=ax1&&bx1<=ax2){
            lenDiff = ax2-bx1;
            if(by2>=ay1&&by2<=ay2){
                widDiff = by2-ay1;
            }else if(by1>=ay1&&by1<=ay2){
                widDiff = ay2-by1;
            }
        }else if(bx2>=ax1&&bx2<=ax2){
            lenDiff = bx2-ax1;
            if(by1>=ay1&&by1<=ay2){
                widDiff = ay2-by1;
            }else if(by2>=ay1&&by2<=ay2){
                widDiff = by2-ay1;
            }
        }
        return length1*width1+length2*width2-widDiff*lenDiff;
    }
    @Test
    public void test(){
        System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2));
    }
}
