/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReHashing;

/**
 *
 * @author Administrator
 */

public class Rehashing {
    public static void main(String[] args) 
    {   
        // Creating the Map 
        Map<Integer, String> map = new Map<Integer, String>(); 
  
        // Inserting elements 
        map.insert(1, "Geeks"); 
        map.printMap(); 
  
        map.insert(2, "forGeeks"); 
        map.printMap(); 
  
        map.insert(3, "A"); 
        map.printMap(); 
  
        map.insert(4, "Computer"); 
        map.printMap(); 
  
        map.insert(5, "Portal"); 
        map.printMap(); 
    } 
}
