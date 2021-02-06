/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.Arrays;

/**
 *
 * @author sabiha O(n * logn * logn)
 */
public class Suffix_Array_Faster {
    static int[] suffixArray;
    static class Suffix implements Comparable<Suffix>{
        int index;
        int rank;
        int next;
        
        public Suffix(int ind, int r, int n)
        {
            this.index = ind;
            this.rank = r;
            this.next = n;
        }

        @Override
        public int compareTo(Suffix o) {
            if(rank != o.rank) return Integer.compare(rank, o.rank);
            return Integer.compare(next, o.next);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private static void buildSuffixArray(String text)
    {
        int n = text.length();
        Suffix[] allSuffixes = new Suffix[n];
        
        for(int i=0; i<n; ++i)
        {
            allSuffixes[i] = new Suffix(i, text.charAt(i) - 'a', 0);
        }
        
        for(int i=0; i<n; ++i)
        {
            allSuffixes[i].next = i+1 < n ? allSuffixes[i+1].rank : -1;
        }
        
        for(int i=0; i<n; ++i)
            {
                System.out.println("Index: " + allSuffixes[i].index +
                        "  rank: " + allSuffixes[i].rank + "   next: " + allSuffixes[i].next);
            }
            
            System.out.println("----------");
        
        Arrays.sort(allSuffixes);
        
        int[] indices = new int[n];
        int prevRank = 0;
        for(int compLength = 4; compLength<2*n; compLength<<=1)
        {
            indices[allSuffixes[0].index] = 0;
            prevRank = allSuffixes[0].rank;
            allSuffixes[0].rank = 0;
            for(int i=1; i<n; ++i)
            {
                if(allSuffixes[i].rank == prevRank && 
                        allSuffixes[i].next == allSuffixes[i-1].next)
                {
                    prevRank = allSuffixes[i].rank;
                    allSuffixes[i].rank = allSuffixes[i-1].rank;
                }
                else
                {
                    prevRank = allSuffixes[i].rank;
                    allSuffixes[i].rank = allSuffixes[i-1].rank + 1;
                }
                
                indices[allSuffixes[i].index] = i;
            }
            
            
            for(int i=0; i<n; ++i)
            {
                int nextInd = allSuffixes[i].index + compLength/2;
                allSuffixes[i].next = nextInd < n ? allSuffixes[indices[nextInd]].rank : -1;
            }
            
            for(int i=0; i<n; ++i)
            {
                System.out.println("Index: " + allSuffixes[i].index +
                        "  rank: " + allSuffixes[i].rank + "   next: " + allSuffixes[i].next);
            }
            
            System.out.println("--- After Sort-------");
            
            Arrays.sort(allSuffixes);
            
            for(int i=0; i<n; ++i)
            {
                System.out.println("Index: " + allSuffixes[i].index +
                        "  rank: " + allSuffixes[i].rank + "   next: " + allSuffixes[i].next);
            }
            
            System.out.println("----------");
        }
        
        suffixArray = new int[n];
        
        for(int i=0; i<n; ++i)
        {
            suffixArray[i] = allSuffixes[i].index;
        }
    }
    
    private static void printArray(int n)
    {
        for(int i=0; i<n; ++i)
        {
            System.out.println(suffixArray[i]);
        }
    }
    
    public static void main(String[] args)
    {
        String str = "banana";
        buildSuffixArray(str.toLowerCase());
        printArray(str.length());
        
        //searchPattern("nan", str);
        //searchPattern("bat", str);
        //searchPattern("an", str);
    }
}
