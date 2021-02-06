/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Bin_Nodes_INA_Subtree {
    
    private static int[][] count;
    private static LinkedList<Integer>[] edge; 
    private static String s;
    
    private static void dfs(int ch, int pa)
    {
        int t = s.charAt(ch-1)-'a';
        count[ch][t]++;
        for(int i=0; i<edge[ch].size(); ++i)
        {
            int v = edge[ch].get(i);
            if(v == pa)continue;
            dfs(v, ch);
            
            for(int j=0; j<26; ++j)
            {
                count[ch][j] += count[v][j];
            }
        }
    }
    
    public static void main(String args[] )
    {
        int N, Q, Pa, Ch;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] tokens = reader.readLine().trim().split(" ");
            N = Integer.parseInt(tokens[0]);
            Q = Integer.parseInt(tokens[1]);
            
            count = new int[N+1][26];
            edge = new LinkedList[N+1];
            
            s = reader.readLine().trim();
            String[] tokens1 = {"", ""};
            
            for(int i=0; i<=N; ++i)
            {
                edge[i] = new LinkedList<Integer>();
            }
            
            for(int i=1; i<=N-1; ++i)
            {
                tokens1 = reader.readLine().trim().split(" ");
                Pa = Integer.parseInt(tokens1[0]);
                Ch = Integer.parseInt(tokens1[1]); 
                edge[Pa].add(Ch);
                edge[Ch].add(Pa);
            }
            
            dfs(1, 0);
            
            int id;
            char lo;
            
            for(int i=1; i<=Q; ++i)
            {
                tokens1 = reader.readLine().trim().split(" ");
                id = Integer.parseInt(tokens1[0]);
                lo = tokens1[1].charAt(0);
                System.out.println(count[id][lo-'a']);
            }
            
        }
        catch(Exception e)
        {
            //
        }   
    }
}
