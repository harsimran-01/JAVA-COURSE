



public class recursion2 {
    public static int roman(String str){
        int result = 0;
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == 'I'){
                result+=1;
            }else if (curr == 'V') {
                result += 5;
            } else if (curr == 'X') {
                result += 10;
            } else if (curr == 'L') {
                result += 50;
            } else if (curr == 'C') {
                result += 100;
            } else if (curr == 'D') {
                result += 500;
            } else if (curr == 'M') {
                result += 1000;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String r = "MCMXCIV";
        System.out.println(roman(r));
    }
    
}
