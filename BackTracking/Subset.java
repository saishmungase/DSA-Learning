public class Subset {

    public static void printSubset(String str, int i, String ans){
        // Base Case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }

        // Yes
        printSubset(str, i + 1, ans + str.charAt(i));

        //No
        printSubset(str, i + 1, ans);
        
    }
    
    public static void main(String[] args) {
        String str = "abc";
        printSubset(str, 0, "");
    }

}