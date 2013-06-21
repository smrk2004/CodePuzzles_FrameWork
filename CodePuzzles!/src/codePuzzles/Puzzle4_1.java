package codePuzzles;

import java.util.HashMap;
import java.util.Scanner;

public class Puzzle4_1 {//Recursion:Compute Fibonacci
	/**
	 * @param args
	 */	
	final static String		question	="Compute the nth number in the Fibonacci Sequence";		
	final static String[]   toDoString  ={"To Compute Fibonacci"}; 		
	final static String[] 	solutionDesc={"Redundant Computation/[Naive-Recursive Soln]","Cache Optimized <HashMap> /[Dynamic Programming-Recursive Soln]","'savePrevious'/[Iterative Soln]"};
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
								
	
	public static int   fibo_I(int n)	
	{		
		if(n<0)	{System.out.println("!Invalid/Non-standard 'n'!");return n;}
		
		if(n==0)return 0;
		if(n==1)return 1;
		
		return fibo_I(n-1)+fibo_I(n-2); 
	}
	
	public static int  fibo_II(int n)	
	{				
		HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();
	
		if(n<0)	{System.out.println("!Invalid/Non-standard 'n'!");return n;}
		
		cache.put(0, 0);
		cache.put(1, 1);
		
		return fibo_II(n,cache); 
	}
	
	public static int  fibo_II(int n,HashMap<Integer,Integer>cache)
	{		
		
		if(!cache.containsKey(n))
			cache.put(n, fibo_II(n-1,cache)+fibo_II(n-2,cache));
		
		return cache.get(n);		
	}
	
	public static int fibo_III(int n)	
	{	
		if(n<0)	{System.out.println("!Invalid/Non-standard 'n'!");return n;}
		
		int prev1=0,prev2=1;
		int savePrev=0;
		
		for(int i=0;i<n;i++)
		{
			savePrev=prev1;
			prev1=prev2;
			prev2=savePrev+prev1;
		}
		return prev1;		
	}

												
	public static void run(int solnNo, Scanner sc)
	{

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter Integer ["+toDoString[0]+"]:");
				if(solnNo==1){	System.out.print("\n::"+  fibo_I(sc.nextInt()));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+ fibo_II(sc.nextInt()));		  			  							
				 	 		 }		
				if(solnNo==3){	System.out.print("\n::"+fibo_III(sc.nextInt()));		  			  							
				 	 		 }		
		}
	}
}
