package suanfa.com.pak;

public class Student implements Cloneable {
    public String name;
    public Integer age;
    public String sex;

    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 提供get和set方法和全参构造函数
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
