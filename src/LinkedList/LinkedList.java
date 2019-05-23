package LinkedList;

import jdk.jfr.events.ThrowablesEvent;

/**
 * author:HYPO
 * date:2019/5/22 20:54
 * description:
 */
public class LinkedList<E> {

    /*结点类*/
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;//头结点
    private int size;//链表长度

    public LinkedList() {
        head = new Node();
        size = 0;
    }

    /*获取链表中的元素个数*/
    public int getSize() {
        return size;
    }

    /*返回链表是否为空*/
    public boolean isEmpty() {
        return size == 0;
    }

    /*在链表的index位置添加新的元素e*/
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = new Node(e);
        node.next = p.next;
        p.next = node;

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /*获得链表的第index个位置的元素*/
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error");
        }
        Node p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.e;
    }

    /*修改链表的第index个位置的元素为e*/
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error");
        }
        Node p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.e = e;
    }

    /*从链表中删除index位置的元素, 返回删除的元素*/
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error");
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = p.next;
        p.next = node.next;
        node.next = null;
        size--;

        return node.e;
    }

    /*从链表中删除元素e*/
    public void removeElement(E e) {
        Node p = head;
        while (p.next != null) {
            if (p.next.e.equals(e)){
                break;
            }
            p = p.next;
        }

        if (p.next != null) {
            Node node = p.next;
            p.next = node.next;
            node.next = null;
            size--;
        }
    }

    /*判断链表中是否有元素e*/
    public boolean contain(E e) {
        Node p = head.next;
        while (p != null) {
            if (p.e.equals(e)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head.next;
        while (p != null) {
            sb.append(p).append("->");
            p = p.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
            System.out.println(list);
        }
        list.removeElement(0);
        System.out.println(list);
    }


}
