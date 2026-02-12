
import java.util.Scanner;

public class bit {
    public static void main(String[] args) {
        int num = 5; // 101
        // int pos = 2;
        // int pos = 1;
        int pos = 2;
        // int pos = 1;
        int bitmask = 1<<pos;
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        //GET

        // if((bitmask | num )==0){
        //     System.out.println("Bit at position " + pos + " is 0");
        // }
        // else{
        //     System.out.println("Bit at position " + pos + " is 1");
        // }


        // SET

        // int res = bitmask | num ;
        // System.out.println("Result : "+res);


        //CLEAR 

        // int com_bitmask = ~bitmask;
        // int res = com_bitmask & num;
        // System.out.println("Result : "+res);

        //UPDATE

        if(op == 1){
            int res = bitmask | num;
            System.out.println("Result : "+ res);
        }else{
            int com_bitmask = ~bitmask;
            int res = com_bitmask & num;
            System.out.println("Result : "+ res);
        }
    }
    
}
