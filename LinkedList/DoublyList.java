class DoublyLinkedList{
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    void addLastD(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }

    void printDLL(){
        Node idx = head;
        while (idx != null) {
            System.out.print(idx.data + "<-->");
            idx = idx.next;
        }
        System.out.println("null");
    }
}

public class DoublyList {
    public static void main(String[] args) {  
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLastD(1);
        dll.addLastD(2);
        dll.addLastD(3);
        dll.addLastD(4);
        dll.addLastD(5);
        dll.addLastD(6);
        dll.addLastD(7);
        
        dll.printDLL(); 
    }
}

