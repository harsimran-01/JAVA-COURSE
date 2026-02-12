import java.util.*;

public class stack_framework {
    public static void main(String[] args) {
        Stack<Integer>sc = new Stack<>();
        sc.push(1);
        sc.push(2);
        sc.push(3);
        sc.push(4);
        sc.push(5);

        while(!sc.isEmpty()){
            System.out.print(sc.peek()+" ");
            sc.pop();
        }
    }
}
