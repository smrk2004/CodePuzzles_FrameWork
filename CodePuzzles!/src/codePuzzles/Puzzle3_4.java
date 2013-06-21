package codePuzzles;

import java.util.HashMap;
import java.util.Scanner;

public class Puzzle3_4 {//Linked Lists:Remove Duplicates
	/**
	 * @param args
	 */	
	final static String		question	="Remove Duplicate Nodes of Given Linked List";		
	final static String[]   toDoString  ={"To Remove Duplicate Node(s)"}; 		
	final static String[] 	solutionDesc={"HashMap(Non-ASCII)/Flag(ASCII) Checking/[Time Efficient Soln]","Nested 'for' Checking/[Space Efficient Soln]"};
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
								
	
	public static void  removeDuplicates_I(Node_3 head)	
	{	
	
		boolean ascii=false; boolean printCase=false;
		
		if(!ascii)
		{
			HashMap<Character,Boolean>met=new HashMap<Character,Boolean>();
			Node_3 curr=head,prev=null;
						
			while(curr!=null)
			{
				if(met.containsKey(curr.data))
					prev.next=prev.next.next;
				else 
				{	met.put(curr.data, null);
					prev=curr;				
				}
				curr=curr.next;
			}			
			if(printCase)	System.out.println("<Non-ASCII Case!>");		
		}
		
		else
		{
			boolean met[]=new boolean[256];
			Node_3 curr=head,prev=null;
			
			while(curr!=null)
			{
				if(met[(char)curr.data])
					prev.next=prev.next.next;									
				else
				{
					met[(char)curr.data]=true;
					prev=curr;
				}				
				curr=curr.next;
			}									
			if(printCase)	System.out.println("<ASCII Case!>");			
		}
	}
	
	public static void removeDuplicates_II(Node_3 head)	
	{		 		
		for(Node_3 curr=head;curr!=null;curr=curr.next)
		{			
			Node_3 next=curr.next;
			Node_3 prev=curr;
			
			while(next!=null)
			{	if(next.data==curr.data) prev.next=next.next;										 
				else 					 prev=next;
				
				next=next.next;
			}			
		}
	}
													
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Linked List Node data value(s) <char>, Head->Tail ["+toDoString[0]+"]:\n\n//ENTER * to STOP!");
			
			Node_3 head=null,tail=null;
			
			char cIn=' ';
			while(! ((cIn=sc.next().charAt(0))=='*') )	
			{
				if(head==null)
					head=tail=new Node_3(cIn,null);
				else
				{	     tail.next=new Node_3(cIn,null);
				    tail=tail.next;
				}
			}
	  			
			if (head!=null)									  				
				inputGot=true;			
			else
				System.out.println("\nFinal Linked List:NULL / NO Input Read!\n");
	  	  
			if(inputGot)
			{				
				System.out.println("\nFinal Linked List:");
				if(solnNo==1){	System.out.print("\n::");	removeDuplicates_I(head);
															while(head!=null)
															{
																System.out.print("["+head.data+"]->");
																head=head.next;
															}					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::");	removeDuplicates_II(head);
															while(head!=null)
															{
																System.out.print("["+head.data+"]->");
																head=head.next;
															}							  			  							
				 	 		 }		
			}
		}			
	}
}
