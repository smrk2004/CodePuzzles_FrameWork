package codePuzzles;

import java.util.Scanner;

public class Puzzle2_4 {//Numbers:Convert To Decimal
	/**
	 * @param args
	 */	
	final static String		question	="Convert +ve Binary number(I/P as String)to Decimal #!";		
	final static String[]   toDoString  ={"To Convert to Decimal"}; 		
	final static String[] 	solutionDesc={"Trivial/[Exhaustive expansion Soln]","Double+add/[Iterative Soln]"};
											//Solution 1		...			//Solution 2 		...
 
	final static int 		solutionCount=solutionDesc.length;
	
	public static void 		getIntro()			{
													System.out.println("\nQuestion:"+question+"\n");
													
													System.out.println("Solution(s) Available:");
																										
													int currSolCount=0;
													for(String sd:solutionDesc)
														{
															if(currSolCount==solutionCount)break;
															System.out.println("\nSolution "+(++currSolCount)+":"+sd);//SAME AS--->//getSolutionDesc(currSolCount));
														}
												}
	public static int 		getSolutionCount()	{return solutionCount;}
	public static String 	getQuestion()  		{return question;}
	public static String 	getSolutionDesc(int i)
												{return solutionDesc[i-1];}
								
	
	public static int toDecimal_I(String s)	
	{	
		if(s==null||s.equals(""))return -1;
		
		int decimal=0;int i=0;	
		for(char c:s.toCharArray())
		{
			int digit=c-'0';
			decimal+=Math.pow(2, s.length()-1-i)*digit;
			i++;
		}
		return decimal; 
	}
	
	public static int toDecimal_II(String s)	
	{	
						
		if(s==null||s.equals(""))return -1;
		
		int decimal=0;
			
		for(char c:s.toCharArray())
		{
			int digit=c-'0';
			decimal=decimal*2+digit;		
		}
		return decimal;
	}
	

	
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter String ["+toDoString[0]+"]:");
				if(solnNo==1){	System.out.print("\n::"+ toDecimal_I(sc.next()));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+toDecimal_II(sc.next()));		  			  							
				 	 		 }		
		}   		
	}
}
