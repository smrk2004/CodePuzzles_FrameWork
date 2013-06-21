package codePuzzles;

import java.util.Scanner;

public class Puzzle3_6 {//Linked Lists:Partition
	/**
	 * @param args
	 */	
	final static String		question	="Partition a Given Linked List around a Partition";		
	final static String[]   toDoString  ={"To Partition List","Pivot for Partition"}; 		
	final static String[] 	solutionDesc={"2-List Compose & Merge/[Simple Composition Soln]"};
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
								
	
	public static Node_3_6 partition_I(Node_3_6 head,int pivot)	
	{		
		Node_3_6 leftSt,leftEnd,rightSt,rightEnd,pass=head;
		leftSt=leftEnd=rightSt=rightEnd=null;
		
		while(pass!=null)
		{
			if(pass.data<pivot)
			{
				if(leftSt==null)leftSt=leftEnd=pass;
				else	
				{
					leftEnd.next=pass;
					leftEnd=leftEnd.next;
				}
			}
			
			if(pass.data>=pivot)
			{
				if(rightSt==null)rightSt=rightEnd=pass;
				else
				{
					rightEnd.next=pass;
					rightEnd=rightEnd.next;
				}
			}
			
			pass=pass.next;
		}
		
		if(rightEnd!=null)
		rightEnd.next=null;					//Set  LIST_END
		
		if(leftSt==null)	return rightSt;	//Left LIST EMPTY
		
		leftEnd.next=rightSt;				//Link L&R LISTS
		
		return leftSt;
	}	
													
	public static void run(int solnNo, Scanner sc)
	{	
	
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Linked List Node data value(s) <int>, Head->Tail ["+toDoString[0]+"]:\n\n//ENTER * to STOP!");			
			Node_3_6 head=null,tail=null;
			int pivot=Integer.MIN_VALUE;
			
			String sIn="";
			int iIn=Integer.MIN_VALUE;
			while(! (sIn=sc.next()).equals("*") )	
			{	
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
	  			
			if (head!=null)									  				
				inputGot=true;			
			else
				System.out.println("\nReturned Partitioned Linked List:NULL / NO Input Read! / Incorrect Input-type Read!\n");
	  	  
			if(inputGot)
			{													
				System.out.println("\nEnter Integer ["+toDoString[1]+"]:");
				try{pivot=Integer.parseInt(sc.next());}
				catch(NumberFormatException e1)
				{
					//e1.printStackTrace();
					inputGot=false;
					System.out.println("\nInvalid Pivot Value!");
				}				
			}			
			
			if(inputGot)
			{				
				System.out.println("\nPartitioned Linked List:");
				if(solnNo==1){	System.out.print("\n::");	Node_3_6 partedHead=partition_I(head,pivot);
															while(partedHead!=null)
															{
																System.out.print("["+partedHead.data+"]->");
																partedHead=partedHead.next;
															}					  							
			 	 	 		 }		
			}
		}				
	}
}
