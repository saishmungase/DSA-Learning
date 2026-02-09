class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Search {

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

    public static boolean search(int val, Node root){

        if(root == null){
            return false;
        }

        if(root.val == val){
            return true;
        }

        else if(root.val < val){
            return search(val, root.right);
        }
        else{
            return search(val, root.left);
        }
        
    }
    
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for(int value : values){
            root = buildTree(value, root);
        }
        boolean soln = search(9, root);
        System.out.println(soln);
    }
}
