import java.io.*; // 1. Import IO
import java.util.*;

public class DistinctNum {
    public static void main(String args[]) throws IOException { // 2. Throw Exception
        // 3. Use BufferedReader for Fast Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // StringTokenizer breaks the line into words/numbers
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        Set<Long> unique = new HashSet<>();
        
        // Check if we need to read more lines
        // If n is large, the inputs might be on the next line
        // Usually, we create a helper for this (see below), but for simple logic:
        
        // This loop reads the rest of the numbers
        // Note: For very large inputs, numbers might be split across lines. 
        // A standard FastReader template handles that best.
        
        // Simplified Fast approach for single line input or standard spacing:
        for(int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) { // If current line is empty, read next
                st = new StringTokenizer(br.readLine());
            }
            long val = Long.parseLong(st.nextToken());
            unique.add(val);
        }
        
        System.out.println(unique.size());
    }
}