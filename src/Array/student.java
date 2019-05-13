package Array;

/**
 * author:HYPO
 * date:2019/5/13 23:20
 * description:
 */
public class student {
    private String name;
    private int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        myArray_02<student> m2 = new myArray_02<>();
        m2.addLast(new student("李白", 18));
        m2.addLast(new student("marco", 17));
        System.out.println(m2);

        myArray_02<Integer> m3 = new myArray_02<>(3);
        m3.addLast(11);
        m3.addLast(22);
        m3.addLast(33);
        m3.addLast(44);
        m3.deleteByElement(44);
        System.out.println(m3);
    }
}
