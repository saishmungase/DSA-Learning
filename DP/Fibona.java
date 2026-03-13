public class Fibona {

    static int dp[] = new int[11];
    static int count = 0;

    public static int fibo(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }

        int num = fibo(n-1) + fibo(n-2);
        count++;
        return dp[n] = num;
    }

    public static int fibTab(int n){
        int fp[] = new int[n+1];
        fp[0] = 0;
        fp[1] = 1;
        for(int i = 2; i <= n; i++){
            fp[i] = fp[i-1] + fp[i-2];
        }

        return fp[n];
    }

    public static void main(String[] args) {

        // System.out.println(fibo(10));
        // System.out.println(count);
        System.out.println(fibTab(5));
    }
}
