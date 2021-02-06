/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

/**
 *
 * @author Administrator
 */

class QNodeDouble{
    int key;
    QNodeDouble prev;
    QNodeDouble next;
    
    public QNodeDouble(int k, QNodeDouble p, QNodeDouble n)
    {
        key = k;
        prev = p;
        next = n;
    }
}

public class Queue_Doubly_LinkedList {
    QNodeDouble front = null, rear = null;
    int count = 0;
    public void enQueue(int k)
    {
        //
        QNodeDouble temp = new QNodeDouble(k, null, null); 
        if(front == null)
        {
            front = rear = temp;
        }
        else
        {
            rear.next = temp;
            temp.prev = rear;
            rear = temp;
        }
        
        count++;
    }
    
    public int deQueue()
    {
        if(front == null)
        {
            System.out.println("Queue underflow");
            return -1;
        }
        
        else
        {
            QNodeDouble temp = front;
            front = front.next;
            
            if(front != null)
                front.prev = null;
            if(front == null)
            {
                rear = null;
            }
            count--;
            return temp.key;
        }
    }
    
    public int size()
    {
        return count;
    }

    @Override
    public String toString() {
        QNodeDouble temp = front;
        String s = "";
        while(temp != null)
        {
            s = s.concat(temp.key + " -- ");
            temp = temp.next;
        }
        return s; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public static void main(String args[] )
    {
        Queue_LinkedList queue = new Queue_LinkedList();
        queue.enQueue(5);
        System.out.println(queue.toString());
        queue.enQueue(4);
        System.out.println(queue.toString());
        queue.enQueue(8);
        System.out.println(queue.toString());
        
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());
    }
}
