import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

public class RootToLeafPath {
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

    public static void RToLPath(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        list.add(root.val);

        if(root.left == null && root.right == null){
            printList(list);
        }

        RToLPath(root.left, list);
        RToLPath(root.right, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 5, 3, 6, 10, 11, 14};
        Node root = null;
        for(int val : arr){
            root = buildTree(val, root);
        }
        inOrder(root);
        System.out.println();
        RToLPath(root, new ArrayList<>());
    }
}
