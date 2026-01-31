import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws Exception {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long child[] = new long[n];

        for(int i = 0; i < n; i++){
            child[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(child);
        int count = 0;

        int i = 0;
        int j = n - 1;

        while(i <= j){
            if(child[i] + child[j] <= x){
                i++;
            }
            j--;
            count++;
        }

        System.out.println(count);
    }
}
