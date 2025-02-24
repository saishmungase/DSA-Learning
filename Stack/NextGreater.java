import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int arr[] = {6, 1, 2, 3, 7, 5, 9};
        int nextLarge[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length -1; i>=0; i--){
            //Remove Right Smaller
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]){
                s.pop();
            }

            // Check To Update The NextLarge
            if(s.isEmpty()){
                nextLarge[i] = -1;
            }else{
                nextLarge[i] = arr[s.peek()];
            }

            s.push(i);
        }
        for(int i = 0; i<nextLarge.length; i++){
            System.out.print(nextLarge[i] + " ");
        }
    }
}
