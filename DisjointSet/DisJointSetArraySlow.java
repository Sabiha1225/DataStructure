
package com.mycompany.disjointset;

public class DisJointSetArraySlow {
    
    private boolean find(int arr[], int a, int b)
    {
        if(arr[a] == arr[b]) return true;
        else return false;
    }
    
    private void union(int arr[], int a, int b)
    {
        int temp = arr[a];
        for(int i=0; i<arr.length; ++i)
        {
            if(arr[i] == temp)
            {
                arr[i] = arr[b];
            }
        }
    }
    
    private int[] initialize(int N)
    {
        int[] arr = new int[N];
        for(int i=0; i<N; ++i)
        {
            arr[i] = i;
        }
        return arr;
    }
    
    public static void main(String[] args)
    {
        DisJointSetArraySlow dsa = new DisJointSetArraySlow();
        int[] arr = dsa.initialize(10);
        
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
