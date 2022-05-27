import java.util.Iterator;
import java.util.LinkedList;

public class leetcodeInterview0306 {
    class AnimalShelf {
        int no = 0;
        LinkedList<int[]> shelter = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            shelter.add(no, animal);
            no = no + 1;
        }

        public int[] dequeueAny() {
            int[] animal = new int[2];
            animal = shelter.removeFirst();
            return animal;
        }

        public int[] dequeueDog() {
            int[] animal = new int[2];
            int[] NUll = {-1, -1};
            Iterator iterator = shelter.iterator();
            while (iterator.hasNext()) {
                Object o = iterator;
                animal = (int[]) o;
                if (animal[1] == 1) {
                    iterator.remove();
                    return animal;
                }
            }

            return NUll;

        }

        public int[] dequeueCat() {
            int[] animal;
            int[] NUll = {-1, -1};
            Iterator iterator = shelter.iterator();
            while (iterator.hasNext()) {
                Object o = iterator;
                animal = (int[]) o;
                if (animal[1] == 0) {
                    iterator.remove();
                    return animal;
                }
            }
            return NUll;
        }
    }

}
