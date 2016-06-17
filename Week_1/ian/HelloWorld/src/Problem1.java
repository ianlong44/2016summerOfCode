/**
 * Comments are nice to explain what the class is/what is it for
 */
public class Problem1{

	/**
	 * You'll learn as you go along, but the @param tags are a way of generating automatic java documentation (called javadocs). Super useful later on. 
	 * 
	 * @param args our arguments passed in from the command line. 
	 */
	public static void main(String[] args){
		int StartingPoint = 0;
		for (int i=999; i>0; i-=1)
			{if (i % 3 == 0 || i % 5 == 0)
				{StartingPoint = StartingPoint+i;};
		};

		System.out.println("The sum of these numbers is " + StartingPoint);
}
}