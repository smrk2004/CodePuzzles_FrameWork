package codePuzzles;

import java.util.Scanner;

public class Puzzle1_3 {//Strings & Arrays:Check Palindromes
	/**
	 * @param args
	 */	
	final static String		question	="Check if given String is a Palindrome";		
	final static String[]   toDoString  ={"Check Palindrome"}; 		
	final static String[] 	solutionDesc={"Check subString=palindrome?/[Recursive Soln]","Check front=back? repeatedly/[Iterative Soln]"};
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
								
	
	public static boolean isPalindrome_I(String s)	
	{	//System.out.println("\nSolution1:"+getSolutionDesc(1));
		if(s==null)		return	false;
		if(s.equals(""))return 	 true;
		return isPalindrome_I(s,0,s.length()-1);
	}
	
	public static boolean isPalindrome_I(String s,int startIndex,int endIndex)
	{
		if(startIndex>=endIndex)						return true;
		if(s.charAt(startIndex++)!=s.charAt(endIndex--))return false;
		return isPalindrome_I(s,startIndex,endIndex);
	}
	//------------------------------------------------------------------------
	public static boolean isPalindrome_II(String s)	
	{	//System.out.println("\nSolution2:"+getSolutionDesc(2));
		int startIndex=0;
		int   endIndex=s.length()-1;
		
		while(startIndex<endIndex)
		{ 
			if(s.charAt(startIndex++)!=s.charAt(endIndex--))return false;
		}
		
		return true;											
	}
	
	
	public static void run(int solnNo, Scanner sc)
	{	
		if(solnNo==1){System.out.print("\nEnter String ["+toDoString[0]+"]:");	//Can Extend # of String Input Prompts					  
					  System.out.println("\n::"+isPalindrome_I(sc.next()));					  							
					 }
   else if(solnNo==2){System.out.print("\nEnter String ["+toDoString[0]+"]:");
		  			  System.out.println("\n::"+isPalindrome_II(sc.next()));		  			  							
		 			 }
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}

