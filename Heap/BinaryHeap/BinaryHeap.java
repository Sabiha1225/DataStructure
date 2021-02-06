/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryHeap;

import static java.lang.Math.floor;

/**
 *
 * @author Administrator
 */

public class BinaryHeap {
    int heapSize;
    int[] array;
    int tail;
    
    public BinaryHeap(int size)
    {
        heapSize = size;
        array = new int[heapSize];
        tail = 0;
    }
    
    private int getParent(int i)
    {
        return (i-1)/2;
    }
    
    private int getLeftChild(int i)
    {
        return 2*i + 1;
    }
    
    private int getRightChild(int i)
    {
        return 2*i + 2;
    }
    
    //MinHeap Construction
    private void heapifyUp(int i)
    {
        int pIndex = getParent(i);
        if(i>0 && array[i] < array[pIndex])
        {
            int t = array[i];
            array[i] = array[pIndex];
            array[pIndex] = t;
            heapifyUp(pIndex);
        }
    }
    
    public void insert(int val)
    {
        if(tail == heapSize)
        {
            System.out.println("Array overflowed for " + val);
            return;
        }
        array[tail] = val;
        heapifyUp(tail);
        tail++;
    }
    
    public void decreaseKey(int i, int newValue)
    {
        array[i] = newValue;
        heapifyUp(i);
    }
    
    public void delete(int i)
    {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
    
    private void heapifyDown(int i)
    {
        int smallest = i;
        int left = getLeftChild(i);
        int right = getRightChild(i);
        if(left<tail && array[left] < array[smallest])
            smallest = left;
        if(right < tail && array[right] < array[smallest])
            smallest = right;
        if(smallest != i)
        {
            int t = array[i];
            array[i] = array[smallest];
            array[smallest] = t;
            heapifyDown(smallest);
        }
    }
    
    public int extractMin()
    {
        if(tail < 0) return -1;
        else if(tail == 0) return array[0];
        else
        {
            tail--;
            int root = array[0];
            array[0] = array[tail];
            array[tail] = root;
            heapifyDown(0);
            return root;
        }
    }
    
    public int getMin()
    {
        return array[0];
    }
    
    public static void main(String[] args)
    {
        BinaryHeap bHeap = new BinaryHeap(5);
        bHeap.insert(11);
        bHeap.insert(3);
        bHeap.insert(2);
        bHeap.insert(1);
        bHeap.insert(1);
        bHeap.insert(5);
        
        System.out.println("Extracting Min: " + bHeap.extractMin());
        System.out.println("Getting Min: " + bHeap.getMin());
        
        bHeap.insert(5);
        bHeap.insert(4);
        
        System.out.println("Extracting Min: " + bHeap.extractMin());
        System.out.println("Getting Min: " + bHeap.getMin());
        
        System.out.println("Extracting Min: " + bHeap.extractMin());
        System.out.println("Getting Min: " + bHeap.getMin());
        
        bHeap.delete(1);
        System.out.println("Getting Min: " + bHeap.getMin());
        
        bHeap.insert(5);
        bHeap.insert(2);
    }
}
