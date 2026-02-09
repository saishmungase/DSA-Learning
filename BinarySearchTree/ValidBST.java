import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class ValidBST {    
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
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void printList(ArrayList<Integer> list){
        for(int val : list){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static boolean isValid(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && min.val >= root.val){
            return false;
        }
        else if(max != null && max.val <= root.val){
            return false;
        }

        return ( isValid(root.left, min, root) && isValid(root.right, root, max) );
    }
    public static void main(String[] args) {
        // int arr[] = { 8, 5, 3, 6, 10, 11, 14};
        int arr[] = { 8, 8, 8};
        Node root = null;
        for(int val : arr){
            root = buildTree(val, root);
        }
        System.out.println(isValid(root, null, null));
    }
}
