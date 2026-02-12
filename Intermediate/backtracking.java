public class backtracking {
    public static void printPermuatation(String str, int indx, String newStr){
        if(str.length()==0){
            System.out.println(newStr);
        }
        for(int i =0;i<str.length();i++){
            char currChar = str.charAt(i);
            String newchar = str.substring(0,i)+str.substring(i+1);
            printPermuatation(newchar, indx+1, newStr+currChar);
        }
    }
    public static void main(String[] args) {
        String name = "ABC";
        printPermuatation(name, 0, "");

        
    }
}
