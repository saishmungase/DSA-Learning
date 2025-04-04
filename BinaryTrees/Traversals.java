import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class PreOrderTree{
    public static int idx = -1;

    public Node buildPreOrder(int vals[]){
        idx++;
        if(vals[idx] == -1){
            return null;
        }

        Node newNode = new Node(vals[idx]);
        newNode.left = buildPreOrder(vals);
        newNode.right = buildPreOrder(vals);

        return newNode;
    }

    // Pre Order Traversal
    public void preOrder(Node root){
        if(root == null){
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-Order Traversal
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

public class Traversals {
    public static void main(String[] args) {
        int vals[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        PreOrderTree tree = new PreOrderTree();
        Node root = tree.buildPreOrder(vals);
        System.err.println("Pre Order Traversal => ");
        tree.preOrder(root);
        System.out.println("In Order Traversal => ");
        tree.inOrder(root);
        System.out.println("Post Order Traversal => ");
        tree.postOrder(root);
    }
}
