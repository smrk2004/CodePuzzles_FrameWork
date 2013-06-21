package codePuzzles;

import java.util.Scanner;

public class Puzzle2_5 {//Numbers:Convert To Decimal
	/**
	 * @param args
	 */	
	final static String		question	="Convert +ve Decimal number to Binary #!";		
	final static String[]   toDoString  ={"To Convert to Binary"}; 		
	final static String[] 	solutionDesc={"%,/ & Reverse StringBuilder/[Iterative Soln]","% & / /[Recursive Soln]"};
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
								
	
	public static String toBinary_I(int decimal)	
	{	
		if(decimal<0)	return  "";
		if(decimal==0)	return "0";
		
		StringBuilder sb=new StringBuilder();
		
		while(decimal>0)
		{			
			sb.append(decimal%2);
			decimal/=2;
		}
		return sb.reverse().toString(); 
	}
	
	public static String toBinary_II(int decimal)	
	{	
		if(decimal<=0)	return  "";		
						
		return toBinary_II(decimal/2)+decimal%2;
	}
	

												
	public static void run(int solnNo, Scanner sc)
	{

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter String ["+toDoString[0]+"]:");
				if(solnNo==1){	System.out.print("\n::"+ toBinary_I(sc.nextInt()));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+toBinary_II(sc.nextInt()));		  			  							
				 	 		 }		
		}
	}
}
