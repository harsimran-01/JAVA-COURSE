//USING ARRAYLIST

import java.util.ArrayList;

public class stack_arraylist {

    static class StackClass {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.get(list.size()-1));
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            return top;
        }

    }

    public static void main(String[] args) {
        StackClass sc = new StackClass();
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
