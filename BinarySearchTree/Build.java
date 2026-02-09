class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Build{

    public static Node buildTree(int val, Node root){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.val < val){
            root.right = buildTree(val, root.right);
        }
        else{
            root.left = buildTree(val, root.left);
        }

        return root;
    }

    public static void inOrder(Node root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);

    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for(int value : values){
            root = buildTree(value, root);
        }
        inOrder(root);
    }
}