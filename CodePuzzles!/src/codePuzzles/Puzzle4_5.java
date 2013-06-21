package codePuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle4_5 {//Recursion:Find Permutations
	/**
	 * @param args
	 */	
	final static String		question	="Find all Permutations of a Given String";		
	final static String[]   toDoString  ={"To Find Permutations"}; 		
	final static String[] 	solutionDesc={"'Take Mid; Permute Rest; Append to I' Method /[Recursive Soln 1]","'Take I; Permute Rest; Insert to Mid' Method /[Recursive Soln 2]"};
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
	
	public static ArrayList<String>  findPermutations_I(String s)	
	{					
		ArrayList<String> permutations=new ArrayList<String>();
		
		if(s==null) 		return null;		
		if(s.length()<=1)	permutations.add(s);
		
		else
		for(int i=0;i<s.length();i++)
		{	
			String sub=s.substring(0,i)+s.substring(i+1);
			
			for(String permOfSub:findPermutations_I(sub))
				permutations.add(s.charAt(i)+permOfSub);							
		}

		return permutations;
	}		
	
	public static ArrayList<String>  findPermutations_II(String s)	
	{
		ArrayList<String> permutations=new ArrayList<String>();
		
		if(s==null)			return null;
		if(s.length()<=1)	permutations.add(s);

		else		
		
		for(String permOfSub:findPermutations_II(s.substring(1)))
		{	
			for(int i=0;i<permOfSub.length()+1;i++)	//In [permOfSub.length()+1]: "+1" => VITAL!
			{	String sub
						=permOfSub.substring(0,i)+s.charAt(0)+permOfSub.substring(i);
				permutations.add(sub);				
			}
		}
				
		return permutations;
	}
		
	public static void run(int solnNo, Scanner sc)
	{	
		
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter String ["+toDoString[0]+"]:");
								String sIn=sc.next();
								
				if(solnNo==1){	System.out.print("\n::");																													
								ArrayList<String> ls= findPermutations_I(sIn);												  								
				
								for(String s:ls)	System.out.print(s+" ");																													
							 }	
				if(solnNo==2){	System.out.print("\n::");											
								ArrayList<String> ls=findPermutations_II(sIn);												  
																
								for(String s:ls)	System.out.print(s+" ");																										
							 }														
		}
	}
}

