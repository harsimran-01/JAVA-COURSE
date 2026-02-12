import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        // String name = "Harsimran Kaur";
        // System.out.println(name);

        // // Scanner s = new Scanner(System.in);
        // // String name1 = s.next();
        // // System.out.println(name1);
        // // s.nextLine();
        // // String name2 = s.nextLine();
        // // System.out.println(name2);
        // // String hi = "Hello ";
        // // String name3 = "Sagardeep Singh";
        // // String res = hi + name3;
        // // System.out.println(res);
        // // System.out.println(res.length());
        // // for(int i=0;i<res.length();i++){
        // //     System.out.println(res.charAt(i));
        // // }

        // String n = "Harsimran ";
        // String m = "Harsimran ";

        // String res = n+m;
        // System.out.println(res);

        // if(n.compareTo(m)==0){
        //     System.out.println("Both Strings are Equal");
        // }else{
        //     System.out.println("Both Stings are not Equal");
        // }


        // if(n==m){
        //     System.out.println("Both Strings are Equal");
        // }else{
        //     System.out.println("Both Strings are not Equal");
        // }

        // String n2 = "MyFriend";
        // System.out.println(n2.length());
        // // String m2 = "Harsimran";

        // System.out.println(n2.substring(5));
        // System.out.println(n2.substring(0,5));
        // System.out.println(n2.substring(5,7));
        // System.out.println(n2.substring(5,8));
        // System.out.println(n2.substring(5,n2.length()));

        // String n3 = "simmi";
        // String n3 = "Kaur";
        // n3 = "kaur";
        // System.out.println(n3);


        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        String name2 = name.replaceAll("@gmail.com", "");
        String name3 = name.replace('s', 'S');
        System.out.println(name3);
        System.out.println("Username: "+name2);
    }
}
