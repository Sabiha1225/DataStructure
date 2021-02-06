/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.Arrays;

/**
 *
 * @author sabiha
 */

public class Suffix_Array {
    
    static int[] suffixArray;
    static class Suffix {
        int index;
        String str;
        
        public Suffix(int ind, String s)
        {
            this.index = ind;
            str = s;
        }
        //
        public static int compare(Suffix a, Suffix b)
        {
            return a.str.compareTo(b.str);
        }
    }
    
    private static void buildSuffixArray(String text)
    {
        Suffix[] allSuffixes = new Suffix[text.length()];
        
        for(int i=0; i<text.length(); ++i)
        {
            allSuffixes[i] = new Suffix(i, text.substring(i));
        }
        Arrays.sort(allSuffixes, Suffix::compare);
        suffixArray = new int[text.length()];
        
        for(int i=0; i<text.length(); ++i)
        {
            suffixArray[i] = allSuffixes[i].index;
        }
    }
    
    private static void searchPattern(String pat, String text)
    {
        int patLen = pat.length();
        int l = 0;
        int r = text.length()-1;
        while(l <= r)
        {
            int mid = (l + r)/2;
            String tempCompStr = text.substring(suffixArray[mid]);
            String compStr = tempCompStr.substring(0, 
                    Math.min(tempCompStr.length(), patLen));
            int res = pat.compareTo(compStr);
            if(res == 0)
            {
                System.out.println(pat + " found at index : " + suffixArray[mid]);
                return;
            }
            else if(res < 0) r = mid-1;
            else l = mid+1;
        }
        
        System.out.println(pat + " not found");
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
        
        searchPattern("nan", str);
        searchPattern("bat", str);
        searchPattern("an", str);
    }
}
