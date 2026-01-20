import java.util.*;

public class SticklerTheif {

    static int mem[];
    
    public static int maxMoney(int arr[], int idx){
        if(idx>= arr.length) return 0;
        if(mem[idx] != -1) return mem[idx];

        int steal = arr[idx] + maxMoney(arr, idx+2);
        int skip = maxMoney(arr, idx+1);
        
        return mem[idx] = Math.max(steal, skip);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 1, 7, 4};

        mem = new int[arr.length];

        Arrays.fill(mem, -1);

        System.out.println(maxMoney(arr, 0));
    }
}
