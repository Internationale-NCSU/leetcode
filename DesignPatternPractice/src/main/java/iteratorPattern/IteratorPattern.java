package iteratorPattern;

public class IteratorPattern {
    public static void main(String[] args) {
        var history = new BrowseHistory();
        Iterator iterator = history.createIterator();
        history.push("a");
        history.push("b");
        history.push("c");
        while(iterator.hasNext()){
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
        // if the 'urls' changed from list to String[]
        // any modification in BrowseHistory class won't
        // influence the main class.
    }
}
