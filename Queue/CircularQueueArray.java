class Queue {
    static int arr[];
    static int size;
    int front = 0;
    int rear = -1;

    Queue(int len) {
        arr = new int[len];
        size = len;
    }

    boolean isEmpty() {
        return front == rear + 1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    void add(int data) {
        if (isFull()) {
            System.out.println("Queue Is Full !");
            return;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    int remove() {
        if (isEmpty()) {
            System.out.println("Queue Is UnderFlow !");
            return -1;
        }
        int frontElem = arr[front];
        front = (front + 1) % size;
        return frontElem;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue Is UnderFlow !");
            return -1;
        }
        return arr[front];
    }
}

public class CircularQueueArray {
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.remove();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
