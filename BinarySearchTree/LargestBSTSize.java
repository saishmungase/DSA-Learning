class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }

}

class Info{
    boolean isValid;
    int size;
    int min;
    int max;

    Info(boolean isValid, int size, int min, int max){
        this.isValid = isValid;
        this.size = size;
        this.max = max;
        this.min = min;
    }
}

public class LargestBSTSize {

    public static int maxSizeOfBST = 0;

    public static Info findMaxTreeSize(Node node){

        if(node == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = findMaxTreeSize(node.left);
        Info right = findMaxTreeSize(node.right);

        boolean isValid = (left.isValid && right.isValid);

        if(left.max >= node.val || right.min <= node.val){
            isValid = false;
        }
        
        int size = left.size + right.size + 1;
        int min = Math.min(node.val, Math.min(left.min, right.min));
        int max = Math.max(node.val, Math.max(left.max, right.max));
        if(isValid && maxSizeOfBST < size){
            maxSizeOfBST = size;
        }

        return new Info(isValid, size, min, max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        findMaxTreeSize(root);
        System.out.println(maxSizeOfBST);
    }
}
