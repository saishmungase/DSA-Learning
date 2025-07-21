
class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

public class KthAnc {

    static int soln = -1;

    public static int KthAncistor(Node root, int from, int k){
        if(root == null){
            return -1;
        }

        if(root.val == from){
            return 0;
        }

        int left = KthAncistor(root.left, from, k);
        int right = KthAncistor(root.right, from, k);

        if(left == -1 && right == -1){
            return -1;
        }

        int max = Math.max(left, right);

        if(max+1 == k){
            // System.out.println(root.val);
            soln = root.val;
        }

        return max+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        KthAncistor(root, 7, 1);
        System.out.println(soln);
    }    
}
