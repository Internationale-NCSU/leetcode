
import java.util.LinkedList;
import java.util.List;

public class leetcode281 {
    public class ZigzagIterator {
        List<Integer> zigzagList;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            zigzagList = new LinkedList<>();
            boolean v1Term = true;
            while (!v1.isEmpty()&&!v2.isEmpty()){
                if(v1Term){
                    zigzagList.add(v1.get(0));
                    v1.remove(0);
                    v1Term = false;
                }else {
                    zigzagList.add(v2.get(0));
                    v2.remove(0);
                    v1Term = true;
                }
            }
            while(!v1.isEmpty()){
                zigzagList.add(v1.get(0));
                v1.remove(0);
            }
            while(!v2.isEmpty()){
                zigzagList.add(v2.get(0));
                v2.remove(0);
            }
        }

        public int next() {
            return zigzagList.remove(0);
        }

        public boolean hasNext() {
            return !zigzagList.isEmpty();
        }
    }
}
