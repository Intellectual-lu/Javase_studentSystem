/**
 *学生类 用于存放学生的各项属性
 */

public class Student {
    private int sid;
    private String name;
    private int age;
    private Gender gender;

    enum Gender{男,女}

    public Student() {
    }

    public Student(int sid, String name, int age, Gender gender) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{学号=" + sid + ", 姓名='" + name + '\'' + ", 年龄=" + age + ", 性别=" + gender + '}';
    }
}
