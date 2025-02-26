public class StackByLinkedList {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node head = null;

    static class Stack{

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node n = new Node(data);
            if(isEmpty()){
                head = n;
            }
            n.next = head;
            head = n;
        }

        public int pop(){

            if(isEmpty()){
                return -1;
            }
            
            int top = head.data;
            head = head.next;

            return top;
        }

        public int peek(){
            return head.data;
        }

    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
