import java.util.*;

public class IndianCoin {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int money = 590;
        ArrayList<Integer> requireCoins = new ArrayList<>();
        int countCoins = 0;
        Arrays.sort(coins, Comparator.reverseOrder());
        for(int i = 0; i<coins.length; i++){
            if(money >= coins[i]){
                while (money >= coins[i]) {
                    countCoins++;
                    requireCoins.add(coins[i]);
                    money -= coins[i];
                }
            }
        }
        System.out.println("Number of coins Used => " + countCoins);
        System.out.println("Coins :- " + requireCoins);
    } 
}
