/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;
    public ListNode(int d)
    {
        data = d;
        next = null;
    }
}

public class Reversed_Linked_List {
    ListNode front = null, tail = null;
    ListNode nextNode = null, frontEven =  null, tailEven = null;
    
    void insertNode(int d)
    {
        ListNode temp = new ListNode(d);
        if(front ==  null)
        {
            front = tail = temp;
        }
        else
        {
            tail.next = temp;
            tail = temp;
        }
    }
    
    void reverseEvenIntegers()
    {
        nextNode = front;
        int counter = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(nextNode != null)
        {
            if(nextNode.data % 2 == 0)
            {
                //System.out.println(nextNode.data);
                counter++;
                stack.push(nextNode.data);
                if(frontEven == null)
                {
                    frontEven = nextNode;
                }
                if((nextNode.next != null && nextNode.next.data % 2 != 0) || nextNode.next == null)
                {
                    tailEven = nextNode;
                    
                    while(!stack.empty())
                    {
                        frontEven.data = (int) stack.pop();
                        frontEven = frontEven.next;
                    }
                    
                    frontEven = tailEven = null;
                }
            }
            nextNode = nextNode.next;
        }
    }
    
    void print()
    {
        ListNode temp = front;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
        System.out.println();
    }
    
    public static void main(String args[] )
    {
        int N;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        s.nextLine();
        Reversed_Linked_List list = new Reversed_Linked_List();
        for(int i=0; i<N; ++i)
        {
            int temp = s.nextInt();
            list.insertNode(temp);
        }
        s.nextLine();
        //list.print();
        list.reverseEvenIntegers();
        list.print();
    }
}
