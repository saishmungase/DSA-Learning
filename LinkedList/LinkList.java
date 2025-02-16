

public class LinkList{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){

        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;

    } 

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addMiddle( int idx, int data){
        size++;

        if(idx == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        if(head == null){
            head = tail = newNode;
            return;
        }

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove First
    public int removeFirst(){
        if(size == 0){
            System.out.println("List is Empty !");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){

        if(size == 0){
            System.out.println("List is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        Node prev = head;
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int search(int target){
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if(temp.data == target){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //Recursion Search
    public int helper(Node n, int target){
        if(n == null){
            return -1;
        }
        if(n.data == target){
            return 0;
        }

        int idx = helper(n.next, target);
        if(idx == -1){
            return idx;
        }
        
        return idx+1;
    }

    public int searchRec(int target){
        return helper(head, target);
    }

    // Reverse List

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        tail = prev;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    //Find and Remove nth Node from End;
    public void removeNthLast(int n){
        int i = 1; 
        int toFind = size - n;
        if(n == size){
            head = head.next;
            return;
        }

        Node prev = head;
        while (i < toFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        size--;
    }

    // Checking for Palindrome
    public Node middle(){
        Node fastNode = head;
        Node slowNode = head;
        while (fastNode != null && fastNode.next !=null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public boolean isPalindrom(){
        
        if(head == null || head.next == null){
            return true;
        }

        Node mid = middle();

        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public boolean isCyclic(){ // Floy's Cycle Finding Algorithm
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return;
        }

        slow = head;
        Node prev = null;
        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }


// MERGE SORT

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node getMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
        // Node nodie = new Node(-1);
        // Node temp = nodie;

        // while (a != null && b != null) {
        //     if(a.data > b.data){
        //         temp = b;
        //         b = b.next;
        //         temp = temp.next;
        //     }
        //     else{
        //         temp = a;
        //         a = a.next;
        //         temp = temp.next;
        //     }
        // }
        // while (a != null) {
        //     temp.next = a;
        //     a = a.next;
        //     temp = temp.next;
        // } 
        // while (b != null) {
        //     temp.next = b;
        //     b = b.next;
        //     temp = temp.next;
        // }
        // return nodie.next;
    }


    // ZIG-ZAG PATTERN
    public Node zigZag(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

        return head;
    }


    public static void main(String args[]){
        
        // LinkList ll = new LinkList();
        // ll.head = new Node(4);
        // Node temp =  new Node(3);
        // ll.head.next = temp;
        // ll.head.next.next = new Node(2);
        // ll.head.next.next.next = new Node(1);
        // ll.head.next.next.next.next = temp;
        // System.out.println(ll.isCyclic());
        // ll.removeCycle();
        // System.out.println(ll.isCyclic());
        // ll.printList();
        
        // LinkList ll = new LinkList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.printList();
        // ll.head = ll.mergeSort(ll.head);
        // ll.head = ll.zigZag(ll.head);
        // ll.printList();

        

    }
}