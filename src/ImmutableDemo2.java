import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ImmutableDemo2 {
    @Data
    static class TestClass{
        public static int count = 0;
        String name;
        public TestClass(String name){
            this.name = name;
            count++;
        }
    }
    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        list.add("boy");
        list.add("girl");
        list.add("transgender");
        list.remove("boy");
        // list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
        Set<String> set = Set.of("Java","Python","C++","Javascript");
        TestClass t1 = new TestClass("c1");
        TestClass t2 = new TestClass("c2");
        TestClass t3 = new TestClass("c3");
        System.out.println(TestClass.count);
    }

}
