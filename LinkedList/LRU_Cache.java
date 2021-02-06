/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

/**
 *
 * @author Administrator
 */
public class LRU_Cache {
    
    Node root;
    int maxSize;
    int present;
    
    static class Node {
        int key;
        int value;
        Node next;
        
        public Node(int k, int v)
        {
            key = k;
            value = v;
            next = null;
        }
    }
    
    public LRU_Cache(int capacity)
    {
        maxSize = capacity;
        root = null;
        present = 0;
    }
    
    public int get(int key)
    {
        Node temp = root;
        Node prev = null;
        while(temp != null)
        {
            if(temp.key == key)
            {
                if(prev != null)
                {
                    prev.next = temp.next;
                    temp.next = root;
                    root = temp;
                }
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        return -1;
    }
    
    private boolean found(int key, int value)
    {
        Node temp = root;
        Node prev = null;
        while(temp!=null)
        {
            if(temp.key == key)
            {
                temp.value = value;
                if(prev != null)
                {
                    prev.next = temp;
                    temp.next = root;
                    root = temp;
                }
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }
    
    private void insert(int key, int value)
    {
        Node newComer = new Node(key, value);
        if(root == null)
        {
            root = newComer;
            present++;
        }
        else
        {
            Node temp = root;
            Node prev = null;
            while(temp.next != null)
            {
                prev = temp; 
                temp = temp.next;
            }
            
            if(present == maxSize)
            {
                if(prev != null)
                {
                    prev.next = null;
                    newComer.next = root;
                    root = newComer;
                }
                else
                    root = newComer;
                temp = null;
            }
            else
            {
                //temp.next = newComer;
                newComer.next = root;
                root = newComer;
                present++;
            }
        }
    }
    
    public void set(int key, int value) {
        boolean find = found(key, value);
        if(!find)
            insert(key, value);
    }
    
    public static void main(String[] args){
        
        LRU_Cache cache = new LRU_Cache(2);
        
        System.out.println(cache.get(2));
        cache.set(2, 6);
        System.out.println(cache.get(1));
        cache.set(1, 5);
        cache.set(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
