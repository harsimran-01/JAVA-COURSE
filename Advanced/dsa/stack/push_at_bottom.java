import java.util.Stack;

public class push_at_bottom {

    public static void pushAtBottom(int data,Stack<Integer>sc){
        if(sc.isEmpty()){
            sc.push(data);
            return;
        }
        int top = sc.pop();
        pushAtBottom(data, sc);
        sc.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer>sc = new Stack<>();
        sc.push(1);
        sc.push(2);
        sc.push(3);
        sc.push(4);
        pushAtBottom(5, sc);

        while(!sc.isEmpty()){
            System.out.print(sc.peek()+" ");
            sc.pop();
        }
    }
}
