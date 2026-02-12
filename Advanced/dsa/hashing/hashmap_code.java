
import java.util.ArrayList;
import java.util.LinkedList;

public class hashmap_code {

    public class HashMap<k, V> { //generics

        private class Node {

            k key;
            V value;

            public Node(k key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int bi = key.hashCode(); // hashcode of key
            return Math.abs(bi) % N;  //returns value btwn 0 to N-1
        }

        private int searchLL(k key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")

        private void rehashing() {
            LinkedList<Node>[] oldBucket = buckets;
            int oldN = N;
            N = 2 * N; 
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            n = 0; 

            for (int i = 0; i < oldN; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value); 
                }
            }
        }

        public void put(k key, V value) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) { // doesnt exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double) n / N;
            if (lambda >= 2.0) {
                rehashing();
            }

        }

        public boolean containsKey(k key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) { // doesnt exist
                return false;
            } else {
                // Node data = buckets[bi].get(di);
                return true;
            }
        }

        public V get(k key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) { // doesnt exist
                return null;
            } else {
                Node data = buckets[bi].get(di);
                return data.value;
            }
        }

        public V remove(k key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) { // doesnt exist
                return null;
            } else {
                Node data = buckets[bi].remove(di);
                n--;
                return data.value;
            }
        }

        public ArrayList<k> Keyset() {
            ArrayList<k> keys = new ArrayList<>();

            for (int bi = 0; bi < buckets.length; bi++) {
                LinkedList<Node> ll = buckets[bi];
                for (int di = 0; di < ll.size(); di++) {
                    Node node = ll.get(di);
                    keys.add(node.key);
                }

            }
            return keys;

        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        // System.out.println("Program started"); 
        hashmap_code outer = new hashmap_code();
        HashMap<String, Integer> map = outer.new HashMap<>();
        map.put("India", 190);
        map.put("China", 120);
        map.put("Us", 100);

        ArrayList<String> keys = map.Keyset();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

    }
}
