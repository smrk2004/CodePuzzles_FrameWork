package codePuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle5_2 {//Sort & Search:Merge Two Arrays
	/**
	 * @param args
	 */	
	final static String		question	="Merge 2 non-null Sorted Arrays into one sorted array";		
	final static String[]   toDoString  ={"Array1-To Merge Arrays","Array2-To Merge Arrays"}; 		
	final static String[] 	solutionDesc={"MergeSort Approach/[Simple Soln]"};
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

	public static int[] merge_I(int[] array1,int[] array2)
	{
		int index1,index2;
			index1=index2=0;
			
		int[] 	  merged=new int[array1.length+array2.length];
		
		int i;
		for(i=0;i<merged.length;)	//Can substitute "for & if" with 'while' loop; on condition
									//						 => can eliminate need for 'break';
		{			
			if(index1<array1.length&&index2<array2.length)
			{
					if(array1[index1]<array2[index2])	merged[i++]=array1[index1++];
					else								merged[i++]=array2[index2++];
			}
			else	break;						
		}
		
		while(index1<array1.length)				merged[i++]=array1[index1++];
		while(index2<array2.length)				merged[i++]=array2[index2++];
		
		return merged;
	}
	
	public static void run(int solnNo, Scanner sc)
	{
boolean printInputsToCheckSorted=false;
		
if(solnNo<1||solnNo>getSolutionCount())		
			  System.out.println("\n!!![Invalid Solution #]!!!");		
		else
		{	  boolean	inputGot=false;						
			  System.out.println("\nEnter Sorted Integer Array ["+toDoString[0]+"]:\n\n(If Not Sorted, Will Auto-Sort & Feed to 'merge()')\n//ENTER * to STOP!");	//Can Extend # of String Input Prompts
			  
			  String sIn="";							boolean list1Read=false;								
			  ArrayList<Integer> 	integerList1=new ArrayList<Integer>();
								
			  while(!(sIn=sc.next()).equals("*"))	     
									integerList1.add(Integer.parseInt(sIn));													  							  			
					  			
			  int[] 	integerArray1=null;

			  if(		integerList1.size()!=0		)
			  {			integerArray1=new int[ integerList1.size() ];	int i=0;
					  					
			  	for(int integerListElement1:integerList1)
						integerArray1[i++]=integerListElement1;			 
			  	Arrays.sort(
						integerArray1);							list1Read=true;
			  }						  			
					  				
			  System.out.println("\nEnter Sorted Integer Array ["+toDoString[1]+"]:\n\n(If Not Sorted, Will Auto-Sort & Feed to 'merge()')\n//ENTER * to STOP!");	//Can Extend # of String Input Prompts
			
														boolean list2Read=false;
              ArrayList<Integer> 	integerList2=new ArrayList<Integer>();
					  													
  			  while(!(sIn=sc.next()).equals("*"))	     
  				  					integerList2.add(Integer.parseInt(sIn));													  							  			
					  										  			
  			  int[] 	integerArray2=null;

  			  if(		integerList2.size()!=0		)
  			  {			integerArray2=new int[ integerList2.size() ];	int i=0;
					  									  					
  				for(int integerListElement2:integerList2)
  						integerArray2[i++]=integerListElement2;
  				Arrays.sort(
  						integerArray2);							list2Read=true;
  			  }
  			  
  			  if(list1Read&&list2Read)	inputGot=true;
  			  
  			  	if(inputGot) 
				{	
  			  		if(printInputsToCheckSorted)
  			  		{
  			  				System.out.println(  "\nRead IP-1:");
  			 			for(int int1:integerArray1)			
  			 				System.out.print(int1+" ");				
  			 				System.out.println();
							
  			  				System.out.println("\nRead IP-2:");
  			  			for(int int2:integerArray2)					
  			  				System.out.print(int2+" ");				
  			  				System.out.println();
  			  		}  		
  			  		
  			  		if(solnNo==1){	System.out.println("\nMerged Array:\n");
  			  						System.out.print("::");
					
  			  						for(int integerArrayElement:merge_I(integerArray1,integerArray2))
  			  							System.out.print(integerArrayElement+" ");
  			  					 }
				}
  			  	else 	
					System.out.println("\nMerged Array:EMPTY / NO Input / Insufficient Input Read!\n");				
		}
   		
	}
}
