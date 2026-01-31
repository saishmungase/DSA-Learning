import java.io.*;
import java.util.*;

public class Apartments {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] people = new long[n];
        long[] apartments = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(people);
        Arrays.sort(apartments);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (Math.abs(people[i] - apartments[j]) <= k) {
                count++;
                i++;
                j++;
            } else if (apartments[j] < people[i] - k) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
