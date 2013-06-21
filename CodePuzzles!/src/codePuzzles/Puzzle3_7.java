package codePuzzles;

import java.util.Scanner;

public class Puzzle3_7 {//Linked Lists:Check Cyclic
	/**
	 * @param args
	 */	
	final static String		question	="Check if a Given Linked List is Cyclic";		
	final static String[]   toDoString  ={"To Check Cyclic"}; 		
	final static String[] 	solutionDesc={"2-Pointer Solution /[Runner Soln]"};
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
								
	
	public static boolean isCyclic_I(Node_3_6 head)	
	{	
		Node_3_6 slow=head,fast=head;
		
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)return true;
		}
		return false;
	}
													
	public static void run(int solnNo, Scanner sc)
	{	
	
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			boolean linkIt=false;
			System.out.println("\nEnter Linked List Node data value(s) <int>, Head->Tail ["+toDoString[0]+"]:\n\n//ENTER * to STOP (or) C to STOP Cyclic LIST Input!");			
			Node_3_6 head=null,tail=null;
			
			String sIn="";
			int iIn=Integer.MIN_VALUE;
			while(! (sIn=sc.next()).equals("*") )	
			{	
				if(sIn.equals("C")){linkIt=true; break;}
				try
				{			
				iIn=Integer.parseInt(sIn);
				}
				catch(NumberFormatException e1){head=null;break;}
				if(head==null)
					head=tail=new Node_3_6(iIn,null);
				else
				{	     tail.next=new Node_3_6(iIn,null);
				    tail=tail.next;
				}				
			}			
	  		
			if(linkIt)
				tail.next=head;
			
			if (head!=null)									  				
				inputGot=true;			
			else
				System.out.println("\nReturned:NULL / NO Input Read! / Incorrect Input-type Read!\n");
	  	  				  		   
			if(inputGot)
			{								
				if(solnNo==1){	System.out.print("\n::"+ isCyclic_I(head));																																				  							
			 	 	 		 }
			}
		}		
	}
}
