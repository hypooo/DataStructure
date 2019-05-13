package LinearList;

/**
 * @author:HYPO
 * @date:2019/4/9 17:10
 * @description:
 */
public class singleLinkedListTest {
    public static void main(String[] args) {
        Integer[] values = {1,2,3,4,5};
        Integer[] values2 = {1,2,3,4,5};
        singleLinkedList<Integer> list = new singleLinkedList<Integer>(values);
        singleLinkedList<Integer> list2 = new singleLinkedList<Integer>(values2);

//        System.out.println(list.toString());
//        System.out.println("单链表的长度为："+list.getSize());
//        System.out.println("是否为空："+list.isEmpty());

//        list.addNode(3,7);
//        System.out.println(list.toString());

//        list.deleteNode(4);
//        System.out.println(list.toString());

//        list.updateNode(3,111);
//        System.out.println(list.toString());

//        list.searchNode(3);

//        System.out.println(list.getDifference(list2));
//        System.out.println(list.getTheSame(list2));

        System.out.println(list.isEquals(list2));

    }
}
