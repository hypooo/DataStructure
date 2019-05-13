package Array;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * author:HYPO
 * date:2019/5/13 21:58
 * description:
 */
public class myArrayTest {
    public static void main(String[] args) {
        myArray_01 m = new myArray_01(5);
        m.addLast(11);
        m.addLast(22);
        m.addLast(33);
        m.add(3, 44);
        m.addLast(66);
//        m.delete(3);
        m.set(0, 55);
        System.out.println(m);
        System.out.println(m.get(2));
        System.out.println(m.isContain(88));
        System.out.println(m.searchIndex(22));


    }
}
