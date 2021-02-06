/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorfulNumber;

import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class ColorfulNumberChecking {
    public static void main(String[] args) 
    {
        System.out.println(colorful(99));
    }
    
    public static int colorful(int A) {
        if(A < 10)
        {
            return 1;
        }
        else
        {
            int[] digits = new int[40];
            int digitCounts = 0, index = 0;
            int number = A;
            HashSet<Integer> products = new HashSet<>();
            while(number>0)
            {
                digits[index] = number%10;
                number /= 10;
                if(products.contains(digits[index]))
                    return 0;
                products.add(digits[index]);
                index++;
            }
            digitCounts = index;
            
            for(int i = 0, j = digitCounts-1; i<(digitCounts/2); ++i, --j)
            {
                int t = digits[j];
                digits[j] = digits[i];
                digits[i] = t;
            }
            
            int length = 2;
            for(int i = 1; i < digitCounts; ++i)
            {
                index = 0;
                while(digitCounts - index >= length)
                {
                    int prod = 1;
                    for(int j = index; j<(index+length); ++j)
                    {
                        prod *= digits[j];
                    }
                    if(products.contains(prod))
                        return 0;
                    products.add(prod);
                    index++;
                }
                length++;
            }
            return 1;
        }
    }

}
