


public class basecase {

    public static void reverse_no(int n) {
        if (n == 1) {
            System.out.print("1" + " ");
        } else {
            System.out.print(n + " ");
            reverse_no(n - 1);
        }
    }
    public static void increase_no(int n) {
        // if (n == 10) {
        //     System.out.print("10" + " ");
        //     return ;
        // }
        //     System.out.print(n + " ");
        //     increase_no(n+1);

        if(n==1){
            System.out.print("1" + " ");
            return;
        }
        increase_no(n-1);
        System.out.print(n+" ");
        
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sumN(int n){
        if(n==1){
            return 1;
        }
        return n+sumN(n-1);
    }

    public static int fibonacci(int n){
        
        if(n==1 || n==0){
            return n;
        }
        int fib1 = fibonacci(n-1);
        int fib2 = fibonacci(n-2);
        return fib1+fib2;
    }

    public static boolean isSorted(int arr[],int i){

        if(arr[i] == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;

        }
        return isSorted(arr, i+1);
    }

    public static int firstOcc(int arr[] , int i,int key){
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return  firstOcc(arr, i+1, key);
    }

    public static int lastOcc(int arr[] , int i,int key){
        if(i == arr.length) return -1;
        int isFound = lastOcc(arr, i+1, key);
        if(isFound == -1 && arr[i] == key) return i;

        return isFound;
    }

    public static int power(int x,int n){
        if(n==0) return 1;
        return x*power(x, n-1);
    }

    public static int optimized_power(int x,int n){
        if(n==0) return 1;
        int halfPower = optimized_power(x, n/2) * optimized_power(x, n/2);

        if(n%2!=0) halfPower = x * halfPower;

        return halfPower;
    }

    public static void main(String[] args) {
        reverse_no(10);
        System.out.println();
        increase_no(10);
        System.out.println();
        System.out.println(factorial(5));
        System.out.println();
        System.out.println(sumN(5));
        System.out.println(fibonacci(5));
        int arr[] = {1,5,3,4,5,6,4};
        System.out.println(isSorted(arr, 0));
        System.out.println(firstOcc(arr, 0, 7));
        System.out.println(lastOcc(arr, 0, 4));
        System.out.println(power(2, 10));
        System.out.println(optimized_power(2, 5));
    }
}
