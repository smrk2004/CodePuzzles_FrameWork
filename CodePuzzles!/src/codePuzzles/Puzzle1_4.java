package codePuzzles;

import java.util.HashMap;
import java.util.Scanner;

public class Puzzle1_4 {//Strings & Arrays:Check Permutations

	/**
	 * @param args
	 */	
	final static String		question	="Check if the 2 input Strings are permutations of each other";		
	final static String[]   toDoString  ={"Check Permutated-String1","Check Permutated-String2"}; 		
	final static String[] 	solutionDesc={"Sort & Compare/[Character Array Soln]","Counting Character Frequencies/[HashMap Soln]"};
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
								
	public static boolean isPermutated_I(String s1,String s2)	
	{
		if(s1.length()!=s2.length())	return false;	//Optimization!
				
		char[] charArray1=s1.toCharArray();		java.util.Arrays.sort(charArray1);
		char[] charArray2=s2.toCharArray();		java.util.Arrays.sort(charArray2);
		
		String s1new=new String(charArray1);
		String s2new=new String(charArray2);	// NOT " charArray2.toString(); "
		
		return s1new.equals(s2new);
		
		//-----------------------------------------------------------------------------------------
		/*NOTE: 			  charArray.toString()  does NOT convert charArray to a String!;
				Instead, use: new String(charArray)								
				
		eg.following prints different values(!the addresses!)for same String I/P to both charArrays		
				System.out.println("<|1:"+charArray1+"|2:"+charArray2);							*/
		//-----------------------------------------------------------------------------------------			
	}
	
	public static boolean isPermutated_II(String s1,String s2)	
	{	
		if(s1.length()!=s2.length())	return false;	//Optimization!
		
		HashMap<Character,Integer> met=new HashMap<Character,Integer>(); 
		char[] charArray1=s1.toCharArray(); for(char c:charArray1){	met.put(c, 	met.containsKey(c) ? met.get(c)+1 : 1);					  																 																  
																  }
		char[] charArray2=s2.toCharArray(); for(char c:charArray2){	if(!met.containsKey(c))	  return false;
																	else { 	if(met.get(c)==0) return false;
																			else met.put(c, met.get(c)-1);
																		 }																					
																  }		
		return true;											
	}

												
	public static void run(int solnNo, Scanner sc)
	{
		if(solnNo==1){System.out.print("\nEnter String ["+toDoString[0]+"]:");
					  String s1=sc.next();
					  System.out.print("\nEnter String ["+toDoString[1]+"]:");
					  String s2=sc.next();
					  System.out.println("\n::"+isPermutated_I(s1,s2));					  							
					 }
   else if(solnNo==2){System.out.print("\nEnter String ["+toDoString[0]+"]:");
   					  String s1=sc.next();
   					  System.out.print("\nEnter String ["+toDoString[1]+"]:");
   					  String s2=sc.next();
		  			  System.out.println("\n::"+isPermutated_II(s1,s2));		  			  							
		 			 }
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}
