import java.util.Scanner;

public class MissingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long Sn = (n * (n + 1))/2;
        long givenSum = 0;
        for(int i = 0; i<n-1; i++){
            givenSum += sc.nextLong();
        }
        System.out.println(Sn-givenSum);
    }
}
