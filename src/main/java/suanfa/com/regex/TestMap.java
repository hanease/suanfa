package suanfa.com.regex;

import java.util.*;
import java.util.stream.Collectors;

public class TestMap {

    public static void main(String[] args) {
        List<Person> persionList = new ArrayList<Person>();
        persionList.add(new Person(1,"张三","男",38));
        persionList.add(new Person(2,"小小","女",2));
        persionList.add(new Person(3,"李四","男",65));
        persionList.add(new Person(4,"王五","女",20));
        persionList.add(new Person(5,"赵六","男",38));
        persionList.add(new Person(6,"大大","男",65));

        //1、只取出该集合中所有姓名组成一个新集合
        List<String> nameList=persionList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(nameList.toString());

        //2、只取出该集合中所有id组成一个新集合
        List<Integer> idList=persionList.stream().mapToInt(Person::getId).boxed().collect(Collectors.toList());
        System.out.println(idList.toString());

        //3、list转map，key值为id，value为Person对象
        Map<Integer, Person> personmap = persionList.stream().collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(personmap.toString());

        //4、list转map，key值为id，value为name
        Map<Integer, String> namemap = persionList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(namemap.toString());

        //5、进行map集合存放，key为age值 value为Person对象 它会把相同age的对象放到一个集合中
        Map<Integer, List<Person>> ageMap = persionList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(ageMap.toString());

        //6、获取最小年龄
        Integer ageMin = persionList.stream().mapToInt(Person::getAge).min().getAsInt();
        System.out.println("最小年龄为: "+ageMin);

        //7、获取最大年龄
        Integer ageMax = persionList.stream().mapToInt(Person::getAge).max().getAsInt();
        System.out.println("最大年龄为: "+ageMax);

        //8、集合年龄属性求和
        Integer ageAmount = persionList.stream().mapToInt(Person::getAge).sum();
        System.out.println("年龄总和为: "+ageAmount);


        //1、查找年龄大于20岁的人数
        long  age=persionList.stream().filter(p->p.getAge()>20).count();
        System.out.println(age);

        //2、查找年龄大于20岁，性别为男的人数
        List<Person>  ageList=persionList.stream().filter(p->p.getAge()>20).filter(p->"男".equals(p.getSex())).collect(Collectors.toList());
        System.out.println(ageList.size());

        String[] arr1 = {"abc","a","bc","abcd"};

        Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        //输出：a、bc、abc、abcd
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        //输出：abcd、abc、bc、a
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //输出：bc、abcd、abc、a
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //输出：a、abc、abcd、bc
        //Arrays.stream(arr1).sorted(Comparator.comparing(this::com1).thenComparing(String::length)).forEach(System.out::println);

        //1、找到年龄最小的岁数
        Collections.sort(persionList, (x, y) -> x.getAge().compareTo(y.getAge()));
        Integer age1 = persionList.get(0).getAge();
        System.out.println("年龄最小的有:" + age1);
        //输出：年龄最小的有:2

        //2、找到年龄最小的姓名
        String name = persionList.stream()
                .sorted(Comparator.comparingInt(x -> x.getAge()))
                .findFirst()
                .get().getName();
        System.out.println("年龄最小的姓名:" + name);

        //上面的接口 通过Lambda表达式重新 say方法
        PersonInterface inter = () -> System.out.println("我说什么好呢？");
        inter.say();
        //控制台输出: 我说什么好呢？

        Person city = new Person(1,"张三","男",38);
        Optional<String> roleOpt = Optional.ofNullable(city).map(Person::getName);
        //如果容器中 不为空
        if (roleOpt.isPresent()) {
        }

        Optional<Person> optCar = Optional.empty();

        //Optional<Person> optUser = Optional.of(user);
    }

}
