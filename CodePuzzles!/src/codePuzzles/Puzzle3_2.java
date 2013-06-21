package codePuzzles;

import java.util.Scanner;

public class Puzzle3_2 {//Linked Lists:Find N-to-Last Element
	/**
	 * @param args
	 */	
	final static String		question	="Return Nth-to-last Node of Given Linked List";		
	final static String[]   toDoString  ={"To Find Nth-to-Last Element","'N' Value"}; 		
	final static String[] 	solutionDesc={"Count Nodes & Traverse /[Bruteforce - Embedded Sys. Soln]","2-Pointers/[Runner Soln]"};
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
								
	
	public static Node_3 findNthToLast_I(Node_3 head,int N)	
	{			
		int count=0;
		Node_3 temp=head;
		
		while(temp!=null){temp=temp.next;count++;}
		
		int targetNodePos=count-1-N;
		
		if(targetNodePos<0)throw new IllegalArgumentException("Invalid N!");
		
		temp=head;
		
		while(targetNodePos-->0){temp=temp.next;}
			
		return temp;
	}
	
	public static Node_3 findNthToLast_II(Node_3 head,int N)	
	{	
		Node_3 runner=head;
		
		while(N-->0&&runner!=null){runner=runner.next;}
			
		Node_3 curr=head;
		while(runner.next!=null)
		{	curr=curr.next;
			runner=runner.next;
		}
		
		return curr;
	}
													
	public static void run(int solnNo, Scanner sc)
	{
	
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Linked List Node data value(s) <char>, Head->Tail ["+toDoString[0]+"]:\n\n( String Input gets truncated to 'char' )\n//ENTER * to STOP!");
			Node_3 head=null,tail=null;

			char cIn=' ';int N=Integer.MIN_VALUE;int listSize=0;
			while(! ((cIn=sc.next().charAt(0))=='*') )	
			{
				if(head==null)
					head=tail=new Node_3(cIn,null);				
				else
				{	     tail.next=new Node_3(cIn,null);
				    tail=tail.next;
				}
				listSize++;
			}			
			
			if (head!=null)									  				
				inputGot=true;			
			else 
				System.out.println("\nReturned NthToLast Linked List Node:NULL / NO Input Read!\n");
			

			if(inputGot)
			{
			System.out.print("\nEnter Integer ["+toDoString[1]+"]:");
			N=sc.nextInt();
			inputGot=(N>=0&&N<listSize)?true:false;
			
			if(!inputGot)   
				System.out.println("\nReturned NthToLast Linked List Node:NULL / Invalid N!\n");
			}			 	   
	  		   
			if(inputGot)
			{				
				System.out.println("\nReturned NthToLast Linked List Node:");
				if(solnNo==1){	System.out.print("\n::["+ findNthToLast_I(head,N).data+"]");																																				  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::["+findNthToLast_II(head,N).data+"]");							  			  							
				 	 		 }		
			}
		}		
	}
}
