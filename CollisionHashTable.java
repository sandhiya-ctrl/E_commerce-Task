
import java.util.*;

public class CollisionHashTable {

    
    static class HashTable {
        java.util.LinkedList<String>[] table;
        int size = 10;

        @SuppressWarnings("unchecked")
        HashTable() {
            table = (java.util.LinkedList<String>[]) new java.util.LinkedList[size];

            for (int i = 0; i < size; i++) {
                table[i] = new java.util.LinkedList<>();
            }
        }

        int hash(String key) {
            return Math.floorMod(key.hashCode(), size);
        }

        void insert(String key) {
            int index = hash(key);
            table[index].add(key);
        }

        boolean search(String key) {
            int index = hash(key);
            return table[index].contains(key);
        }
    }

    public static void main(String[] args) {

        HashTable ht = new HashTable();

        ht.insert("SKU101");
        ht.insert("SKU111");

        System.out.println("Chaining Hash Table:");
        System.out.println("SKU101 found: " + ht.search("SKU101"));
        System.out.println("SKU111 found: " + ht.search("SKU111"));

        
        ht.insert("SKU121");

        System.out.println("Collision demonstration:");
        System.out.println("SKU101 and SKU111 may map to the same bucket.");

     
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 100000; i++) {
            map.put("SKU" + i, i);
        }

        String target = "SKU99999";

        long start = System.nanoTime();
        map.get(target);
        long end = System.nanoTime();

        System.out.println("HashMap lookup time: "
                + (end - start) + " nanoseconds");

        System.out.println("SKU99999 value: " + map.get(target));
    }
}
