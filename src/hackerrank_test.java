import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class hackerrank_test {
    int max = Integer.MIN_VALUE;
    public int findMax(List<Integer>[] lists,int module){
        dfs(0,0,module,lists);
        return max;
    }
    public void dfs(int indexOfLists,int sum,int module,List<Integer>[] lists){
        if(indexOfLists==lists.length){
            if(sum>max){
                max = sum;
            }
            return;
        }
        List<Integer> list = lists[indexOfLists];
        for (Integer integer : list) {
            int addition = (integer%module)*(integer%module)%module;
            dfs(indexOfLists+1,(sum+addition)%module,module,lists);
        }
    }
    @Test
    public void test(){
        List<Integer>[] lists = new List[6];
        lists[0] = new LinkedList<>(Arrays.asList(488512261,423332742));
        lists[1] = new LinkedList<>(Arrays.asList(625040505,443232774));
        lists[2] = new LinkedList<>(Arrays.asList(4553600));
        lists[3] = new LinkedList<>(Arrays.asList(91234264,617699202,124100179,337650738));
        lists[4] = new LinkedList<>(Arrays.asList(778493847,932097163));
        lists[5] = new LinkedList<>(Arrays.asList(489894997,496724555,693361712,935903331,518538304));
        System.out.println(findMax(lists,767));
    }
}
