package codePuzzles;

import java.util.Scanner;

public class Puzzle4_3 {//Recursion:Make Changes
	/**
	 * @param args
	 */	
	final static String		question	="Calculate # of ways to Change given amount of money using 4 different types of coins: Quarters, Dimes, Nickels & Pennies. Assume an infinite supply of coins";		
	final static String[]   toDoString  ={"Amount in Cents worth - To Make Changes"}; 		
	final static String[] 	solutionDesc={"Subtract Highest denom once & call recurse - proceed to lower start denoms for recursion via loop /[Recursive Soln]","Optimized iterative subtract(subtract upto max possib # of max denom coin) & recurse /[Optimized-Recursive Soln]"};
											//Solution 1		...			//Solution 2 		...			//Solution 3 		...
 
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
						
	public static final int[] COIN_TYPES={25,10,5,1};
	
	public static int  change_I(int n)	
	{				
		return change_I(n,0);
	}
	
	public static int  change_I(int n,int startIndex)
	{
		int ways=0;
		
		if(n<0)								return 0;
		
		if(n==0) 							return 1;	//BASE case
		if(startIndex==COIN_TYPES.length-1)	return 1;	//Optimization - all pennies case
		
				
			for(int i=startIndex;i<COIN_TYPES.length;i++)
			{
				if(n>=COIN_TYPES[i])
					ways+=change_I(n-COIN_TYPES[i],i);		
			}		
		
		return ways;
	}
	
	public static int  change_II(int n)	
	{			
		return change_II(n,0);
	}
	
	public static int  change_II(int n,int startIndex)	
	{			
		if(n<0)								return 0;
		
		if(n==0)							return 1;
		if(startIndex==COIN_TYPES.length-1)	return 1;

		int nextIndex=(startIndex+1)<COIN_TYPES.length?startIndex+1:-1;	//-1 is a flag value; NEVER happens since,
																		//@case where: 'startIndex+1=COIN_TYPES.length' met ; 'startIndex=COIN_TYPES.length-1', i.e. the condition for return '1' on all pennies gets TRIGGERED - this line NOT Reached in that case!
																		//	if(nextIndex==-1) System.out.println("Nooooo!"); // - LOL!
		
		int ways=0;
		
		for(int i=0;n>=(i*COIN_TYPES[startIndex]);i++)
		{
																		//Don't NEED!: if(nextIndex!=-1)  
			ways+=change_II( n-(i*COIN_TYPES[startIndex]) ,nextIndex);
		}
		
		return ways;
	}
													
	public static void run(int solnNo, Scanner sc)
	{

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter Integer ["+toDoString[0]+"]:");
				if(solnNo==1){	System.out.print("\n::"+  change_I(sc.nextInt()));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+ change_II(sc.nextInt()));		  			  							
				 	 		 }		
		}
	}
}
