package codePuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle2_3 {//Numbers:Swap Two Numbers
	/**
	 * @param args
	 */	
	final static String		question	="Swap 2 numbers in Array without temporary Variable";		
	final static String[]   toDoString  ={"To Swap From","Swap-Index1","Swap-Index2"}; 		
	final static String[] 	solutionDesc={"+/- based/[Heterogenous op-seq Soln]","XOR based/[Homogenous op-seq Soln]"};
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
								
	
	public static void swap_I(int[] numbers,int i,int j)	
	{	
		numbers[i]=numbers[i]+numbers[j];// a ,b:=a+b,b;
		numbers[j]=numbers[i]-numbers[j];//a+b,b:=a+b,a;
		numbers[i]=numbers[i]-numbers[j];//a+b,a:= b ,a;		
	}
	
	public static void swap_II(int[] numbers,int i,int j)	
	{	
		numbers[i]=numbers[i]^numbers[j];// a ,b:=a^b,b;
		numbers[j]=numbers[i]^numbers[j];//a^b,b:=a^b,a;
		numbers[i]=numbers[i]^numbers[j];//a^b,a:= b ,a;									
	}

												
	public static void run(int solnNo, Scanner sc)
	{	
		
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n//ENTER -999999999 to STOP!");	//Can Extend # of String Input Prompts
			ArrayList<Integer> numberList=new ArrayList<Integer>();

			int intIn=Integer.MIN_VALUE;
			while( !( (intIn=sc.nextInt()) == -999999999 ) )	{numberList.add(intIn);}
	  
			int[] numbers=null;int swapIndex1=-1,swapIndex2=-1;
			if (numberList.size()!=0)
			{						  
				numbers=new int[numberList.size()];		int i=0;				  
				for(int number:numberList){numbers[i++]=number;}
				System.out.print("\nEnter String ["+toDoString[1]+"]:");
				swapIndex1=sc.nextInt();
				System.out.print("\nEnter String ["+toDoString[2]+"]:");
				swapIndex2=sc.nextInt();
				if(!(swapIndex1<0||swapIndex1>numbers.length-1||swapIndex2<0||swapIndex2>numbers.length-1))
				inputGot=true;
			}
			else
				System.out.println("\nReturned Swapped Array:NULL / NO Input Read!\n");
	  
	  
			if(inputGot)
			{				
				System.out.println("\nReturned MaxSum:");
				if(solnNo==1){	System.out.print("\n::");  swap_I(numbers,swapIndex1,swapIndex2);for(int no:numbers)System.out.print(no+"|");					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"); swap_II(numbers,swapIndex1,swapIndex2);for(int no:numbers)System.out.print(no+"|");		  			  							
				 	 		 }		
			}
			else
				System.out.println("\nReturned Swapped Array:NULL / Invalid Swap Indices!\n");
		}		   		
	}
}
