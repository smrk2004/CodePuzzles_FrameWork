package codePuzzles;

import java.util.Scanner;

public class Puzzle1_5 {//Strings & Arrays:Compress Strings
	/**
	 * @param args
	 */	
	final static String		question	="Compress the String using the Rule: [abbcccdddde=ab2c3d4e]";		
	final static String[]   toDoString  ={"To Compress"}; 		
	final static String[] 	solutionDesc={"Simple/[Loop Soln]"};
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
									
	public static String compress(String s)	
	{
		if (s==null||s.equals("")) return "";
								
		StringBuilder compressed=new StringBuilder();
		
		int count=1;
		
		for(int i=0;i<s.length();i++)
		{	compressed.append(s.charAt(i));
			count=1;
			
			while((i+1)<s.length() && (s.charAt(i)==s.charAt(i+1)))	{ i++;  count++;}
									 								   									
			if(count>1)compressed.append(count);
		}
		
		return compressed.toString();
	}		

												
	public static void run(int solnNo, Scanner sc)
	{
		if(solnNo==1){System.out.print("\nEnter String ["+toDoString[0]+"]:");	//Can Extend # of String Input Prompts
					  System.out.println("\n::"+compress(sc.next()));					  							
					 }
   		else System.out.println("\n!!![Invalid Solution #]!!!");		
	}
}
