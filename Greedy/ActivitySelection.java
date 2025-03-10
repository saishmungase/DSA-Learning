import java.util.*;

public class ActivitySelection{
    public static void main(String[] args) {
        int start[] = {1, 8, 0, 5, 3, 5};
        int end[]   = {2, 9, 6, 9, 4, 7};

        int activities[][] = new int[end.length][3];
        for(int i = 0; i<end.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));  // Sorted Based on the 2nd col
        int maxAct = 0;
        ArrayList<Integer> soln = new ArrayList<>();

        // First Added
        soln.add(activities[0][0]);
        maxAct++;

        int lastEnd = activities[0][2];
        for(int i = 1; i<end.length; i++){
            if(activities[i][1] >= lastEnd){
                lastEnd = activities[i][2];
                maxAct++;
                soln.add(activities[i][0]);
            }
        }
        System.out.println(maxAct);
        for(int i = 0; i<soln.size(); i++){
            System.out.println("A" + soln.get(i) + " " );
        }
    }
}