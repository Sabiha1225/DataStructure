/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

class DPNode{
    int data;
    int priority;
    DPNode next, prev;
    public DPNode(int d, int p)
    {
        data = d;
        priority = p;
        next = null;
        prev = null; 
    }
}
public class Priority_Que_Doubly_list {
    DPNode head = null, tail = null;
    int totalCount = 0;
    public void enQueue(int d, int p)
    {
        DPNode temp = new DPNode(d, p);
        totalCount++;
        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            if(temp.priority > head.priority)
            {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            else if(temp.priority < tail.priority)
            {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            else 
            {
                DPNode t = head;
                while(t.next != null && t.next.priority > temp.priority)
                {
                    t = t.next;
                }
                temp.next = t.next;
                t.next.prev = temp;
                t.next = temp;
                temp.prev = t;
            }
        }
    }
    
    public int peek()
    {
        return head.data;
    }
    
    public int deQueue()
    {
        if(totalCount == 0)
            return -1;
        totalCount--;
        DPNode temp = head;
        int data = temp.data;
        head = head.next;
        head.prev = null;
        temp = null;
        if(head == null)
            tail = null;
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
        DPNode temp = head;
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
