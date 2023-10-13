import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Hashing {
    // hashMap Implementation
    // static class HashMap<K,V>{  // generic
    //     private class Node{
    //         K key;
    //         V value;

    //         public Node(K key, V value) {
    //             this.key = key;
    //             this.value = value;
    //         }
    //     }

    //     private int n;  //size
    //     private int N;
    //     private LinkedList<Node> buckets[];  //N  = buckets.length  // Array of LinkedList

    //     @SuppressWarnings("unchecked")
    //     public HashMap() {
    //         this.N = 4;
    //         this.buckets = new LinkedList[4];
    //         for(int i=0;i<4;i++){
    //             this.buckets[i] = new LinkedList<>();
    //         }
    //     }

    //     private int hashFunction(K key) {
    //         int hc = key.hashCode();
    //         return Math.abs(hc) % N;
    //     }

    //     private int SearchInLL(K key , int bi) {
    //         LinkedList<Node> ll = buckets[bi];
    //         int di = 0;

    //         for(int i=0;i<ll.size();i++){
    //             Node node = ll.get(i);
    //             if(node.key == key) {
    //                 return  di;
    //             }
    //             di++;
    //         }
    //         return -1;
    //     }

    //     @SuppressWarnings("unchecked")
    //     private void rehash() {
    //         LinkedList<Node> oldBuck[] = buckets;
    //         buckets = new LinkedList[N*2];
    //         N = 2*N;
    //         for(int i=0;i<buckets.length;i++){
    //             buckets[i] = new LinkedList<>();
    //         }

    //         // nodes -> add in bucket
    //         for(int i=0;i<oldBuck.length;i++){
    //             LinkedList<Node> ll = oldBuck[i];
    //             for(int j=0;j<ll.size();j++){
    //                 Node node = ll.remove();
    //                 put(node.key, node.value);
    //             }
    //         }

    //     }

    //     public void put(K key, V value) {
    //         int bi = hashFunction(key);   // 0 to size-1
    //         int di = SearchInLL(key, bi);  //valid;  //-1

    //         if(di != -1){
    //             Node node = buckets[bi].get(di);
    //             node.value = value;
    //         } else {
    //             buckets[bi].add(new Node(key, value));
    //             n++;
    //         }

    //         double lambda = (double)n/N;
    //         if(lambda > 2.0) {
    //             rehash();
    //         }
    //     }

    //     public boolean containsKey(K key) {
    //         int bi = hashFunction(key);   // 0 to size-1
    //         int di = SearchInLL(key, bi);  //valid;  //-1

    //         if(di != -1){  // valid value
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }

    //     public V remove(K key){
    //         int bi = hashFunction(key);   // 0 to size-1
    //         int di = SearchInLL(key, bi);  //valid;  //-1

    //         if(di != -1){
    //             Node node = buckets[bi].remove(di);
    //             n--;
    //             return node.value;
    //         } else {
    //             return null;
    //         }
    //     }

    //     public V get(K key){
    //         int bi = hashFunction(key);   // 0 to size-1
    //         int di = SearchInLL(key, bi);  //valid;  //-1

    //         if(di != -1){
    //             Node node = buckets[bi].get(di);
    //             return node.value;
    //         } else {
    //             return null;
    //         }
    //     }

    //     public ArrayList<K> keySet() {
    //         ArrayList<K> keys = new ArrayList<>();

    //         for(int i=0;i<buckets.length;i++){
    //             LinkedList<Node> ll = buckets[i];
    //             for(Node node : ll){
    //                 keys.add(node.key);
    //             }
    //         }
    //         return keys;
    //     }

    //     public boolean isEmpty(){
    //         return n == 0;
    //     }






    // Valid Anagram
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                } else{
                    map.put(ch, map.get(ch) - 1);
                }
            } else{
                return false;
            }
        }
        return map.isEmpty();

    }
    



    

    // For Itinerary ticket problem
    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;     // starting point
            }
        }
        return null;
    }




    public static void main(String[] args) {
        // Create
        // HashMap<String, Integer> hm = new HashMap<>();

        // // Insert  - O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);

        // System.out.println(hm);

        // //Get  - O(1
        // int population  = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("Indonesia"));

        // // ContainsKey - O(1)
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Indonesia"));

        // // Remove - O(1)
        // System.out.println(hm.remove("US"));   // returns 50
        // System.out.println(hm);

        // // Size
        // System.out.println(hm.size());

        // // Is Empty
        // System.out.println(hm.isEmpty());

        // Clear - To empty the HashMAp
        // hm.clear();




        // Iteration on HashMap
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);

        // // Iterate
        // // hm.entrySet();
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("key="+k+ ",value="+hm.get(k));
        // }




        // Implementation of a HashMap

        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Nepal", 5);

        // ArrayList<String> keys = hm.keySet();
        // for(String key : keys) {
        //     System.out.println(key);
        // }

        // System.out.println(hm.get("India"));



        // Linked HashMap     // keys are insertion ordered
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 100);
        // lhm.put("China", 150);
        // lhm.put("US", 50);

        // System.out.println(lhm);



        // // TreeMap          // keys are sorted
        // TreeMap<String, Integer> thm = new TreeMap<>();
        // thm.put("India", 100);
        // thm.put("China", 150);
        // thm.put("US", 50);

        // System.out.println(thm);





        // Majority Element
        // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0;i<arr.length;i++){
        //     // if(map.containsKey(arr[i])){
        //     //     map.put(arr[i], map.get(arr[i])+1);
        //     // } else{
        //     //     map.put(arr[i], 1);
        //     // }

        //     //ShortHand
        //     map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        // }
        // for(Integer key : map.keySet()){
        //     if(map.get(key) > arr.length/3){
        //         System.out.println(key);
        //     }
        // }




        // Valid Anagram
        // String s = "keen";
        // String t = "knee";
        // System.out.println(isAnagram(s, t));








        // HashSet
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);

        // System.out.println(set);

        // set.remove(2);

        // if(set.contains(2)){
        //     System.out.println("set contains 2");
        // }

        // System.out.println(set.size());

        // set.clear();

        // System.out.println(set);

        // System.out.println(set.isEmpty());




        // Iterayions on HashSet using Iterators
        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Bengaluru");

        // Iterator it = cities.iterator();   // Iterator 
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // for(String city : cities){             // Advanced for Loop
        //     System.out.println(city);
        // }






        // Linked HashSet
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Noida");
        // lhs.add("Bengaluru");

        // System.out.println(lhs);









        
        // TreeSet
        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Mumbai");
        // ts.add("Noida");
        // ts.add("Bengaluru");

        // System.out.println(ts);








        // Count Distinct Elements
        // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2 ,1};
        // HashSet<Integer> set = new HashSet<>();

        // for(int i=0;i<num.length;i++){
        //     set.add(num[i]);
        // }
        // System.out.println("ans = "+ set.size());







        //Union and Intersetion of 2 Arrays
        // int arr1[] = {7, 3, 9};
        // int arr2[] = {6, 3, 9, 2, 9, 4};

        // HashSet<Integer> set =  new HashSet<>();
        
        // //union
        // for(int i=0;i<arr1.length;i++){
        //     set.add(arr1[i]);
        // }
        // for(int i=0;i<arr2.length;i++){
        //     set.add(arr2[i]);
        // }

        // System.out.println("union = "+ set.size());

        // // itersection
        // set.clear();
        // for(int i=0;i<arr1.length;i++){
        //     set.add(arr1[i]);
        // }

        // int count = 0;
        // for(int i=0;i<arr2.length;i++){
        //     if(set.contains(arr2[i])){
        //     count++;
        //     set.remove(arr2[i]);
        //     }
        // }
        // System.out.println("interection = "+ count);









        // Itinerary from Tickets
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        // String start = getStart(tickets);
        // System.out.print(start);
        // for(String key : tickets.keySet()){
        //     System.out.print(" -> "+ tickets.get(start));
        //     start = tickets.get(start);
        // }
        // System.out.println();










        //Largest SubArray with sum 0
        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        // HashMap<Integer, Integer> map = new HashMap<>();
        // // (sum, index)

        // int sum = 0;
        // int length = 0;

        // for(int j=0;j<arr.length;j++){
        //     sum += arr[j];
        //     if(map.containsKey(sum)){
        //         length = Math.max(length, j-map.get(sum));
        //     } else{
        //         map.put(sum, j);
        //     }
        // }
        // System.out.println("largest subarray with sum as 0 => " + length);














        //Largest SubArray with sum k
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, count)
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];     // sum(j)
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);













    }
}