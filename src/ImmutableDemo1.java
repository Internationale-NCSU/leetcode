import java.util.Iterator;
import java.util.List;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        List<String> list = List.of("Java","Python","C++","Javascript");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("------------");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        /**  Cannot modify on immutable collections.
          Exception in thread "main" java.lang.UnsupportedOperationException
        	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.remove(ImmutableCollections.java:150)
        	at ImmutableDemo1.main(ImmutableDemo1.java:16)
         */
        // list.remove("Java");
    }
}
