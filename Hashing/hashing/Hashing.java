/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 *
 * @author Administrator
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createSynchronizedHashTable();
        
        createAsynchronizedHashMap();
        
        createLinkedHashMap();
        
        createConcurrentHashMap();
        
        createHashSet();
        
        createLinkedHashSet();
    }
    
    //With help of HashTable (A synchronized implementation of hashing)
    public static void createSynchronizedHashTable()
    {
        Hashtable<Integer, String> hm = new Hashtable<>();
        hm.put(1, "Counting Star");
        hm.put(12, "Hym");
        hm.put(15, "Girls");
        hm.put(4, "Back to the window");
        hm.put(4, "Perfect");
        
        System.out.println(hm);
    }
    
    //With the help of HashMap (A non-synchronized faster implementation of hashing)
    // Java program to create HashMap from an array 
    // by taking the elements as Keys and 
    // the frequencies as the Values 
    public static void createAsynchronizedHashMap()
    {
        int arr[] = {10, 34, 5, 10, 3, 5, 10, 1};
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<arr.length; ++i)
        {
            if(hm.get(arr[i]) == null)
            {
                hm.put(arr[i], 1);
            }
            else
            {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }
        
        System.out.println(hm);
        hm.remove(1);
        
        printHashMap(hm);
    }
    
    private static void printHashMap(HashMap<Integer, Integer> map)
    {
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " : " +entry.getValue());
        }
        
        for(int i: map.keySet())
        {
            System.out.println("Key : " + i);
        }
        
        for(int i: map.values())
        {
            System.out.println("Value : " + i);
        }
        
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer, Integer> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue()); 
        }
        
        for(int i: map.keySet())
        {
            //Searching for value
            System.out.println("Key : " + i + " Value : " + map.get(i));
        }
        
        map.forEach((k,v) -> System.out.println("Key = " + k + " , Value = " + v));
    }
    
    //With the help of LinkedHashMap (Similar to HashMap, but keeps order of elements)
    public  static void createLinkedHashMap()
    {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("one", "Counting Star");
        lhm.put("two", "Hym");
        lhm.put("three", "Girls");
        lhm.put("four", "Back to the window");
        lhm.put("one", "Delicate");
        
        System.out.println(lhm);
    }
    
    //With the help of ConcurretHashMap(Similar to Hashtable, Synchronized, but faster as multiple locks are used)
    public static void createConcurrentHashMap()
    {
        ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
        chm.put(1, "Counting Star");
        chm.put(12, "Hym");
        chm.put(15, "Girls");
        chm.put(4, "Back to the window");
        chm.put(4, "Perfect");
        
        System.out.println(chm);
        
        //chm.replace(15, "Girl", "Passenger");
        chm.replace(15, "Girls", "Passenger");
        
        System.out.println(chm);
    }
    
    //With the help of HashSet (Similar to HashMap, but maintains only keys, not pair)
    public  static void createHashSet()
    {
        HashSet<String> hs = new HashSet<>();
        hs.add("one");
        hs.add("two");
        hs.add("three");
        hs.add("four");
        hs.add("one");
        System.out.println("-------------If hashset contains \"one\" "+hs.contains("one") +"---------------");
        
        System.out.println(hs);
        
        Iterator<String> it = hs.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    //With the help of LinkedHashSet (Similar to LinkedHashMap, but maintains only keys, not pair)
    public  static void createLinkedHashSet()
    {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("one");
        lhs.add("two");
        lhs.add("three");
        lhs.add("four");
        lhs.add("one");
        
        System.out.println(lhs);
    }
}
