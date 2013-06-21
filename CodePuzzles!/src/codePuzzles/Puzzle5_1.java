package codePuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle5_1 {//Sort & Search:Group Anagrams
	/**
	 * @param args
	 */	
	final static String		question	="To Group the Anagrams within given String Array";		
	final static String[]   toDoString  ={"To Group Anagrams"}; 		
	final static String[] 	solutionDesc={"Simple - Sort, Hash & Group Approach /[HashMap Soln]"};
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

	public static void groupByAnagrams_I(String[] array)
	{
		HashMap<String,ArrayList<String>> groupedAnagrams=new HashMap<String,ArrayList<String>>();
		
		for(String arrayElement:array)
		{	
			char[]								 charArray=arrayElement.toCharArray();
									 Arrays.sort(charArray);
			String sortedArrayElement=new String(charArray);
			
			if(!groupedAnagrams.containsKey(sortedArrayElement))
			{
				groupedAnagrams.put(sortedArrayElement,new ArrayList<String>());
			}	groupedAnagrams.get(sortedArrayElement).add(arrayElement);
		}
		
		int i=0;
		for(String sortedAnagram:groupedAnagrams.keySet())
			for(String s:groupedAnagrams.get(sortedAnagram))				
				array[i++]=s;		
	}
	
	public static void run(int solnNo, Scanner sc)
	{
		
if(solnNo<1||solnNo>getSolutionCount())		
			  System.out.println("\n!!![Invalid Solution #]!!!");		
		else
		{						System.out.println("\nEnter String Array ["+toDoString[0]+"]:\n\n//ENTER -1 to STOP!");	//Can Extend # of String Input Prompts
				if(solnNo==1){  ArrayList<String> arrayList=new ArrayList<String>();
					  
					  			String sIn="";
					  			while(!(sIn=sc.next()).equals("-1"))	{arrayList.add(sIn);} 
					  			if (arrayList.size()!=0)
					  			{						  
					  				String[] array=new String[arrayList.size()];		int i=0;				  
					  				for(String arrayListElement:arrayList)
						  				{array[i++]=arrayListElement;}					  
									System.out.println("\nGrouped Anagrams:\n");
									System.out.print("::");
									groupByAnagrams_I(array);
								for(String arrayElement:array)
									System.out.print(arrayElement+"|");
					  			}
					  			else 	
					  				System.out.println("\nGrouped Anagrams:EMPTY / NO Input Read!\n");
							 }
		}
   		
	}
}
