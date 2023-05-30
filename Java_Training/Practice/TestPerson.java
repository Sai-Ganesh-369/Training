package Practice;

import java.util.Comparator;

public class TestPerson{
    int age;
    String name;

    public TestPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "TestPerson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestPerson tst = new TestPerson(20, "Ganesh");
        TestPerson tst1 = new TestPerson(45 ,"Mahesh");
        TestPerson tst3 = new TestPerson(45, "Chiru");

        System.out.println(tst);
        Comparator<TestPerson> byname =Comparator.comparing(TestPerson::getName);
        System.out.println(byname.compare(tst1 , tst));
        System.out.println(byname.compare(tst3,tst1));

        Comparator<TestPerson> byAge = Comparator.comparing(TestPerson::getAge);
        System.out.println(byAge.compare(tst1,tst));
        System.out.println(byAge.compare(tst3,tst1));


    }
}