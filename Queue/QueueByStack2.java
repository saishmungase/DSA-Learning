// Way 2 to create a Queue By Stack
// push => O(1)     pop => O(n)    peek = O(n)

import java.util.Stack;

class Queue{
    Stack <Integer> s1 = new Stack<>();
    Stack <Integer> s2 = new Stack<>();

    boolean isEmpty(){
        return s1.isEmpty();
    }

    void add(int data){
        s1.push(data);
    }

    int remove(){
        if(isEmpty()){
            System.out.println("The Queue is Empty Unable To Remove !");
            return -1;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int data = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return data;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("The Queue is Empty Unable To Remove !");
            return -1;
        }
        
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int peekVal = s1.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return peekVal;
    }

}

public class QueueByStack2 {
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