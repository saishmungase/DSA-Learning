class Queue{
    static int arr[];
    static int size;
    int front = 0;
    int rear = -1;

    Queue(int len){
        arr = new int[len];
        size = len;
    }

    boolean isEmpty(){
        return rear == -1;
    }

    void add(int data){
        if(rear == size - 1){
           System.out.println("Queue Is Full !");
           return;
        }
        rear++;
        arr[rear] = data;
    }

    int remove(){
        if(isEmpty()){
            System.out.println("Queue Is UnderFlow !");
            return -1;
        }
        int front = arr[0];
        for(int i = 0; i<rear; i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }
    
    void printQueue(){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Queue Is UnderFlow !");
            return -1;
        }

        return arr[front];
    }
}


public class QueueUsingArrray {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}