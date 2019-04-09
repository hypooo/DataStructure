package LinearList;

/**
 * @author:HYPO
 * @date:2019/4/9 16:58
 * @description:
 */
public class SingleLinkedList<T> extends Object{
    public Node<T> head;

    public SingleLinkedList(){
        this.head = new Node<T>();
    }

    public SingleLinkedList(T[] values){
        this();
        Node<T> rear = this.head;

        for (int i = 0; i < values.length; i++){
            rear.next = new Node<T>(values[i],null);
            rear = rear.next;
        }
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("单链表中元素为：[");
        for (Node<T> p = head.next; p != null; p = p.next){
            sb.append(p.toString());
            if (p.next != null){
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }
    /*字符串去重*/
    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition  == lastPosition || firstPosition == i) {
                sb.append(charWord);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    /*返回单链表的长度*/
    public int getSize(){
        int size = 0;
        for(Node<T> p = head.next; p != null; p = p.next){
            size++;
        }
        return size;
    }
    /*判空*/
    public boolean isEmpty(){
        return head.next == null;
    }
    /*增加结点*/
    public void addNode(int i,T data){
        Node<T> p = head;
        for (int j = 0; p.next != null && j < i - 1; j++){
            p = p.next;
        }
        p.next = new Node<T>(data,p.next);
    }
    /*删除结点*/
    public void deleteNode(int i){
        Node<T> p = head;
        for (int j = 0; p.next != null && j < i - 1; j++){
            p = p.next;
        }
        p.next = p.next.next;
    }
    /*修改结点*/
    public void updateNode(int i,T data){
        this.deleteNode(i);
        this.addNode(i,data);
    }
    /*查询结点*/
    public void searchNode(int i){
        Node<T> p = head;
        for (int j = 0; p.next != null && j < i - 1; j++){
            p = p.next;
        }
        System.out.println("第"+i+"个节点为："+p.next.toString());
    }
    /*返回单链表this除去与list中相同节点后的链表*/
    public String difference(SingleLinkedList<T> list){
        StringBuffer sb = new StringBuffer();

        Node<T> p = this.head.next;

        while (p != null){
            int i = 0;
            Node<T> q = list.head.next;
            while (q != null){
                if (p.data != q.data){
                   i++;
                   if (i == list.getSize()){
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
    public String getDifference(SingleLinkedList<T> list){
        StringBuffer sb = new StringBuffer("所有不同的元素为：");
        sb.append(this.difference(list));
        sb.append(list.difference(this));
        return sb.toString();
    }
    /*返回两个单链表相同的元素*/
    public String getTheSame(SingleLinkedList<T> list){
        StringBuffer sb = new StringBuffer("相同部分为：");

        Node<T> p = this.head.next;

        while (p != null){
            Node<T> q = list.head.next;
            while (q != null){
                if (p.data == q.data){
                    sb.append(p.toString());
                    sb.append(" ");
                }
                q = q.next;
            }
            p = p.next;
        }
        return sb.toString();
    }
}
