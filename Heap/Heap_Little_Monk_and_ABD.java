/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class Heap_Little_Monk_and_ABD {
    static long[] array;
    
    private static void buildHeap(int N)
    {
        for(int i=N/2; i>=1; --i)
        {
            maxHeapify(N, i);
        }
    }
    
    private static void maxHeapify(int N, int index)
    {
        int largest = index;
        int left =  index*2;
        int right = index*2 + 1;
        if(left<= N && array[left] > array[largest])
            largest = left;
        if(right<= N && array[right] > array[largest])
            largest = right;
        if(largest != index)
        {
            swap(index, largest);
            maxHeapify(N, largest);
        }
    }
    
    private static void heapSort(int N)
    {
        int heapSize =  N;
        buildHeap(N);
        for(int i=N; i>1; --i)
        {
            swap(1, i);
            heapSize--;
            maxHeapify(heapSize, 1);
        }
    }
    
    private static void swap(int t1, int t2)
    {
        long t = array[t1];
        array[t1] = array[t2];
        array[t2] = t;
    }
    
    public static void main(String args[] )
    {
        int N, Q, K;
        char c;
         
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            N = Integer.parseInt(reader.readLine().trim());
            
            array = new long[N+1];
            
            String[] tokens1 = reader.readLine().trim().split(" ");
            
            for(int i=0; i<tokens1.length; ++i)
            {
                array[i+1] = Long.parseLong(tokens1[i]);
            }
            
            heapSort(N);
            
            Q = Integer.parseInt(reader.readLine().trim());
            String[] tokens2 = {"", ""};
            for(int i=0; i<Q; ++i)
            {
                tokens2 = reader.readLine().trim().split(" ");
                K = Integer.parseInt(tokens2[0]);
                c = tokens2[1].charAt(0);
                if(c=='S')
                    System.out.println(array[K]);
                else
                    System.out.println(array[N-K+1]);
            }
        }
        catch(Exception e)
        {
            //
        }
    }
}
