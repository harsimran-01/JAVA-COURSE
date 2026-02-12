import java.util.Scanner;

public class strings {
    public static void iterate(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static boolean isPalindrome(String str){
        String rev = "";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        if(str.equals(rev)) return true;
        else return false;
    }

    public static boolean ispalindrome(String str){
        int n = str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i) != str.charAt(n-1-i)) return false;
        }
        return true;
    }

    public static float getShortestPath(String path){
        int x = 0;
        int y = 0;
        for(int i=0;i<path.length();i++){
            char dir = path.charAt(i);

            if(dir == 'N'){
                y++;
            }else if(dir=='S'){
                y--;
            }else if(dir=='W'){
                x--;
            }else{
                x++;
            }
        }

        int X2 = x*x;
        int Y2 = y*y;

        return (float)Math.sqrt(X2+Y2);
        
    }

    public static String getUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);

            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compressString(String str){
        String s = "";
        for(int i=0;i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            s+=str.charAt(i);
            if(count>1){
                s+=count.toString();
            }

        }
        return s;
    }


    public static void main(String[] args) {
        char ch[] = {'a','b','c','d'};
        String str = "abcd";
        String str2 = new String("abcd");

        Scanner sc = new Scanner(System.in);
        String name = "tony stark";
        System.out.println(name);
        // sc.nextLine();
        // String name1 = sc.nextLine();
        String name1 = "tony stark";
        System.out.println(name1);
        System.out.println(name1.length());
        System.out.println(name + " " + name1);
        System.out.println(name.charAt(0));
        iterate(name1);
System.out.println();
        String p = "naman";
        String p2 = "race";
        
        System.out.println(isPalindrome(p));
        System.out.println(isPalindrome(p2));
        System.out.println(ispalindrome(p));
        System.out.println(ispalindrome(p2));


        // String path = "WNEENESENNN";
        String path = "NN";
        System.out.println(getShortestPath(path));
        String sub = "helloworld";
        System.out.println(sub.substring(3, 6));

        String fruits[] = {"apple","mango","banana"};
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
        System.out.println(largest);

        StringBuilder sb = new StringBuilder("");
        for(char c='a';c<='z';c++){
            sb.append(c);
        }
        System.out.println(sb);

        String upper = "hi , i am simmi";
        System.out.println(getUpperCase(upper));

        String c = "aaabbcccdd";
        System.out.println(compressString(c));


     }
}
