import org.junit.Test;

import java.util.*;

//*** 自建类要实现HashCode方法才能正常使用Set的功能！
//*** 对象比较用equals！对象比较用equals！对象比较用equals！

public class leetcode2353_DesignAFoodRatingSystem_TreeMap {
    class Pairs<K,V>{
        K key;
        V value;

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            Pairs<?, ?> pairs = (Pairs<?, ?>) o;
            return Objects.equals(key, pairs.key) && Objects.equals(value, pairs.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        public Pairs(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    class FoodRatings {

        Map<String,Pairs<String,Integer>> foodMap = new HashMap<>();
        Map<String,String> foodToCuisines = new HashMap<>();
        Map<String, TreeSet<Pairs<String,Integer>>> cuisinesToFoods = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                Pairs<String,Integer> foodNRating = new Pairs<>(foods[i],ratings[i]);
                foodMap.put(foods[i],foodNRating);
                foodToCuisines.put(foods[i],cuisines[i]);
                if(cuisinesToFoods.containsKey(cuisines[i])){
                    TreeSet<Pairs<String,Integer>> set = cuisinesToFoods.get(cuisines[i]);
                    set.add(foodNRating);
                }else{
                    TreeSet<Pairs<String,Integer>> set = new TreeSet<>(
                        (a,b)->{
                            if(!a.getValue().equals(b.getValue())) {
                                return b.getValue() - a.getValue();
                            }else {
                                return a.getKey().compareTo(b.getKey());
                            }
                        }
                    );
                    set.add(foodNRating);
                    cuisinesToFoods.put(cuisines[i],set);
                }
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisines.get(food);
            TreeSet<Pairs<String,Integer>> set = cuisinesToFoods.get(cuisine);
            set.remove(foodMap.get(food));
            Pairs<String,Integer> foodNRating = new Pairs<>(food,newRating);
            foodMap.put(food,foodNRating);
            set.add(foodNRating);
        }

        public String highestRated(String cuisine) {
            TreeSet<Pairs<String,Integer>> set = cuisinesToFoods.get(cuisine);
            return set.first().getKey();
        }
    }

    @Test
    public void test2(){
        TreeSet<Pairs<String,Integer>> set = new TreeSet<>(
                (a,b)->{
                    if(a.getValue().equals(b.getValue())) {
                        return b.getValue() - a.getValue();
                    }else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }
        );
        set.add(new Pairs<>("abc",15));
        set.add(new Pairs<>("def",15));
        set.add(new Pairs<>("abc",15));
    }
    @Test
    public void test(){
        String[] cuisines = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] foods = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(cuisines,foods,ratings);
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi",17);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen",17);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
