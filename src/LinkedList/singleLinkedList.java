package LinkedList;

/**
 * @author:HYPO
 * @date:2019/4/9 16:58
 * @description:
 */
public class singleLinkedList<T> {
    public node<T> head;

    public singleLinkedList() {
        this.head = new node<T>();
    }

    public singleLinkedList(T[] values) {
        this();
        node<T> rear = this.head;

        for (int i = 0; i < values.length; i++) {
            rear.next = new node<T>(values[i], null);
            rear = rear.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("单链表中元素为：[");
        for (node<T> p = head.next; p != null; p = p.next) {
            sb.append(p.toString());
            if (p.next != null) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /*字符串去重*/
    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition == lastPosition || firstPosition == i) {
                sb.append(charWord);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /*返回单链表的长度*/
    public int getSize() {
        int size = 0;
        for (node<T> p = head.next; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    /*判空*/
    public boolean isEmpty() {
        return head.next == null;
    }

    /*增加结点*/
    public void addNode(int i, T data) {
        node<T> p = head;
        for (int j = 0; p.next != null && j < i - 1; j++) {
            p = p.next;
        }
        p.next = new node<T>(data, p.next);
    }

    /*删除结点*/
    public void deleteNode(int i) {
        node<T> p = head;
        for (int j = 0; p.next != null && j < i - 1; j++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    /*修改结点*/
    public void updateNode(int i, T data) {
        this.deleteNode(i);
        this.addNode(i, data);
    }

    /*查询结点*/
    public void searchNode(int i) {
        node<T> p = this.head;
        for (int j = 0; p.next != null && j < i - 1; j++) {
            p = p.next;
        }
        System.out.println("第" + i + "个节点为：" + p.next.toString());
    }

    /*返回单链表this除去与list中相同节点后的链表*/
    public String difference(singleLinkedList<T> list) {
        StringBuffer sb = new StringBuffer();

        node<T> p = this.head.next;

        while (p != null) {
            int i = 0;
            node<T> q = list.head.next;
            while (q != null) {
                if (p.data != q.data) {
                    i++;
                    if (i == list.getSize()) {
                        sb.append(p.toString());
                        sb.append(" ");
                    }
                }
                q = q.next;
            }
            p = p.next;
        }
        return sb.toString();
    }

    /*返回两个单链表所有不同的元素*/
    public String getDifference(singleLinkedList<T> list) {
        StringBuffer sb = new StringBuffer("所有不同的元素为：");
        sb.append(this.difference(list));
        sb.append(list.difference(this));
        return sb.toString();
    }

    /*返回两个单链表相同的元素*/
    public String getTheSame(singleLinkedList<T> list) {
        StringBuffer sb = new StringBuffer("相同部分为：");

        node<T> p = this.head.next;

        while (p != null) {
            node<T> q = list.head.next;
            while (q != null) {
                if (p.data == q.data) {
                    sb.append(p.toString());
                    sb.append(" ");
                }
                q = q.next;
            }
            p = p.next;
        }
        return sb.toString();
    }

    /*比较两个单链表是否相等*/
    public boolean isEquals(singleLinkedList<T> list) {
        node<T> p = this.head.next;
        node<T> q = list.head.next;

        while (p != null && q != null && p.data == q.data) {
            p = p.next;
            q = q.next;
        }
        return p == q;
    }
}
