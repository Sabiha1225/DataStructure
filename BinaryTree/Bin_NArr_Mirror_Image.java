package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Bin_NArr_Mirror_Image {
    
    static TreeNode root, mirrorRoot;
    static HashMap<Integer, Integer> map;
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int d)
        {
            data = d;
            left = right = null;
        }
    }
    
    private static TreeNode createNode(int d)
    {
        TreeNode node = new TreeNode(d);
        return node;
    }
    private static TreeNode searchTree(TreeNode node, int d)
    {
        if(node == null) return null;
        if(node.data == d)
            return node;
        TreeNode left = searchTree(node.left, d);
        if(left != null)
            return left;
        TreeNode right = searchTree(node.right, d);
        return right;
    }
    private static void insertNode(int p, int c, char dir)
    {
        TreeNode temp = searchTree(root, p);
        if(temp != null)
        {
            TreeNode node = createNode(c);
            if(dir == 'L')
                temp.left = node;
            else
                temp.right = node;
        }
    }
    private static void inorderTraversal(TreeNode node)
    {
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " -- ");
        inorderTraversal(node.right);
    }
    private static void preorderTraversal(TreeNode node)
    {
        if(node == null) return;
        System.out.print(node.data + " -- ");
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }
    private static void postorderTraversal(TreeNode node)
    {
        if(node == null) return;
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.print(node.data + " -- ");
    }
    
    private static TreeNode mirrorify(TreeNode node)
    {
        if(node == null) return null;
        TreeNode mirror = createNode(node.data);
        mirror.left = mirrorify(node.right);
        mirror.right = mirrorify(node.left);
        return mirror;
    }
    
    private static TreeNode mirrorifyItself(TreeNode node)
    {
        if(node == null)return node;
        TreeNode left = mirrorifyItself(node.left);
        TreeNode right = mirrorifyItself(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
    
    private static void findMirrorOfEachNode(int point, TreeNode node, TreeNode mirrorNode)
    {
        if(point == 1)
        {
            map.put(node.data, mirrorNode.data);
            point++;
            findMirrorOfEachNode(point, node.left, mirrorNode.left);
        }
        else
        {  
            if(node != null && mirrorNode != null)
            {
                map.put(node.data, mirrorNode.data);
                map.put(mirrorNode.data, node.data);
                point++;
                findMirrorOfEachNode(point, node.left, mirrorNode.left);
                findMirrorOfEachNode(point, node.right, mirrorNode.right);
            }
            else if(node != null && mirrorNode == null)
            {
                map.put(node.data, -1);
                point++;
                findMirrorOfEachNode(point, node.left, null);
                findMirrorOfEachNode(point, node.right, null);
            }
            else if(node == null && mirrorNode != null)
            {
                map.put(mirrorNode.data, -1);
                point++;
                findMirrorOfEachNode(point, null, mirrorNode.left);
                findMirrorOfEachNode(point, null, mirrorNode.right);
            }
            else return;
        }
    }
    
    public static void main(String args[] )
    {
        int N, Q, Pa, Ch;
        char dir;
        map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] tokens = reader.readLine().trim().split(" ");
            N = Integer.parseInt(tokens[0]);
            Q = Integer.parseInt(tokens[1]);
            
            root = createNode(1);
            
            String[] tokens1 = {"", "", ""};
            
            for(int i=1; i<=N-1; ++i)
            {
                tokens1 = reader.readLine().trim().split(" ");
                Pa = Integer.parseInt(tokens1[0]);
                Ch = Integer.parseInt(tokens1[1]);
                dir = tokens1[2].charAt(0);
                insertNode(Pa, Ch, dir);
            }
            
            //inorderTraversal(root);
            //System.out.println();
            mirrorRoot = mirrorify(root);
            //inorderTraversal(mirrorRoot);
            //System.out.println();
            findMirrorOfEachNode(1, root, mirrorRoot);
            
            int t;
            for(int i=1; i<=Q; ++i)
            {
                t = Integer.parseInt(reader.readLine());
                System.out.println(map.get(t));
            }
            /*for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                System.out.println(entry.getKey() + " : " +entry.getValue());
            }*/
            //root = mirrorifyItself(root);
            //inorderTraversal(root);
            
        }
        catch(Exception e)
        {
            //
        }   
    }
}
