package java_dsa_basics.hashmap;

import java.util.*;

public class basics {
    public static void main(String[] args) {
        // syntax
        Map<String, Integer> mp = new HashMap<>();
        // adding elements
        mp.put("Akash", 21);
        mp.put("Yash", 16);
        mp.put("Lav", 17);
        mp.put("Rishika", 19);
        mp.put("Harry", 18);
        // getting value of a key from map returns value if key exists else null
        System.out.println(mp.get("Akash"));
        System.out.println(mp.get("Rahul"));
        // Updating value of a key in map
        mp.put("Akash", 22);
        System.out.println(mp.get("Akash"));
        // removing pair from a map
        System.out.println(mp.remove("Akash"));
        System.out.println(mp.remove("Aman"));
        // checking if key exists
        System.out.println(mp.containsKey("Akash"));
        System.out.println(mp.containsKey("Harry"));
        // adding new entry if key doesnt exists already
        mp.putIfAbsent("Aman", 23); // will enter
        mp.putIfAbsent("Yash", 30); // will not enter
        // get all keys in map
        System.out.println(mp.keySet());
        // get all the values in map
        System.out.println(mp.values());
        // get all entries in map
        System.out.println(mp.entrySet());
        // traversing all entries of hashmap- multiple methods
        for (String key : mp.keySet()) {
            System.out.printf("Age of %s is %d\n", key,mp.get(key));
        }

        System.out.println();
        for (Map.Entry<String,Integer> e : mp.entrySet()) {
            System.out.printf("Age of %s is %d\n",e.getKey(),e.getValue());
        }

        System.out.println();
        for (var e : mp.entrySet()) {
            System.out.printf("Age of %s is %d\n",e.getKey(),e.getValue());
        }
    }
}
