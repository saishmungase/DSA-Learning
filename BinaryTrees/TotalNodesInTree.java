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



public class TotalNodesInTree {

    public static int totalNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodeCount = totalNodes(root.left);
        int rightNodeCount = totalNodes(root.right);

        return leftNodeCount+rightNodeCount+1;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(totalNodes(root));
    }
}
