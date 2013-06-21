package codePuzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle1_2 {//Strings & Arrays:Count Words
	/**
	 * @param args
	 */	
	final static String		question	="Return # of Times a given Word appears in given Array";		
	final static String[]   toDoString  ={"Compute Word Count"}; 		
	final static String[] 	solutionDesc={"Simple/[HashMap Soln]"};
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
								
	
	public static HashMap<String,Integer> count(String[] words)	
	{	//System.out.println("\nSolution1:"+getSolutionDesc(1));
		
		HashMap<String,Integer> freq=new HashMap<String,Integer>();
		for(String word:words) if(freq.containsKey(word))freq.put(word, freq.get(word)+1);
							   else						 freq.put(word, 1);
		
		return freq;
	}		

												
	public static void run(int solnNo, Scanner sc)
	{
		if(solnNo==1){System.out.println("\nEnter String Array ["+toDoString[0]+"]:\n\n//ENTER -1 to STOP!");	//Can Extend # of String Input Prompts
					  
					  ArrayList<String> wordList=new ArrayList<String>();
					  
					  String sIn="";
					  while(!(sIn=sc.next()).equals("-1"))	{wordList.add(sIn);} 
					  if (wordList.size()!=0)
					  {						  
						  String[] words=new String[wordList.size()];		int i=0;				  
						  for(String w:wordList){words[i++]=w;}
					  
						  HashMap<String,Integer> frequency=count(words);
						  										System.out.println("\nReturned Frequencies:\n");					  									
					  	  for(String key:frequency.keySet()){	System.out.println("::"+key+": <"+frequency.get(key)+" times>");}
					  }
					  else 										System.out.println("\nReturned Frequencies:EMPTY HASHMAP / NO Input Read!\n");
					 }
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}





