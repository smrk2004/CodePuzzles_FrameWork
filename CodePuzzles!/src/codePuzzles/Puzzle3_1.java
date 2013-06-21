package codePuzzles;

import java.util.Scanner;

public class Puzzle3_1 {//Linked Lists:Reverse
	/**
	 * @param args
	 */	
	final static String		question	="Return reverse of Given Linked List";		
	final static String[]   toDoString  ={"To Reverse List"}; 		
	final static String[] 	solutionDesc={"prev,next ptrs/[Iterative Soln]","tail/[Recursive Soln]"};
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
								
	
	public static Node_3 reverse_I(Node_3 head)	
	{	
		if(head.next==null)return head;
		
		Node_3 prev=null,curr=head;

		while(curr!=null)
		{
		Node_3 tmpNext=curr.next					;				
					   curr.next=prev				;					 			
					 		     prev=curr			;					 		   		
					 		   		  curr=tmpNext	;					 		   			
		}
		
											
		return prev;
	}
	
	public static Node_3 reverse_II(Node_3 head)	
	{	
		if(head.next==null)return head;
		
		Node_3 tail=reverse_II(head.next);
		head.next.next=head;
		head.next=null;
		
		return tail;
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
				System.out.println("\nReturned Reversed Linked List:NULL / NO Input Read!\n");
	  	  
			if(inputGot)
			{				
				System.out.println("\nReversed Linked List:");
				if(solnNo==1){	System.out.print("\n::");	head=reverse_I(head);
															while(head!=null)
															{
																System.out.print("["+head.data+"]->");
																head=head.next;
															}					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::");	head=reverse_II(head);
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
