package codePuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle5_3 {//Sort & Search:Find Index
	/**
	 * @param args
	 */	
	final static String		question	="Take \"Sorted Array\" w/ 'Distinct' Elements and return 'index' at which \"array[index]=index\"";		
	final static String[]   toDoString  ={"To find Element w/ 'Index=value' <@MUST_BE-Sorted_&_Distinct>"}; 		
	final static String[] 	solutionDesc={"Bruteforce-Linear Search Approach /[Naive Iteration]","Binary Search Approach /[Iterative Solution]","Binary Search Approach /[Recursive Solution]"};
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

	public static int   findIndex_I(int[] array)	
	{
		for(int i=0;i<array.length;i++)
				if( i==array[i] )		return  i;	
										return -1;
	}
	
	public static int  findIndex_II(int[] array)	
	{	
		int start=0;
		int   end=array.length-1;
		int   mid=(start+end)/2;
				
		while(start<=end)
		{		
			if(mid<array[mid])	   end = mid-1;			
	   else if(mid>array[mid])   start = mid+1;
	   		else				 	return mid;			 
			   mid=(start+end)/2;			
		}				
		return -1;
	}
	
	public static int findIndex_III(int[] array)	
	{	
		return findIndex_III(array,0,array.length-1);		
	}
		
	public static int findIndex_III(int[] arr,int start,int end)
	{
		int mid=(start+end)/2;
		
		if(start>end)		return  -1;
		
		 if(mid==arr[mid])	return mid;
   else  if(mid <arr[mid])	  end=mid-1;				   
   else/*if(mid >arr[mid])*/start=mid+1;  
		
		return findIndex_III(arr,start,end);
	}
	
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n//ENTER * to STOP!");	//Can Extend # of String Input Prompts
			ArrayList<Integer> numberList=new ArrayList<Integer>();

			String sIn="";
			while( !( (sIn=sc.next()).equals("*") ) )	{	int intIn=Integer.parseInt(sIn);
															numberList.add(intIn);}
	  
			int[] numbers=null;
			if (numberList.size()!=0)
			{						  
				numbers=new int[numberList.size()];		int i=0;				  
				for(int number:numberList){numbers[i++]=number;}
				
				inputGot=true;
			}
			else
				System.out.println("\nReturned Element-Index:NULL / NO Input Read!\n");
	  
	  
			if(inputGot)
			{				
				System.out.println("\nReturned Index:");
				if(solnNo==1){	int foundIndex=  findIndex_I(numbers);
				
													System.out.print("\n::"+foundIndex);
								if( foundIndex==-1)	System.out.print(" => Matching Element DOES NOT Exist!");
			 	 	 		 }

				if(solnNo==2){	int foundIndex= findIndex_II(numbers);
				
													System.out.print("\n::"+foundIndex);
								if( foundIndex==-1)	System.out.print(" => Matching Element DOES NOT Exist!");
			 	 	 		 }
				if(solnNo==3){	int foundIndex=findIndex_III(numbers);
				
													System.out.print("\n::"+foundIndex);
								if( foundIndex==-1)	System.out.print(" => Matching Element DOES NOT Exist!");
	 	 		 			 }
			}
		}				
	}
}
