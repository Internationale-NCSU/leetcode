import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class differenctBitCount {
    public int countDifferBit(int[] arr){
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);
            for (int j = 0; j < s.length(); j++) {
                String key = s.substring(0, j) + '*' + s.substring(j + 1);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }else {
                    count+=map.get(key);
                    map.put(key,map.get(key)+1);
                }
            }
        }
        return count;
    }
    @Test
    public void  test(){
        TreeMap map = new TreeMap();
        map.floorKey(3);
        System.out.println(countDifferBit(new int[]{456,356,256,366}));
    }
    class Product{
        String name;
        String count;
        public Product(String n,String c){
            this.name = n;
            this.count = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return name.equals(product.name) && count.equals(product.count);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, count);
        }
    }
}
