// I have to create Balanced BST

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class SortedToBST {

    public static Node balancedBST(int arr[], int l, int r){
        if(l == r){
            return new Node(arr[l]);
        }

        int mid = (r + l)/2;
        Node node = new Node(arr[mid]);
        node.left = balancedBST(arr, l, mid-1);
        node.right = balancedBST(arr, mid+1, r);

        return node;
    }

    public static void printPreOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = balancedBST(arr, 0, arr.length-1);
        printPreOrder(root);
    }
}
