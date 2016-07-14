/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

/**
 *
 * @author ianlong
 */
public class Problem4 {

public static double numberOfDigits(double number)
{return Math.floor(Math.log10(number)+ 1);}


public static double nthDigit (double number, double digit)
{if ((numberOfDigits(number) < digit) || (digit <= 0)) {
    return 0;
    }
else if (numberOfDigits(number) == digit)
    {return ((number - (number % Math.pow(10,numberOfDigits(number)-1)))/(Math.pow(10,numberOfDigits(number)-1)));}
else {
    return nthDigit((number % Math.pow(10,numberOfDigits(number)-1)),digit);}
}

public static boolean twoDigitsEqual(double number, double digit1, double digit2) {
      if (((0 >= digit1) && (digit1 > numberOfDigits(number)) && (0 >= digit2) && 
         (digit2 > numberOfDigits(number))) || (nthDigit(number, digit1) != nthDigit(number, digit2)))
      {return false;}
      else 
      {return true;}}

public static boolean badPalindromeChecker(double number, double digit1, double digit2) {
    if (digit1 <= digit2)
    {return true;}
    else if (!(twoDigitsEqual(number, digit1, digit2)))
    {return false;}
    else {
    return badPalindromeChecker(number, digit1 - 1, digit2 + 1);}
}

public static boolean palindromeChecker(double number) {
  return badPalindromeChecker(number, numberOfDigits(number), 1);   
}


public static double oneDimMaxPalindrome(double Int1, double Int2){ 
    if (palindromeChecker(Int1 * Int2))
    {return Int1 * Int2;}
    else
    {return oneDimMaxPalindrome(Int1 - 1, Int2);}}
 
public static double maxPalindrome(double Int2)
   {double currentLargestPalindrome = 1;
       while (Int2 <= 999) {
     if (oneDimMaxPalindrome(999, Int2) > currentLargestPalindrome) {
     currentLargestPalindrome = oneDimMaxPalindrome(999, Int2);
      Int2++;}
     else {
         Int2++;
     }
     }
       
   return currentLargestPalindrome;
   }
  
  
   
          
       
       
       
       
   



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
     System.out.println(palindromeChecker(909009));
     System.out.println(palindromeChecker(900009));
     System.out.println(palindromeChecker(906609));
     System.out.println(maxPalindrome(1));
    
    
    
    }
    
}
