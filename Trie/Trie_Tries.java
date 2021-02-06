/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trie_Tries {
    
    static final int alphabet_size = 26;
    static Node root;
    
    static class Node{
        
        Node[] children;
        boolean isEnd;
        int count;
        
        public Node()
        {
            children = new Node[alphabet_size];
            isEnd = false;
            count  = 0;
        }
        
    }
    
    private static Node createNode()
    {
        Node node = new Node();
        
        for(int i=0; i<alphabet_size; ++i)
        {
            node.children[i] = null;
        }
        
        return node;
    }
    
    
    private static void insert(Node root, String query)
    {
        int index;
        Node temp = root;
        for(int i=0; i<query.length(); ++i)
        {
            index = query.charAt(i) - 'a';
            if(temp.children[index] == null)
                temp.children[index] = createNode();
            temp = temp.children[index];
            temp.count++;
        }
        temp.isEnd = true;
    }
    
    private static boolean isLeafNode(Node node)
    {
        for(int i=0; i<alphabet_size; ++i)
        {
            if(node.children[i] != null)
                return false;
        }
        return true;
    }
    private static int searchPrefix(Node root, String query)
    {
        int count = 0, index;
        Node temp = root;
        
        for(int i=0; i<query.length(); ++i)
        {
            index = query.charAt(i) - 'a';
            if(temp.children[index] == null) 
                return count;
            temp = temp.children[index];
        }
        
        return temp.count;
        /*if(temp.isEnd)count++;
        if(isLeafNode(temp))
            return count;*/
        //count = prefixCounter(temp, query, count);
        //return count;
    }
    
    private static int prefixCounter(Node node, String query, int count)
    {
        int t = 0;
        if(node.isEnd)count++;
        if(isLeafNode(node))
            return count;
        
        for(int i=0; i<alphabet_size; ++i)
        {
            if(node.children[i] != null)
            {
                count = prefixCounter(node.children[i], query, count);
            }
        }
        
        return count;
    }
    
    public static void main(String[] args){
        int N;
         
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            N = Integer.parseInt(reader.readLine().trim());
            root = createNode();
            String[] tokens1 = {"", ""};
            for(int i=0; i<N; ++i)
            {
                tokens1 = reader.readLine().trim().split(" ");
                if(tokens1[0].compareTo("add") == 0)
                {
                    insert(root, tokens1[1]);
                }
                else
                {
                    System.out.println(searchPrefix(root, tokens1[1]));
                }
            }
        }
        catch(Exception e)
        {
            //
        }
    }
}
