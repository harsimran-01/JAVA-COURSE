import java.util.*;
public class test2{

public static void main(String args[]){

Scanner sc = new Scanner(System.in);
System.out.println("Enter the size of an Array ");
int size = sc.nextInt();

int arr[] = new int[size];
for(int i=0;i<size;i++){
arr[i] = sc.nextInt();
}

int largest = arr[0];

for(int i=0;i<size;i++){
if(arr[i] > largest){
largest = arr[i];
}else{
continue;
}
}

System.out.println("Largest Number in Array " + largest);


}

}