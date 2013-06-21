package codePuzzles;

import java.util.HashMap;
import java.util.Scanner;

public class Puzzle1_1 {//Strings & Arrays:Check Unique Strings
	/**
	 * @param args
	 */	
	final static String		question	="Check if all characters in given String are Unique";
	final static String[]   toDoString  ={"Check Unique"};
	final static String[] 	solutionDesc={"ASCII Strings/[Flag Array Soln]","Unicode Strings/[HashMap Soln]"};
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
								
	
	public static boolean isUnique_I(String s)	
	{	
		boolean[] met=new boolean[256];
		
		if (s.length()>256)return false;
		
		char[] charArray=s.toCharArray();
		for(char c:charArray)if(met[(int /*OR byte*/ )c]) 
											 {													//int i=0;System.out.println("\n[Read]");for(boolean b:met){System.out.print("met["+(i++)+"]="+b+"|");if(i%9==0)System.out.println();} 
											  return false;}
							else             {met[(int /*OR byte*/ )c]=true;									//int i=0;System.out.println("\n[Set!]");for(boolean b:met){System.out.print("met["+(i++)+"]="+b+"|");if(i%9==0)System.out.println();}
											 }
		
		return true;
    }
	
	
	public static boolean isUnique_II(String s)	
	{	
		HashMap<Character,Boolean> met=new HashMap<Character,Boolean>(); 
		char[] charArray=s.toCharArray();
		for(char c:charArray)if(met.containsKey(c))return false;
							 else met.put(c, null);		
		return true;		
	}
	
	
	public static void run(int solnNo, Scanner sc)
	{	
		if(solnNo==1){System.out.print("\nEnter String ["+toDoString[0]+"]:");
					  System.out.println("\n::"+isUnique_I(sc.next()));
					 }
   else if(solnNo==2){System.out.print("\nEnter String ["+toDoString[0]+"]:");
		  			  System.out.println("\n::"+isUnique_II(sc.next()));
		 			 }
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}
