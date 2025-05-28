import java.util.*;

class Job{
    int deadline;
    int profit;
    char id;
    Job(char id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline; 
        this.profit = profit;
    }
}

public class JobSequence {
    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, { 1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 0; i<jobsInfo.length; i++){
            jobs.add(new Job((char)(65+i), jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        ArrayList<Character> sequence = new ArrayList<>();
        int prevDealine = 0;
        for(int i = 0; i<jobs.size(); i++){
            Job currJob = jobs.get(i);
            if(currJob.deadline > prevDealine){
                sequence.add(currJob.id);
            }
            prevDealine = currJob.deadline;
        }
        System.out.println(sequence);
    }
}
