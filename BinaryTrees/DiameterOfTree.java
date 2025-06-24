// Diameter => Number of nodes in the longest path between two nodes

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}


class Info{
    int dia;
    int height;

    Info(int dia, int height){
        this.dia = dia;
        this.height = height;
    }
}

public class DiameterOfTree {

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    //O(n^2)
    public static int diameterOfTree1(Node root){

        if(root == null){
            return 0;
        }
        
        int lDia = diameterOfTree1(root.left);
        int lHeight = height(root.left);
        int rDia = diameterOfTree1(root.right);
        int rHeight = height(root.right);

        int selfDia = lHeight + rHeight + 1;

        return Math.max(Math.max(lDia, rDia), selfDia);
    }

    // O(n)
    public static Info optimizeDia(Node root){

        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = optimizeDia(root.left);
        Info righInfo = optimizeDia(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, righInfo.dia), leftInfo.height + righInfo.height + 1);
        int height = Math.max(leftInfo.height, righInfo.height) + 1;
        return new Info(dia, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(optimizeDia(root).dia);
    }

}
