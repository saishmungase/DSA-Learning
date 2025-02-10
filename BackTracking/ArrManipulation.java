public class ArrManipulation{

    // Increment the array values => index + 1 and after that decrese them by 2

    public static void arrAssign(int arr[], int idx){
        
        // Base
        if(idx == arr.length){
            printArr(arr);
            return; 
        }

        // Kaam
        arr[idx] = idx + 1;
        arrAssign(arr, idx + 1);

        // Back Track
        arr[idx] = arr[idx] - 2;
    }


    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String arg[]){
        int arr[] = new int[5];
        arrAssign(arr, 0);
        printArr(arr);
    }
}