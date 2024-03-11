import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamLearning {
    @Data
    @ToString
    class Student implements Serializable {
        /**
         * 姓名
         */
        private String name;
        /**
         * 班级
         */
        private String schoolClass;

        /**
         * 语文成绩
         */
        private Integer chineseScore;
        /**
         * 数学成绩
         */
        private Integer MathScore;
    }
    public List<Student> initData(){
        List<Student> students= new ArrayList<>();
        Student s1=new Student();
        s1.setName("王五");
        s1.setSchoolClass("一年级");
        s1.setChineseScore(100);
        s1.setMathScore(100);
        students.add(s1);

        Student s2=new Student();
        s2.setName("李四");
        s2.setSchoolClass("一年级");
        s2.setChineseScore(100);
        s2.setMathScore(100);
        students.add(s2);

        Student s3=new Student();
        s3.setName("李思");
        s3.setSchoolClass("二年级");
        s3.setChineseScore(100);
        s3.setMathScore(100);
        students.add(s3);

        Student s4=new Student();
        s4.setName("王五");
        s4.setSchoolClass("三年级");
        s4.setChineseScore(100);
        s4.setMathScore(100);
        students.add(s4);

        Student s5=new Student();
        s5.setName("赵三");
        s5.setSchoolClass("一年级");
        s5.setChineseScore(100);
        s5.setMathScore(100);
        students.add(s5);
        return students;
    }
    @Test
    public void test(){
        List<Student> list = initData();
        // System.out.println(list);
        Stream<Student> stream1 = list.stream();
        // Consumer匿名内部类可直接用Lambda表达是简化
        /**
         * stream1.forEach(new Consumer<Student>() {
         *             @Override
         *             public void accept(Student student) {
         *                 System.out.println(student);
         *             }
         *         });
         **/

        list.stream().forEach(a->{
            System.out.println(a);
        });

        System.out.println("-------------------------------");
        list.stream().filter(a->{
            return a.chineseScore>=90?true:false;
        }).limit(3).forEach(a->{
            System.out.println(a);
        });
        System.out.println("-------------------------------");
        list.stream().map(a->String.valueOf("The score is: "+a.chineseScore)
        ).forEach(a->{
            System.out.println(a);
        });
        System.out.println("-------------------------------");
        // 方法引用， 代替Lambda表达式
        list.stream().forEach(System.out::println);
        System.out.println("----------------toArray()-------------");

        Object[] objects = list.stream().toArray();//收集到Object类型数组

        // IntFunction 泛型：'? extends Object[]' 具体类型的数组
        // apply的参数： 流中数据的个数，要跟数组长度保持一致。
        // 方法体，创建数组
        Student[] stu = list.stream().toArray(new IntFunction<Student[]>() {
            @Override
            public Student[] apply(int value) {
                return new Student[value];
            }
        });
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i]);
        }

        Student[] stuLambda = list.stream().toArray(value -> {return new Student[value];});
        System.out.println("----------------collect()-------------");
        //收集到List中
        List<Student> studentList = list.stream().filter(a -> {
            return a.name.startsWith("李");
        }).collect(Collectors.toList());
        System.out.println(studentList);
        //收集到Set中
        Set<Student> studentSet = list.stream().filter(a -> {
            return a.name.startsWith("李");
        }).collect(Collectors.toSet());
        System.out.println(studentSet);
        //收集到Map中
        list.stream().filter(a -> {
            return a.name.startsWith("李");
        });
    }
}
