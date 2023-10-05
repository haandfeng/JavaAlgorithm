import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConsumerAndThenTest {
    public static class Person{
        public  Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        String name;
        int age;
        int height;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        List<Integer> listNew = new ArrayList<>();
        // 使用并行流来向集合中添加数据
        list.parallelStream()
                //.forEach(s->listNew.add(s));
                .forEach(listNew::add);
        System.out.println(listNew.size());
    }
    @Test
    public void test04(){
        Optional<String> op1 = Optional.of("zhangsan");
        Optional<String> op2 = Optional.empty();
        // 如果存在值 就做什么
        op1.ifPresent(s-> System.out.println("有值:" +s));
        op1.ifPresent(System.out::println);
    }

    /**
     * 自定义一个方法，将Person对象中的 name 转换为大写 并返回
     */
    @Test
    public void test05(){
        Person p = new Person("zhangsan",18);
        Optional<Person> op = Optional.of(p);
        String name = getNameForOptional(op);
        System.out.println("name="+name);

    }

    /**
     * 根据Person对象 将name转换为大写并返回
     *    通过Optional方式实现
     * @param op
     * @return
     */
    public String getNameForOptional(Optional<Person> op){
        if(op.isPresent()){
            String msg = //op.map(p -> p.getName())
                    op.map(Person::getName)
                            //.map(p -> p.toUpperCase())
                            .map(String::toUpperCase)
                            .orElse("空值");
            return msg;
        }
        return null;
    }

    /**
     * 根据Person对象 将name转换为大写并返回
     * @param person
     * @return
     */
    public String getName(Person person){
        if(person != null){
            String name = person.getName();
            if(name != null){
                return name.toUpperCase();
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    }

