
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hash_map {

    public static void main(String[] args) {
        //Hashmap implementation

        HashMap<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        System.out.println(map);

        String map_key = "one";

        if (map.containsKey(map_key)) {
            System.out.println("Found in Map");
        } else {
            System.out.println("Not found in Map");
        }

        System.out.println("Value of " + map_key + " is " + map.get(map_key));


        System.out.println("Iteration");

        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys){
System.out.println(key + " " + map.get(key));
        }

        System.out.println("Removing a key value pair");
        map.remove("one");
        System.out.println(map);
        System.out.println(map.size());
    }
}
