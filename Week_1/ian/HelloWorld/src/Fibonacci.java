public class Fibonacci {

	/**
	 * You'll learn as you go along, but the @param tags are a way of generating automatic java documentation (called javadocs). Super useful later on. 
	 * 
	 * @param args our arguments passed in from the command line. 
	 */
public static void main(String[] args){	
	System.out.println("The sum of these numbers is " + SumFibonaccis(1,1,0));}

	public static long SumFibonaccis(long FirstNumber, long SecondNumber, long StartingNumber) {
			if (SecondNumber > 4000000)
				{return(StartingNumber);}
                        if ((FirstNumber + SecondNumber) % 2 == 0)
				{return(SumFibonaccis(SecondNumber,FirstNumber+SecondNumber,StartingNumber+FirstNumber+SecondNumber));}
                        else
				{return(SumFibonaccis(SecondNumber,FirstNumber+SecondNumber,StartingNumber));}

		}

}