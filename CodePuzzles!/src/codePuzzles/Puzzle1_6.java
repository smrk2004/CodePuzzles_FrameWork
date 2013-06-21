package codePuzzles;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Puzzle1_6 {//Strings & Arrays:Shuffle Cards
	/**
	 * @param args
	 */	
	final static String		question	="Write Method to randomly Shuffle a deck of cards(repr. as array of Integers)";		
	final static String[]   toDoString  ={"To Shuffle"}; 		
	final static String[] 	solutionDesc={"Simple Shuffle by Swap with Random/[Bounded Index Gen. Soln]"};
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
									
	public static void shuffle(int[] cards)	
	{	Random r=new Random();																	//boolean[] locked=new boolean[cards.length];
																								//							System.out.println();
																								//for (boolean b:locked) 	System.out.print(b+"|");		
		for(int i=0;i<cards.length;i++)
		{
			int nextIndex=i+r.nextInt(cards.length-i);			
			int temp;
			    temp=cards[i];
			    cards[i]=cards[nextIndex];
			    cards[nextIndex]=temp;			    
		}		
	}
	
												
	public static void run(int solnNo, Scanner sc)
	{
		if(solnNo==1){System.out.println("\nEnter Cards<Integer Array> ["+toDoString[0]+"]:\n\n//ENTER -1 to STOP!");	//Can Extend # of String Input Prompts
					  ArrayList<Integer> cardDeckList=new ArrayList<Integer>();
		  
					  int intIn=Integer.MIN_VALUE;
					  while( !( (intIn=sc.nextInt()) == -1 ) )	{cardDeckList.add(intIn);} 
					  if (cardDeckList.size()!=0)
					  {						  
						  int[] cardDeck=new int[cardDeckList.size()];		int i=0;				  
						  for(int card:cardDeckList){cardDeck[i++]=card;}
		  						  		
						  shuffle(cardDeck);
						  		
			  			  System.out.print("\nReturned Card Deck:\n");
						  System.out.print("\n::");
			  			  for(int card:cardDeck) { System.out.print(card+"|"); }
					  }
					  else
					  System.out.println("\nReturned Card Deck:EMPTY Integer Array / NO Input Read!\n");
							  
					 }
   	else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}
