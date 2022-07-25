package iteratorPattern;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}

//implements Iterator<String>
//implements Iterator<User>