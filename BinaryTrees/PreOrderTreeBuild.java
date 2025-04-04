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
}

public class PreOrderTreeBuild {
    public static void main(String[] args) {
        int vals[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        PreOrderTree tree = new PreOrderTree();
        Node root = tree.buildPreOrder(vals);
        System.out.println(root.left.right.data);
    }
}