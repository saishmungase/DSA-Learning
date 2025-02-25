import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue1 {

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }

        int pop(){
            int data = 0;
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    data = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(data);
                }
            }else{
                while (!q2.isEmpty()) {
                    data = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(data);
                }
            }
            return data;
        }
        int peek(){
            int data = 0;
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    data = q1.remove();
                    q2.add(data);
                }
            }else{
                while (!q2.isEmpty()) {
                    data = q2.remove();
                    q1.add(data);
                }
            }
            return data;
        }
    }

    public static void main(String[] args) {
        Stack s =  new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
