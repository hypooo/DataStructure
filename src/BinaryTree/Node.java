package BinaryTree;

/**
 * author:HYPO
 * date:2019/5/29 11:08
 * description:
 */
public class Node<E> {
    public E e;
    public Node left, right;

    public Node(E e, Node left, Node right) {
        this.e = e;
        this.left = left;
        this.right = right;
    }

    public Node(E e) {
        this(e, null, null);
    }

    public Node() {
    }

    @Override
    public String toString() {
        return this.e.toString() + this.left.e.toString() + this.right.e.toString();
    }
}