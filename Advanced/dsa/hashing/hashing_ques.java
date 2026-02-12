
import java.util.HashMap;
import java.util.HashSet;

public class hashing_ques {

    public static void MajorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }

    }

    public static int UnionOfSets(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Printing all the Elements of Union Set ");
        System.out.print("UNION = " + set);
        System.out.println();
        System.out.print("Count of Elements in UNION SET = ");
        return set.size();
    }

    public static int IntersectionOfSets(int arr1[],int arr2[]){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            set1.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            if(set1.contains(arr2[i])){
                intersection.add(arr2[i]);
            }
        }

        System.out.print("Printing the Intersection Set = ");
        System.out.println(intersection);
        System.out.print("Printing the count of elements in Intersection Array = ");
        return intersection.size();
    }

    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key:tick.keySet()){
            revMap.put(tick.get(key), key);
        }

        for(String key:tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }

        }
        return null;

    }

    public static void main(String[] args) {
        // int nums[] = {1,3,2,5,1,3,1,5,1};

        int nums[] = {1, 2};
        System.out.println("Majority Element ");
        MajorityElement(nums);

        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 7, 4};

        System.out.println(UnionOfSets(arr1, arr2));

        int Iarr1[] = {7, 3, 9};
        int Iarr2[] = {6, 3, 9, 2, 7, 4};

        System.out.println(IntersectionOfSets(Iarr1, Iarr2));

        System.out.println("Itinerary from Tickets");

        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        while(tickets.containsKey(start)){
            System.out.print(start + " -> " );
            start = tickets.get(start);
        }
        System.out.println(start);


        System.out.println("Subsum array equals to k");
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = {10,2,-2,-20,10};
        int k = -10;

        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        System.out.println(ans);



    }
}
