import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new LinkedList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = new LinkedList<>();
            dp.add(list);
        }
        int level;int index;
        for(level=0;level<triangle.size();level++){
            for(index=0;index<triangle.get(level).size();index++){
                int num = triangle.get(level).get(index);
                int upLeft,upRight;
                if(level==0){
                    dp.get(level).add(num);
                    continue;
                }
                if(index==0){
                    upRight = dp.get(level-1).get(index);
                    dp.get(level).add(num+upRight);
                    continue;
                }
                if(index==triangle.get(level).size()-1){
                    upLeft = dp.get(level-1).get(index-1);
                    dp.get(level).add(num+upLeft);
                    continue;
                }
                upRight = dp.get(level-1).get(index);
                upLeft = dp.get(level-1).get(index-1);
                dp.get(level).add(num+Math.min(upLeft,upRight));
            }
        }
        List<Integer> bottom = dp.get(dp.size()-1);
        Collections.sort(bottom);
        return bottom.get(0);
    }
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new LinkedList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new LinkedList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> list = new LinkedList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(minimumTotal(list));
    }
}
