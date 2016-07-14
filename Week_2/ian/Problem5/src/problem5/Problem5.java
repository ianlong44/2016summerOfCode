/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

/**
 *
 * @author ianlong
 */
public class Problem5 {

public static long factorial(long number) {
 if (number <= 1) {
 return 1;}
 else {
    return number * factorial(number - 1);
 }}
 
public static boolean divisibleByList(long number, long listMax) {
      if (listMax == 1)  {
       return true;
      }
      else if (number % listMax == 0) {
       return divisibleByList(number, listMax - 1);
      }
      else {
       return false;}  
  }

 public static long getToLCD (long number, long RunningDivisor, long topDividingNumber) {
   
    if (RunningDivisor == 1) {
     return number;}
    else if (divisibleByList(number / RunningDivisor, topDividingNumber)) {
   return getToLCD(number / RunningDivisor, RunningDivisor, topDividingNumber);}
    else {
    return getToLCD(number, RunningDivisor - 1, topDividingNumber);}
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    long startingNumber = factorial(20L);
    System.out.println(startingNumber);
    System.out.println(divisibleByList(startingNumber, 20));
    System.out.println(getToLCD(startingNumber, 20, 20)); 
    System.out.println(divisibleByList(9699690, 20));
    }
    
}
