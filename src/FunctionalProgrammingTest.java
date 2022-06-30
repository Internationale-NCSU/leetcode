
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgrammingTest {
    @Test
    public void test1(){
        List<Integer> list = new LinkedList();
        list.add(-1);
        list.add(3);
        list.add(-51);
        list.add(4);
        list = list.stream().filter( a -> a > 0
        ).collect(Collectors.toList());
        System.out.println(list);
    }
    @Data
    class Person{
        String name;
        int salary;
        int age;
        String gender;
        String location;

        public Person(String name, int salary, int age, String gender, String location) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.gender = gender;
            this.location = location;
        }
    }
    //https://blog.csdn.net/qq_41135605/article/details/109494073
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }

}
