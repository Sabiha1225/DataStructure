/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

class PNode{
    int data;
    int priority;
    PNode next;
    public PNode(int d, int p)
    {
        data = d;
        priority = p;
        next = null;
    }
}

public class Priority_Que_Linked_List {
    
    PNode head = null;
    int totalCount = 0;
    public void enQueue(int d, int p)
    {
        PNode temp = new PNode(d, p);
        totalCount++;
        if(head == null)
            head = temp;
        else
        {
            if(temp.priority > head.priority)
            {
                temp.next = head;
                head = temp;
            }
            else
            {
                PNode t = head;
                while(t.next != null && t.next.priority > temp.priority)
                {
                    t = t.next;
                }
                temp.next = t.next;
                t.next = temp;
            }
        }
    }
    
    public int peek()
    {
        return head.data;
    }
    
    public int deQueue()
    {
        if(totalCount == 0) return -1;
        totalCount--;
        PNode temp = head;
        head = head.next;
        int data = temp.data;
        temp = null;
        return data;
    }
    
    public boolean isEmpty()
    {
        return totalCount == 0 ? true : false;
    }
    
    public int size()
    {
        return totalCount;
    }
    
    public String toString()
    {
        PNode temp = head;
        String s = "";
        while(temp != null)
        {
            s = s + " [ " + temp.data + " -- " + temp.priority + " ] ";
            temp = temp.next;
        }
        return s;
    }
    
    public static void main(String args[] )
    {
        Priority_Que_Linked_List pql = new Priority_Que_Linked_List();
        pql.enQueue(5, 5);
        pql.enQueue(7, 7);
        pql.enQueue(1, 1);
        pql.enQueue(4, 4);
        pql.enQueue(9, 9);
        pql.enQueue(3, 3);
        pql.enQueue(8, 8);
        pql.enQueue(10, 10);
        
        System.out.println(pql.toString());
        
        System.out.println(" Peek " + pql.peek());
       
        System.out.println(" Remove " + pql.deQueue());
        
        System.out.println(pql.toString());
        
        pql.enQueue(12, 12);
        
        System.out.println(pql.toString());
        
        System.out.println(" Peek " + pql.peek());
       
        System.out.println(" Remove " + pql.deQueue());
        
        System.out.println(" Peek " + pql.peek());
       
        System.out.println(" Remove " + pql.deQueue());
        
        System.out.println(" Peek " + pql.peek());
       
        System.out.println(" Remove " + pql.deQueue());
        
        System.out.println(pql.toString());
    }
}
