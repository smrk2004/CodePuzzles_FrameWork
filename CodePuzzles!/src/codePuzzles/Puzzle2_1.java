package codePuzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle2_1 {//Numbers:Find Number Pairs
	/**
	 * @param args
	 */	
	final static String		question	="Print all number pairs in Array, whose sums match no. given";		
	final static String[]   toDoString  ={"To Print Same-Sum # Pairs","Sum to Check Against"}; 		
	final static String[] 	solutionDesc={"BruteForce/[Simple Soln]","Sort & Search/[Intelligent Iterative Soln]","Hash & Search/[HashMap Soln]"};
											//Solution 1		...			//Solution 2 		...		...			//Solution 3 		...
 
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
								
	
	public static void   printPairs_I(int[] numbers,int sum)	
	{		
		boolean[] printed=new boolean[numbers.length];
		boolean foundPair=false;
		for(int i=0;i<numbers.length;i++)		
			for(int j=0;j<numbers.length;j++)
			{
				if(numbers[i]+numbers[j]==sum&&/*!printed[i]&&*/!printed[j]&&i!=j)
					{
					 System.out.print("<"+numbers[i]+"+"+numbers[j]+"="+sum+">|");
					 printed[i]=printed[j]=true;
					 foundPair=true;
					}
			}
		if(!foundPair)System.out.print("EMPTY / NO Pairs Found!");
	}
	
	public static void  printPairs_II(int[] numbers,int sum)	
	{	
		boolean foundPair=false;
		java.util.Arrays.sort(numbers);
		
		int start=0,end=numbers.length-1;
		while(start<end)
		{			
			if(numbers[start]+numbers[end]<sum)	start++;
	   else if(numbers[start]+numbers[end]>sum)   end--;
	   else	//(numbers[start]+numbers[end]==sum)
	   		{
			System.out.print("<"+numbers[start++]+"+"+numbers[end--]+"="+sum+">|");
			foundPair=true;
	   		}
		}
		if(!foundPair)System.out.print("EMPTY / NO Pairs Found!");
	}
	
	public static void printPairs_III(int[] numbers,int sum)	
	{	
		boolean foundPair=false;
		HashMap<Integer,Boolean> numberDB=new HashMap<Integer,Boolean>();
		for(int i:numbers) numberDB.put(i, false);
		for(int i:numbers) if(numberDB.containsKey(sum-i)&&sum-i!=i)
							{			
							 if(!numberDB.get(sum-i))
							 {
							  System.out.print("<"+i+"+"+(sum-i)+"="+sum+">|");
							  numberDB.put(i, true);
							  numberDB.put(sum-i, true);
							  foundPair=true;
							 }
							}
		if(!foundPair)System.out.print("EMPTY / NO Pairs Found! ");
	}
	
												
	public static void run(int solnNo, Scanner sc)
	{			
		if(solnNo<1||solnNo>getSolutionCount())
					  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			  boolean inputGot=false;
			  System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n//ENTER -99999999 to STOP!");	//Can Extend # of String Input Prompts
			  ArrayList<Integer> numberList=new ArrayList<Integer>();

			  int intIn=Integer.MIN_VALUE;
			  while( !( (intIn=sc.nextInt()) == -99999999 ) )	{numberList.add(intIn);}
			  
			  int[] numbers=null;int sum=Integer.MIN_VALUE;
			  if (numberList.size()!=0)
			  {						  
				  numbers=new int[numberList.size()];		int i=0;				  
				  for(int number:numberList){numbers[i++]=number;}
				  
				  System.out.println("\nEnter Integer ["+toDoString[1]+"]:");
				  sum=sc.nextInt();
				  
				  inputGot=true;
			  }
			  else
			  System.out.println("\nReturned Pairs List:EMPTY / NO Input Read!\n");
			  
			  
			  if(inputGot)
			  {				
				System.out.println("\nReturned Pairs List:");
				if(solnNo==1){
							  System.out.print("\n::");  printPairs_I(numbers,sum);					  							
					 	 	 }
				if(solnNo==2){
							  System.out.print("\n::"); printPairs_II(numbers,sum);		  			  							
						 	 }
				if(solnNo==3){
							  System.out.print("\n::");printPairs_III(numbers,sum);	  			  							
   					 	 	 }
			  }
		}
	}
}
