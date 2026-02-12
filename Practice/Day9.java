import java.util.Scanner;

public class Day9 {
    public static void update(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i] + 1;
        }
    }


    public static void linearsearch(int arr[],int key){
        boolean found = false;
        int i;
        for(i=0;i<arr.length;i++){
            if(arr[i] == key){
                found = true;
                break;
            }else{
                continue;
            }
        }
        if(found) System.out.println("Element " + key + " is found at index "+i);
        else System.out.println("Element Not found in Array");
    }

    public static int largestnum(int arr[]){
        // int max = arr[0];
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] > max){
        //         max = arr[i];
        //     }else{
        //         continue;
        //     }
        // }
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }else{
                continue;
            }
        }
        // return max;
        return min;
    }

    public static int binarySearch(int arr[],int key){
        int start = 0,end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key) return mid;
            else if(arr[mid]>key) end = mid-1;
            else if(arr[mid]<key) start = mid+1; 
        }
        return -1;
    }

    public static void reverse(int arr[]){
        int rev[] = new int[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            rev[j] = arr[i];
            j++;
        }
        for(int i=0;i<rev.length;i++){
            System.out.println(rev[i]);
        }
    }

    public static void optimized_reverse(int arr[]){
        int start=0,end = arr.length-1;
        while(start<end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void pairsArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+"," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subarraysPair(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k] + " ");
                }
                count++;
                System.out.println();
            }
        }
        System.out.println("Count "+ count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[5];
        // System.out.println("Enter Elements of Array");
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }
        // System.out.println("Printing Array Elements");
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }

        // System.out.println("Updating marks of Students");
        // int marks[] = {97,98,99};
        // update(marks);
        // for(int i=0;i<marks.length;i++){
        //     System.out.println(marks[i]);
        // }


        // System.out.println("Linear search");
        // int linear[] = new int[5];
        // System.out.println("Enter Elements of Array");
        // for(int i=0;i<linear.length;i++){
        //     linear[i] = sc.nextInt();
        // }
        // linearsearch(linear, 10);

        // System.out.println("Largest Element in Array");
        // int largest[] = new int[5];
        // System.out.println("Enter Elements of Array");
        // for(int i=0;i<largest.length;i++){
        //     largest[i] = sc.nextInt();
        // }
        // System.out.println("Largest Value in Array "+largestnum(largest));

        // System.out.println("Binary search");
        // int binary[] = new int[5];
        // System.out.println("Enter Elements of Array");
        // for(int i=0;i<binary.length;i++){
        //     binary[i] = sc.nextInt();
        // }
        // System.out.println("Element found at index "+binarySearch(binary, 10));

        // System.out.println("Reverse Array");
        // int arrrev[] = new int[5];
        // System.out.println("Enter Elements of Array");
        // for(int i=0;i<arrrev.length;i++){
        //     arrrev[i] = sc.nextInt();
        // }
        // reverse(arrrev);
        // System.out.println("Reverse Array using optimized approach");
        
        // optimized_reverse(arrrev);

        System.out.println("Pairs in Array");
        int p[] = new int[5];
        for(int i=0;i<p.length;i++){
            p[i] = sc.nextInt();
        }
        pairsArray(p);
        System.out.println("Subarrays Pairs");
        subarraysPair(p);

    }
}
