
public class Stringbuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("simi");
        System.out.println(sb);

        // char at index

        // System.out.println(sb.charAt(0));


        // change char at particular index

        // sb.setCharAt(0, 'S');
        // System.out.println(sb);

        // inserting
        // sb.insert(3, "m");
        // sb.insert(0, "hii ");
        // System.out.println(sb);

        // sb.delete(0, 4);
        // System.out.println(sb);

        // sb.append(" kaur");
        // System.out.println(sb);

        for(int i=0;i<sb.length()/2;i++){
            int front = i;
            int back = sb.length() - 1 - i;

            char frontchar = sb.charAt(front);
            char backchar = sb.charAt(back);

            sb.setCharAt(front, backchar);
            sb.setCharAt(back,frontchar);
        }
        System.out.println(sb);



    }
    

}
