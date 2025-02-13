public class Permutation {

    public static void countPermutation(String str, String ans){
        // Base
        if(0 == str.length()){
            System.out.print(ans + " ");
        }

        // Kaam
        for(int i = 0 ; i<str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            countPermutation(newStr, ans + ch);
        }

    }

    public static void main(String[] args) {
        countPermutation("abc", "");
    }
}
