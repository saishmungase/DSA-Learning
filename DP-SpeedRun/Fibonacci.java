import java.util.*;

public class Fibonacci {

    static int [] mem;

    public static int fibo(int n){
        if(n <= 1) return n;

        if(mem[n] > 0) return mem[n];

        return mem[n] = fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        int n = 3;
        mem = new int[n+1];
        for(int i = 0; i <= n; i++) mem[i] = -1;
        System.out.println(fibo(n));
    }
}
