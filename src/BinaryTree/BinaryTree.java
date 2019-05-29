package BinaryTree;

/**
 * author:HYPO
 * date:2019/5/26 15:25
 * description:二叉树
 */
public class BinaryTree<E> {
    private class Node {
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
    }

    public Node root;
    public int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.root == null;
//        return size == 0;
    }

    /*插入根结点,原根结点作为新结点的左结点*/
    public Node insert(E e) {
        return root = new Node(e, root, null);

    }

    /*向二叉树中插入结点*/
    public Node insert(Node parent, E e, boolean isLeft) {
        if (e == null)
            return null;
        if (isLeft) {
            return parent.left = new Node(e, parent.left, null);
        } else {
            return parent.right = new Node(e, null, parent.right);
        }
    }

    /*删除子树*/
    public void remove(Node parent, boolean isLeft) {
        if (isLeft) {
            parent.left = null;
        } else parent.right = null;
    }

    /*删除全部结点*/
    public void clear() {
        root = null;
    }

    /*先根次序遍历*/
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preorder(node.left);
        preorder(node.right);
    }

    /*获取二叉树的结点数*/
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    /*获取二叉树的高度*/
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;

    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        int[] values = {2, 3, 5, 6, 8};
        for (int value : values) {
            tree.insert(value);
        }
//        tree.preorder();
        System.out.println(tree.height());
        System.out.println(tree.size());
    }
}






















