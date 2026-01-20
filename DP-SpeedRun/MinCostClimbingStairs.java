/*
    We have to take 0 or 1 index initialy then we can look for next chances.
*/

import java.util.*;

public class MinCostClimbingStairs {

    public static int minCostToReach(int [] cost, int idx, int mem[]){
        if(idx >= cost.length) return 0;
        if(mem[idx] != -1) return mem[idx];

        int stepOne = cost[idx] + minCostToReach(cost, idx+1, mem);
        int stepTwo = cost[idx] + minCostToReach(cost, idx+2, mem);

        return mem[idx] = Math.min(stepOne, stepTwo);
    }

    public static void main(String[] args) {
        int cost[] = {20, 10, 5, 2};
        // int cost1[] = {10, 15, 20};
        int n = cost.length;
        int mem[] = new int[n];
        Arrays.fill(mem, -1);
        System.out.println(Math.min(minCostToReach(cost, 0, mem), minCostToReach(cost, 1, mem)));
    }
}
