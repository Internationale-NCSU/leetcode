import java.util.regex.Pattern;

public class ArrayQueue {

}

class queue {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    public queue(int Maxsize) {
        maxsize = Maxsize;
        arr = new int[Maxsize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxsize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void Queue(int n) {

    }
}