import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Merge2BST {

    public static void inOrder(ArrayList<Integer> list, Node root){
        if(root == null){
            return;
        }
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;
    }

    public static Node balancedBST(ArrayList<Integer> arr, int l, int r){
        if(l > r){
            return null;
        }

        int mid = (r + l)/2;
        Node node = new Node(arr.get(mid));
        node.left = balancedBST(arr, l, mid-1);
        node.right = balancedBST(arr, mid+1, r);

        return node;
    }

    public static Node mergNode(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        inOrder(arr1, root1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrder(arr2, root2);

        ArrayList<Integer> mergedList = merge(arr1, arr2);
        return balancedBST(mergedList, 0, mergedList.size() - 1);
    }



    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node rooNode = mergNode(root1, root2);
        preOrder(rooNode);
    }
}
