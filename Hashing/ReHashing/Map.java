/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReHashing;

/**
 *
 * @author Administrator
 */

import java.util.ArrayList;

public class Map<K, V> {
    class MapNode<K,V> {
        K key;
        V value;
        MapNode<K, V> next;
        
        public MapNode(K ky, V val)
        {
            key = ky;
            value = val;
            next = null;
        } 
    }
    
    // The bucket array where 
    // the nodes containing K-V pairs are stored 
    ArrayList<MapNode<K, V>> buckets;
        
    // No. of pairs stored - n 
    int size; 
  
    // Size of the bucketArray - b 
    int numBuckets; 

    // Default loadFactor 
    final double DEFAULT_LOAD_FACTOR = 0.75;
    
    public Map()
    {
        numBuckets = 5;
        buckets = new ArrayList<>(numBuckets);
        
        for(int i=0; i<numBuckets; ++i)
        {
            // Initialising to null
            buckets.add(null);
        }
        
        System.out.println("HashMap created"); 
        System.out.println("Number of pairs in the Map: " + size); 
        System.out.println("Size of Map: " + numBuckets); 
        System.out.println("Default Load Factor : " + DEFAULT_LOAD_FACTOR + "\n"); 
    }
    
    private int getBucketIndex(K key)
    {
        // Using the inbuilt function from the object class 
        int index = key.hashCode();
        // array index = hashCode%numBuckets
        return index%numBuckets;
    }
    
    public void insert(K key, V value)
    {
        // Getting the index at which it needs to be inserted
        int bucketIndex = getBucketIndex(key);
        // The first node at that index 
        MapNode<K, V> head = buckets.get(bucketIndex);
        // First, loop through all the nodes present at that index 
        // to check if the key already exists 
        while(head != null)
        {
            // If already present the value is updated
            if(head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        // new node with the K and V
        MapNode<K, V> newNode = new MapNode<>(key, value);
        // The head node at the index
        head = buckets.get(bucketIndex);
        // the new node is inserted 
        // by making it the head 
        // and it's next is the previous head 
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        
        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n"); 
        // Incrementing size 
        // as new K-V pair is added to the map 
        size++; 
  
        // Load factor calculated 
        double loadFactor = (1.0 * size) / numBuckets; 
  
        System.out.println("Current Load factor = " + loadFactor); 
  
        // If the load factor is > 0.75, rehashing is done 
        if (loadFactor > DEFAULT_LOAD_FACTOR) { 
            System.out.println(loadFactor + " is greater than " + DEFAULT_LOAD_FACTOR); 
            System.out.println("Therefore Rehashing will be done.\n"); 
  
            // Rehash 
            rehash(); 
  
            System.out.println("New Size of Map: " + numBuckets + "\n"); 
        } 
  
        System.out.println("Number of pairs in the Map: " + size); 
        System.out.println("Size of Map: " + numBuckets + "\n"); 
        
    }
    
    private void rehash()
    {
        System.out.println("\n***Rehashing Started***\n"); 
  
        // The present bucket list is made temp 
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>(2 * numBuckets);
        
        for (int i = 0; i < 2 * numBuckets; i++) { 
            // Initialised to null 
            buckets.add(null); 
        } 
        // Now size is made zero 
        // and we loop through all the nodes in the original bucket list(temp) 
        // and insert it into the new list 
        size = 0; 
        numBuckets *= 2; 
        
        for (int i = 0; i < temp.size(); i++) { 
  
            // head of the chain at that index 
            MapNode<K, V> head =  temp.get(i);
            while(head != null)
            {
                insert(head.key, head.value);
                head = head.next;
            }
        }
        
        System.out.println("\n***Rehashing Ended***\n"); 
        temp = null;
        System.gc();
    }
    
    public void printMap() 
    { 
  
        System.out.println("Current HashMap:"); 
        // loop through all the nodes and print them 
        for (int i = 0; i < buckets.size(); i++) { 
  
            // head of the chain at that index 
            MapNode<K, V> head = buckets.get(i); 
  
            while (head != null) { 
                System.out.printf("key = " + head.key + ", val = " + head.value + " ---- "); 
                head = head.next; 
            } 
            System.out.println();
            System.out.println("****************");
        } 
        System.out.println(); 
    } 
}
