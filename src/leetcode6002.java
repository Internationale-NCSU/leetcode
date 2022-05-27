import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode6002 {
    static class Bitset {
        List<Integer> list = new ArrayList<>();
        int countOne = 0;
        public Bitset(int size) {
            for (int i = 0; i < size; i++) {
                list.add(0);
            }
        }
        public void fix(int idx) {
            if(list.get(idx)==0){
                countOne++;
            }
            list.set(idx,1);
        }

        public void unfix(int idx) {
            if(list.get(idx)==1){
                countOne--;
            }
            list.set(idx,0);
        }
        public void flip() {
            for (int i = 0; i <list.size() ; i++) {
                if(list.get(i)==0){
                    list.set(i,1);
                }else {
                    list.set(i,0);
                }
            }
            countOne = list.size()-countOne;
        }
        public boolean all() {
            if(countOne==list.size()){
                return true;
            }else {
                return false;
            }
        }

        public boolean one() {
            if(countOne>0){
                return true;
            }else {
                return false;
            }
        }

        public int count() {
            return countOne;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : list) {
                stringBuilder.append(integer);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Bitset bitset = new Bitset(5);

    }
}
