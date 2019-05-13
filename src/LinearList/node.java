package LinearList;

/**
 * @author:HYPO
 * @date:2019/4/9 16:49
 * @description:
 */
public class node<T> {
    public T data;
    public node<T> next;

    public node(){
        this.data = null;
        this.next = null;
    }

    public node(T data, node<T> next){
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
