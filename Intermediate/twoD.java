
import java.util.Scanner;

public class twoD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details about First Matrix");
        System.out.println("Enter the number of Rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the number of Columns: ");
        int col = sc.nextInt();


        int arr[][] = new int[row][col];
        System.out.println("Enter the elements of an array: ");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = sc.nextInt();
            }
        }


        System.out.println("Matix :");

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



        System.out.println("Enter details about Second Matrix");
        System.out.println("Enter the number of Rows: ");
        int row1 = sc.nextInt();
        System.out.println("Enter the number of Columns: ");
        int col1 = sc.nextInt();


        int arr2[][] = new int[row1][col1];
        System.out.println("Enter the elements of an array: ");
        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                arr2[i][j] = sc.nextInt();
            }
        }


        System.out.println("Matrix: ");

        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Addition Matrix: ");
        int add[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                add[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(add[i][j] + " ");
            }
            System.out.println();
        }

       

    }
    
}
