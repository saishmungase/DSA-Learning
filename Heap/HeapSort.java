public class HeapSort {

    public static void heapify(int arr[], int idx, int size){
        int left = idx*2 + 1;
        int right = idx*2 + 2;
        int maxIdx = idx;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != idx){
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapsort(int arr[]){
        int n = arr.length;
        // Build Max Heap
        for(int i = (n/2); i>=0; i--){
            heapify(arr, i, n);
        }

        for(int i = n-1; i>0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4, 5, 3};
        heapsort(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
