
import java.util.Scanner;



public class Arrays {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int size = sc.nextInt();

        int arr[] = new int[size];
        boolean isSorted = true;

        System.out.println("Enter Elements of Arrays");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<size-1;i++){
            if(arr[i]>arr[i+1]){
                isSorted = false;
            }
        }

        if(isSorted){
            System.out.println("Array is Sorted");
        }else{
            System.out.println("Array is not Sorted");
        }

    }
}
    

