/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Seg_Tree_Tree_Query {

    static TreeNode root;
    static ArrayList<Integer>[] array;
    static HashMap<Integer, Integer> map;
    
    static class TreeNode
    {
        int val;
        int light;
        int light_on_count;
        TreeNode left, right;
        
        public TreeNode(int node_val) 
        {
            val = node_val;
            light = 1;
            light_on_count = 0;
            left = null;
            right = null;
        }
    }
    
    private static TreeNode createNode(int val)
    {
        TreeNode node = new TreeNode(val);
        return node;
    }
    private static void createTree(TreeNode node)
    {
        int cur = node.val;
        int temp;
        //System.out.println("Parent: " + cur);
        for(int i=0; i<array[cur].size(); ++i)
        {
            temp = array[cur].get(i);
            //System.out.println("Child: " + temp);
            array[temp].remove((Object)cur);
            TreeNode child = createNode(temp);
            if(node.left == null)
                node.left = child;
            else
                node.right = child;
            createTree(child);
        }
    }
    
    private static void inorderTraversal(TreeNode node)
    {
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + " -- ");
        inorderTraversal(node.right);
    }
    
    public static int initialUpdate(TreeNode node)
    {
        if(node == null) return 0;
        int left = initialUpdate(node.left);
        int right = initialUpdate(node.right);
        node.light_on_count = 1 + left + right;
        map.put(node.val, node.light_on_count);
        return node.light_on_count;
    }
    
    private static TreeNode searchAndUpdateTree(TreeNode node, int vertex)
    {
        if(node == null) return null;
        if(node.val == vertex)
        {
            node.light = node.light == 1 ? 0 : 1;
            
            int l = node.left != null ? node.left.light_on_count : 0;
            int r = node.right != null ? node.right.light_on_count : 0;
            node.light_on_count = node.light == 0 ? 0 : (1 + l + r);
            map.replace(node.val, node.light_on_count);
            return node;
        }
        TreeNode left = searchAndUpdateTree(node.left, vertex);
        if(left != null)
        {
            int l = node.left != null ? node.left.light_on_count : 0;
            int r = node.right != null ? node.right.light_on_count : 0;
            node.light_on_count = node.light == 0 ? 0 : (1 + l + r);
            map.replace(node.val, node.light_on_count);
            return left;
        }
        TreeNode right = searchAndUpdateTree(node.right, vertex);
        int l = node.left != null ? node.left.light_on_count : 0;
        int r = node.right != null ? node.right.light_on_count : 0;
        node.light_on_count = node.light == 0 ? 0 : (1 + l + r);
        map.replace(node.val, node.light_on_count);
        return right;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n, q;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            String[] tokens = reader.readLine().trim().split(" ");
            n = Integer.parseInt(tokens[0]);
            q = Integer.parseInt(tokens[1]);
            
            array = new ArrayList[n+1];
            map = new HashMap<>();
            
            for(int i=1; i<=n; ++i)
            {
                array[i] = new ArrayList<>();
            }
            int a, b;
            for(int i=1; i<=n-1; ++i)
            {
                tokens = reader.readLine().trim().split(" ");
                a = Integer.parseInt(tokens[0]);
                b = Integer.parseInt(tokens[1]);
                array[a].add(b);
                array[b].add(a);
            }
            
            root = createNode(1);
            createTree(root);
            
            //inorderTraversal(root);
            
            initialUpdate(root);
            //System.out.println();
            //System.out.println(map.toString());
            
            int qType, vertex;
            for(int i=1; i<=q; ++i)
            {
                tokens = reader.readLine().trim().split(" ");
                qType = Integer.parseInt(tokens[0]);
                vertex = Integer.parseInt(tokens[1]);
                
                if(qType ==  1)
                {
                    searchAndUpdateTree(root, vertex);
                    
                    //System.out.println(map.toString());
                }
                else if(qType == 2)
                {
                    System.out.println(map.get(vertex));
                }
            }
        }
        catch(Exception e)
        {
            //
        }
    }
    
}
