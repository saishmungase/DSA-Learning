
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

class Queue{
    public static Node head;
    public static Node tail;

    boolean isEmpty(){
        return head == null && tail == null;
    }

    void add(int num){
        Node newNode = new Node(num);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    int remove(){
        if(isEmpty()){
            System.out.println("Unable To Add Val, Queue is Empty !");
            return -1;
        }

        int data = head.data;

        if(tail == head){
            head = tail = null;
        }
        else{ 
            head = head.next;
        }
        return data;
    }

    int peek(){

        if(isEmpty()){
            System.out.println("Unable To Add Val, Queue is Empty !");
            return -1;
        }
        
        return head.data;
    }

}

public class QueueByLists {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        
    }
}
