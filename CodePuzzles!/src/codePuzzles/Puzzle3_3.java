package codePuzzles;

import java.util.Scanner;

public class Puzzle3_3 {//Linked Lists:Check Palindromes
	/**
	 * @param args
	 */	
	final static String		question	="Check if a Given Linked List is a Palindrome";		
	final static String[]   toDoString  ={"To Check Palindrome"}; 		
	final static String[] 	solutionDesc={"Make Reversed List & Compare /[Simple Soln]","Make 'Half' of Reversed List & Compare/[Space Optimizatn. Soln]"};
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
								
	
	public static boolean isPalindrome_I(Node_3 head)	
	{	
		if(head==null)		return false;
		if(head.next==null)	return true;
		
		Node_3 temp=head,reverseHead=null;
		int listSize=0;
		
		while(temp!=null)
		{	
			reverseHead=new Node_3(temp.data,reverseHead);			
			temp=temp.next;			listSize++;
		}
		
		Node_3 tmpHead=head;
		
		for(int i=0;i<(listSize/2);i++)
		{	
			if(reverseHead.data!=tmpHead.data)				return false;
			reverseHead=reverseHead.next;			tmpHead=tmpHead.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome_II(Node_3 head)	
	{	
		if(head==null)		return false;
		if(head.next==null)	return true;
		
		Node_3 reverseHead=null,slow=head,fast=head;
		
		while(fast!=null&&fast.next!=null)
		{	reverseHead=new Node_3(slow.data,reverseHead);
			
			slow=slow.next;
			fast=fast.next.next;								
		}
				
	/*Expt to check where the next if is reqd.
		Node_3 tmp=head;int count=0;		while(tmp!=null){tmp=tmp.next;count++;}
					
		//inside if		 					if(count%2==0)	System.out.println("EVEN!");
											else 			System.out.println("ODD!");
		OUTPUT: "ODD!" => Only when  Odd # of List Elements, the 'fast' ptr termins. @ non-null locn 
													 		(OR)
						  Only when Even # of List Elements, the 'fast' ptr termins. @ null						  
		//---------------------------------------------------------------------------------					  
		NET:
			=> Odd-#-ofINPUTS = can't start comparing immedly./slow @mid 	//(Need slow+1)
			=>Even-#-ofINPUTS = can   start comparing immedly./slow @mid+1
		---------------------------------------------------------------------------------//
	*/
		if(fast!=null)	slow=slow.next;	
																
		while(slow!=null)
		{	if(slow.data!=reverseHead.data) return false;		
			slow=slow.next;
			reverseHead=reverseHead.next;
		}
		
		return true;
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
				System.out.println("\nReturned:NULL / NO Input Read!\n");
				  		   
			if(inputGot)
			{								
				if(solnNo==1){	System.out.print("\n::"+ isPalindrome_I(head));																																				  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+isPalindrome_II(head));							  			  							
				 	 		 }		
			}
		}		
	}
}
