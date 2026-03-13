public class ClimbingStairs {
    static int calls = 0;

    public static int climbRec(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        calls++;
        return  climbRec(n-1) + climbRec(n-2);
    }

    public static int climbRecMem(int n, int arr[]){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(arr[n] != 0) return arr[n];
        calls++;
        return arr[n] = climbRecMem(n-1, arr) + climbRecMem(n-2, arr);
    }

    public static int climbRecTab(int n){
        int arr[] = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static int climbVariation(int n, int arr[]){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(arr[n] != 0) return arr[n];
        calls++;
        return arr[n] = climbVariation(n-1, arr) + climbVariation(n-2, arr) + climbVariation(n-3, arr);
    }

    public static void main(String[] args) {
        int n = 10;

        calls = 0;
        System.out.println(climbRec(n) + " (" + calls + ")");
        calls = 0;
        System.out.println(climbRecMem(n, new int[n+1]) + " (" + calls + ")");
        calls = 0;
        System.out.println(climbRecTab(n) + " (" + n + ")");
        calls = 0;
        System.out.println(climbVariation(n, new int[n+1]) + " (" + calls + ")");
    }
}
