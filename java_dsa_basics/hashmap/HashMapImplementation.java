package java_dsa_basics.hashmap;

import java.util.LinkedList;

public class HashMapImplementation {

    static class MyHashMap<K,V>{
        public static int DEFAULT_CAPACITY = 4;
        public static float LOAD_FACTOR = 0.75f;
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // umber of entries in map
        private LinkedList<Node>[] buckets;

        private void initBuckets(int N){ // N-capacity/size of buckets array
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int HashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        // traverses the ll and looks for a node with key, if found it returns its index else -1
        private int searchInBucket(LinkedList<Node> currList, K key){
            for (int i = 0; i < currList.size(); i++) {
                if(currList.get(i).key == key) return i;
            }
            return -1;
        }

        public int capacity(){
            return buckets.length;
        }

        public float loadFactor(){
            return LOAD_FACTOR;
        }

        private void reHash(){
            LinkedList<Node>[] oldBucket = buckets;
            initBuckets(oldBucket.length * 2);
            n = 0;
            for (var bucket : oldBucket) {
                for (var node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }
        public MyHashMap(int CAPACITY, float LOAD_FACTOR){
            this.DEFAULT_CAPACITY = CAPACITY;
            this.LOAD_FACTOR = LOAD_FACTOR;
            initBuckets(CAPACITY);
        }

        public int size(){ // returns number of entries in map
            return n;
        }

        public void put(K key, V value){ //to insert/update into map
            int bi = HashFunction(key);
            LinkedList<Node> currList = buckets[bi];
            int ei = searchInBucket(currList, key);
            if(ei == -1){ //key not found add new node
                Node node = new Node(key, value);
                currList.add(node);
                n++;
            } else { // update case
                Node curNode = currList.get(ei);
                curNode.value = value;
            }
            if(n >= buckets.length * LOAD_FACTOR){
                reHash();
            }
        }

        public V get(K key){ // return value if key exists else null
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei == -1) return null;
            Node curNode = currBucket.get(ei);
            return curNode.value;
        }

        public V remove(K key){ // return value if key exists else null
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei == -1) return null;
            Node curNode = currBucket.get(ei);
            V value = curNode.value;
            currBucket.remove(ei);
            n--;
            return value;
        }

        public boolean containsKey(K key){
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei == -1) return false;
            return true;
        }

        public void keySet(){
            System.out.print("[");
            LinkedList<Node>[] Bucket = buckets;
            for (var bucket : Bucket) {
                for (var node : bucket) {
                    System.out.print(node.key+" ");
                }
            }
            System.out.print("]");
            System.out.println();
        }

        public void values(){
            LinkedList<Node>[] Bucket = buckets;
            System.out.print("[");
            for (var bucket : Bucket) {
                for (var node : bucket) {
                    System.out.print(node.value+" ");
                }
            }
            System.out.print("]");
            System.out.println();
        }

        public void entrySet(){
            System.out.print("{");
            for (var bucket : buckets) {
                for (var node : bucket) {
                    System.out.print(node.key+"="+node.value+",");
                }
            }
            System.out.print("}");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>(5,0.6f);
        System.out.println("Testing put");
        mp.put("a", 1);
        mp.put("b", 2);
        System.out.println("CAPACITY: " +mp.capacity());
        System.out.println("LOAD: "+mp.loadFactor());
        mp.put("d", 4);
        mp.put("x", 31);
        mp.put("y", 69);
        System.out.println("Testing size "+mp.size()); //3
        mp.put("d", 40);
        System.out.println("Testing size "+mp.size()); //3

        System.out.println("Testing get");
        System.out.println(mp.get("x")); //1
        System.out.println(mp.get("y")); //2
        System.out.println(mp.get("c")); //null
        System.out.println(mp.get("d")); //40

        System.out.println("Testing remove");
        System.out.println(mp.remove("d")); //40
        System.out.println(mp.remove("d")); //null
        System.out.println(mp.size()); //2

        System.out.println("Testing Containskey");
        System.out.println(mp.containsKey("x")); //true
        System.out.println(mp.containsKey("anan")); //false

        System.out.println("Testing keysets");
        mp.keySet();
        System.out.println("Testing values");
        mp.values();
        System.out.println("Testing entrySet");
        mp.entrySet();

        System.out.println("CAPACITY: " +mp.capacity());
        System.out.println("LOAD: "+mp.loadFactor());

    }
}
