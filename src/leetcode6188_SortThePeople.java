import java.util.PriorityQueue;

public class leetcode6188_SortThePeople {
    class Pair<K,V>{

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        K k;
        V v;
        public void setK(K k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>((a,b)->{
            return b.getV()-a.getV();
        });
        for (int i = 0; i < names.length; i++) {
            Pair<String,Integer> p = new Pair(names[i],heights[i]);
            pq.offer(p);
        }
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll().getK();
        }
        return res;
    }
}
