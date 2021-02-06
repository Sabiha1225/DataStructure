/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapSort;

/**
 *
 * @author Administrator
 */
public class HeapSort {
    static int[] arr = {12, 11, 13, 5, 6, 7, 1, 5, 2, 15, 40};
    
    private static int getParent(int i)
    {
        return (int)Math.floor((i-1)*1.0/2);
    }
    
    private static int getLeftChild(int i)
    {
        return 2*i + 1;
    }
    
    private static int getRightChild(int i)
    {
        return 2*i + 2;
    }
    
    private static void heapifyDown(int i, int capacity)
    {
        int largest = i;
        int left = getLeftChild(i);
        int right = getRightChild(i);
        if(left < capacity && arr[left] > arr[largest])
            largest = left;
        if(right < capacity && arr[right] > arr[largest])
            largest = right;
        if(largest != i)
        {
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;
            heapifyDown(largest, capacity);
        }
    }
    
    public static void heapSort(int heapSize, int capacity)
    {
        while(capacity > 1)
        {
            int root = arr[0];
            arr[0] = arr[capacity - 1];
            arr[capacity - 1] = root;
            capacity--;
            heapifyDown(0, capacity);
        }
    }
   
    public static void heapify(int heapSize)
    {
        int start = getParent(heapSize - 1);
        while(start >= 0)
        {
            heapifyDown(start, heapSize);
            start--;
        }
    }
    
    public static void printArray()
    {
        for(int i=0; i<arr.length; ++i)
        {
            System.out.print(arr[i] + "  ");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        int heapSize = arr.length;
        //int capacity = heapSize;
        printArray();
        
        heapify(heapSize);
        heapSort(heapSize, heapSize);
        printArray();
    }
    
}
