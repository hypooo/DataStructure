package BinaryTree;

import javax.swing.tree.TreeNode;

/**
 * author:HYPO
 * date:2019/5/26 15:25
 * description:二叉树
 */
public class BinaryTree<E> {


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

    /*判断两个二叉树是否相等*/
    public static boolean isSameTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1 != null && node2 != null) {
            if (!node1.e.equals(node2.e)) {
                return false;
            } else {
                return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
            }
        }
        return false;
    }

    /*先根次序遍历*/
    public void preorder() {
        System.out.print("先序遍历：");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.e);
        preorder(node.left);
        preorder(node.right);
    }

    /*中序遍历*/
    public void inorder() {
        System.out.print("中序遍历：");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.e);
        inorder(node.right);
    }

    /*后序遍历*/
    public void postorder() {
        System.out.print("后序遍历：");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.e);
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

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "^";
        }

        return node.e.toString() + toString(node.left) + toString(node.right);
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

    /*深拷贝构造方法*/
    public BinaryTree(BinaryTree tree) {
//        root = tree.root;
        root = copy(tree.root);

    }

    private Node copy(Node node){
        if (node == null){
            return null;
        }
        Node newnode = new Node(node.e);

        newnode.left = copy(node.left);
        newnode.right = copy(node.right);

        return newnode;
    }


    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();

        Node A = tree.insert("A");
        Node B = tree.insert(A, "B", true);
        Node C = tree.insert(A, "C", false);
        Node D = tree.insert(B, "D", true);
        Node G = tree.insert(D, "G", false);
        Node E = tree.insert(C, "E", true);
        Node F = tree.insert(C, "F", false);
        Node H = tree.insert(F, "H", true);

        tree.preorder();
        tree.inorder();
        tree.postorder();
        System.out.println("高度：" + tree.height());
        System.out.println("结点数：" + tree.size());
        System.out.println(tree);

        BinaryTree<String> tree1 = new BinaryTree<String>(tree);
        System.out.println(tree1);
        tree.insert("Z");
        System.out.println(tree);
        System.out.println(tree1);



    }
}






















