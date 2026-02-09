class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class PrintInRange {    
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

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.val >= k1 && root.val <=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.val + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.val < k1){
            printInRange(root.right, k1, k2);
        }
        else if(root.val > k2){
            printInRange(root.left, k1, k2);
        }
    }
    public static void main(String[] args) {
        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int val : arr){
            root = buildTree(val, root);
        }
        inOrder(root);
        System.out.println();
        printInRange(root, 5, 10);
    }   
}
