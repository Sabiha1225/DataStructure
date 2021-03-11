
package com.mycompany.disjointset;

/**
 *
 * Rank, Path Compression
 */
public class DisJointSetTreeFaster {
    class node {
        int parent;
        int rank;
        public node(int p)
        {
            parent = p;
            rank = 0;
        }
    }
    
    private int root(node arr[], int a)
    {
        if(arr[a].parent == a) return a;
        return arr[a].parent = root(arr, arr[a].parent);  //Path compression
        /*while(arr[a].parent != a)
        {
            a = arr[a].parent;
        }
        return a;*/
    }
    
    private boolean find(node arr[], int a, int b)
    {
        if(root(arr, a) == root(arr, b)) return true;
        else return false;
    }
    
    private void union(node arr[], int a, int b)
    {
        int rootA = root(arr, a);
        int rootB = root(arr, b);
        
        //Union By Rank
        if(arr[rootA].rank > arr[rootB].rank)
        {
            arr[rootB].parent = rootA;
        }
        else if(arr[rootA].rank < arr[rootB].rank)
        {
            arr[rootA].parent = rootB;
        }
        else
        {
            arr[rootA].parent = rootB;
            arr[rootB].rank++;
        }
        //arr[rootA].parent = rootB;
    }
    
    private node[] initialize(int N)
    {
        node[] arr = new node[N];
        for(int i=0; i<N; ++i)
        {
            arr[i] = new node(i);
        }
        return arr;
    }
    
     public static void main(String[] args)
    {
        DisJointSetTreeFaster dsa = new DisJointSetTreeFaster();
        node[] arr = dsa.initialize(10);
        
        System.out.println("1, 2 " + dsa.find(arr, 1, 2));
        dsa.union(arr, 5, 6);
        dsa.union(arr, 1, 2);
        System.out.println("5, 6 " + dsa.find(arr, 5, 6));
        System.out.println("1, 2 " + dsa.find(arr, 1, 2));
        
        dsa.union(arr, 3, 4);
        System.out.println("3, 8 " + dsa.find(arr, 3, 8));
        dsa.union(arr, 4, 8);
        System.out.println("3, 8 " + dsa.find(arr, 3, 8));
    }
}
