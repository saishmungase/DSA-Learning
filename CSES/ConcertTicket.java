import java.io.*;
import java.util.*;

public class ConcertTicket {

    static int findTicket(ArrayList<Integer> tickets, int x) {
        int l = 0, r = tickets.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (tickets.get(mid) <= x) {
                ans = mid;     
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> tickets = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tickets.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(tickets);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int req = Integer.parseInt(st.nextToken());

            int idx = findTicket(tickets, req);

            if (idx == -1) {
                sb.append("-1\n");
            } else {
                sb.append(tickets.get(idx)).append("\n");
                tickets.remove(idx);
            }
        }

        System.out.print(sb.toString());
    }
}
