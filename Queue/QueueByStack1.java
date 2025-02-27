// Way 1 to create a Queue By Stack
// push => O(n)     pop => O(1)    peek = O(1)

import java.util.Stack;

class Queue{
    Stack <Integer> s1 = new Stack<>();
    Stack <Integer> s2 = new Stack<>();

    boolean isEmpty(){
        return s1.isEmpty();
    }

    void add(int data){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int remove(){
        if(isEmpty()){
            System.out.println("The Queue is Empty Unable To Remove !");
            return -1;
        }
        return s1.pop();
    }

    int peek(){
        if(isEmpty()){
            System.out.println("The Queue is Empty Unable To Remove !");
            return -1;
        }
        return s1.peek();
    }

}

public class QueueByStack1 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
