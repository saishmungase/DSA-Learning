class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class UniValued{

    public static Node checkForUni(Node root){

        if(root == null){
            return null;
        }

        Node left = checkForUni(root.left);
        Node right = checkForUni(root.right);

        if(left != null && left.val != root.val){
            return new Node(0);
        }
        if(right != null && right.val != root.val){
            return new Node(0);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(2);


        if(checkForUni(root).val == 0){
            System.out.println(false);
        }
        else{
            System.out.println(true);
        }
        
    }
    
}