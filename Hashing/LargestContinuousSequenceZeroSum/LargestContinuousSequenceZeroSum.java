/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LargestContinuousSequenceZeroSum;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-2);
        list.add(4);
        list.add(-4);
        System.out.println(lszero(list).toString());
    }
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int[] sum = new int[A.size()];
        sum[0] = A.get(0);
        int maxInitIndex = 0, maxLastIndex = 0;
        for(int i=1; i<A.size(); ++i)
        {
            sum[i] = sum[i-1] + A.get(i);
            if(sum[i] == 0)
                maxLastIndex = i;
        }
        
        for(int i=0; i<sum.length; ++i)
        {
            if(map.containsKey(sum[i]))
            {
                map.get(sum[i]).lastIndex = i;
            }
            else
            {
                Node node = new Node(i+1, i);
                map.put(sum[i], node);
            }
            
            if((maxLastIndex - maxInitIndex + 1) < (map.get(sum[i]).lastIndex - map.get(sum[i]).initIndex +1))
            {
                maxLastIndex = map.get(sum[i]).lastIndex;
                maxInitIndex = map.get(sum[i]).initIndex;
            }
        }
        for(int i=maxInitIndex; i<=maxLastIndex; ++i)
        {
            result.add(A.get(i));
        }
        return result;
    }
    
    static class Node{
        int initIndex, lastIndex;
        
        public Node(int i, int j)
        {
            initIndex = i;
            lastIndex = j;
        }
    }
}
