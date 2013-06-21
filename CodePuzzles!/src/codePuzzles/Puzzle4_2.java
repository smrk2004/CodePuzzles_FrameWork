package codePuzzles;

import java.util.HashMap;
import java.util.Scanner;

public class Puzzle4_2 {//Recursion:Compute Steps
	/**
	 * @param args
	 */	
	final static String		question	="To Climb n-step staircase: Each time can make 1 (or) 2 steps; Calculate Distinct # of ways you can climb staircase.";		
	final static String[]   toDoString  ={"To Compute Steps"}; 		
	final static String[] 	solutionDesc={"Redundant Computation/[Naive-Recursive Soln]\nNOTE:{\n'#(i-1)'=# of ways climbing an (i-1) step staircase;\n\nAdd 1 step => to climb we've 2 ways:\n1 step, then do #(i-1) OR\n2 steps, then do 'backtrack by 1 of #(i-1)' i.e. do #(i-2);\n\nHence #(i)=#(i-1)+#(i-2)\n}\n\n=>O/P:fib(n+1)","Cache Optimized <HashMap> /[Dynamic Programming-Recursive Soln]"};
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
								
	
	public static int   steps_I(int n)	
	{		
		if(n<0)		return 0;
		if(n==0)	return 1;
		return steps_I(n-1)+steps_I(n-2);
	}
	
	public static int  steps_II(int n)	
	{	
		HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();				
				
		cache.put(0, 1);
		return steps_II(n,cache);
	}
	
	public static int  steps_II(int n,HashMap<Integer,Integer>cache)
	{				
		if(n<0)	return 0;
		
		if(!cache.containsKey(n))
			cache.put(n, steps_II(n-1,cache)+steps_II(n-2,cache));
		
		return cache.get(n);		
	}
													
	public static void run(int solnNo, Scanner sc)
	{

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter Integer ["+toDoString[0]+"]:");
				if(solnNo==1){	System.out.print("\n::"+  steps_I(sc.nextInt()));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+ steps_II(sc.nextInt()));		  			  							
				 	 		 }		
		}
	}
}
