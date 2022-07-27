import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode2353_DesignAFoodRatingSystem {
    class FoodRatings {
        class Pairs<T,U>{
            T key;
            U value;

            public Pairs(T key, U valuer) {
                this.key = key;
                this.value = valuer;
            }

            public T getKey() {
                return key;
            }

            public void setKey(T key) {
                this.key = key;
            }

            public U getValue() {
                return value;
            }

            public void setValue(U value) {
                this.value = value;
            }
        }
        Map<String,PriorityQueue<Pairs<String,Integer>>> map = new HashMap<>();
        Map<String,String> foodsToCuisines = new HashMap<>();
        Map<String,Pairs<String,Integer>> foodsMap = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodsToCuisines.put(foods[i],cuisines[i]);
                Pairs<String,Integer> pair = new Pairs<>(foods[i],ratings[i]);
                foodsMap.put(foods[i],pair);
                if(!this.map.containsKey(cuisines[i])){
                    PriorityQueue<Pairs<String,Integer>> pq =  getPq();
                    pq.offer(pair);
                    map.put(cuisines[i],pq);
                }else {
                    PriorityQueue<Pairs<String,Integer>> pq = map.get(cuisines[i]);
                    pq.offer(pair);
                }
            }

        }

        public PriorityQueue<Pairs<String,Integer>> getPq(){
            return new PriorityQueue<Pairs<String,Integer>>(
                (a,b)->{
                    int ratingA = a.getValue();
                    int ratingB = b.getValue();
                    if(ratingA!=ratingB){
                        return ratingB-ratingA;
                    }else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }
            );
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodsToCuisines.get(food);
            PriorityQueue<Pairs<String,Integer>> pq = map.get(cuisine);
            pq.remove(foodsMap.get(food));
            Pairs<String,Integer> pair = new Pairs<>(food,newRating);
            pq.offer(pair);
            foodsMap.put(food,pair);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Pairs<String,Integer>> pq = map.get(cuisine);
            return pq.peek().getKey();
        }
    }
    @Test
    public void test(){
        String[] cuisines = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] foods = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(cuisines,foods,ratings);
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi",16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen",16);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
