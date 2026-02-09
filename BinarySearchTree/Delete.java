class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class Delete {

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



    
    public static Node findInOrderSuccesor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }
         
        if(root.val > val){
            root.left = deleteNode(root.left, val);
        }
        else if(root.val < val){
            root.right = deleteNode(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            Node IS = findInOrderSuccesor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int val : arr){
            root = buildTree(val, root);
        }
        inOrder(root);
        deleteNode(root, 4);
        System.out.println();
        inOrder(root);
    }
}
