package codePuzzles;

import java.util.Scanner;

public class Puzzle3_5{//Linked Lists:Remove Node
	/**
	 * @param args
	 */	
	final static String		question	="Remove Node from Singly Linked List given access to that Node only";		
	final static String[]   toDoString  ={"To Make Singly Linked List","<Node Data> To Make & Pass Pointer of Node to 'remove()'(Enter Non-Tail)"}; 		
	final static String[] 	solutionDesc={"Copy Next to Curr & Delete Next/[Slide-List-to-Delete Soln]"};
											//Solution 1		...			
 
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
									
	//-----------------------------------<EXTRA>-------------------------------------->
	private static Node_3 getNode(Node_3 head,char cIn)
	{
		Node_3 tmp=head;
		while(tmp!=null)
		{
			if(tmp.data==cIn)return tmp;
			tmp=tmp.next;
		}
		return null;
	}
	//<----------------------------------</EXTRA>--------------------------------------
	
	public static void  remove_I(Node_3 node)	
	{	
		if(node.next==null)
			System.out.println(" !Tail was Passed!:[CANNOT Remove TAIL Node]");
		else
		{
			node.data=node.next.data;
			node.next=node.next.next;
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
			
			cIn=' ';
			Node_3 nodeToDel=null;
			
			if(inputGot)
			{									
				System.out.println("\nEnter Character ["+toDoString[1]+"]:");
				cIn=sc.next().charAt(0);
				nodeToDel=getNode(head,cIn);
				if(nodeToDel==null)
				{
					inputGot=false;
					System.out.println("\nFinal Linked List:ORIG / NO Matching Node found to pass to 'remove()'!\n");
				}
			}			
	  	  
			if(inputGot)
			{				
				System.out.println("\nFinal Linked List:");
				if(solnNo==1){	System.out.print("\n::");	remove_I(nodeToDel);
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
