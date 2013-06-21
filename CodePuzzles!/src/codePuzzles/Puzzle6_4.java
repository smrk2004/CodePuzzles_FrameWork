package codePuzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Puzzle6_4 {//Stacks & Queues:Sort Stack
	/**
	 * @param args
	 */	
	final static String		question	="Sort a stack of Integers in 'ascending order' i.e smallest element pushed into stack ahead of larger ones";		
	final static String[]   toDoString  ={"To push() into Stack to be fed to 'sort()'"}; 		
	final static String[] 	solutionDesc={"Using intermediate Sort-Friendly Datastructure /[Simple Solution]","Using 2 Stacks-Insertion Sort /[Iterative Solution]","Using Program Stack \"implicitly\" /[Recursive Solution]"};
											//Solution 1		...							//Solution 2 		...							//Solution 3 		...
 
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
	
	
	public static void stackPrintByCopy(Stack_6_1Extract stackIn)
	{
		Stack_6_1Extract tempReversedStack=new Stack_6_1Extract();
		
													System.out.print  ("\nStack<top-to-bottom>:");
		if(stackIn.isEmpty())						System.out.println(" EMPTY!" );
		else					
		{											System.out.println("\n [@top] ");
		
			while(!stackIn.isEmpty())			{ 	int data=stackIn.pop();
													System.out.println("   "+data);
														 		 tempReversedStack.push(data); }			
			while(!tempReversedStack.isEmpty())		stackIn.push(tempReversedStack.pop()); 
		
													System.out.println("*BOTTOM*");
		}
	}
		
	public static void   sort_I(Stack_6_1Extract s)	
	{		
		ArrayList<Integer> stackInts=new ArrayList<Integer>();
		
		while(!s.isEmpty())	stackInts.add(s.pop());
		
		Collections.sort(stackInts);
		
		for(Integer stackInt:stackInts) s.push(stackInt);
	}
	
	public static void   sort_II(Stack_6_1Extract s)	
	{
		Stack_6_1Extract bufferStack=new Stack_6_1Extract();
									
		while(!s.isEmpty())	bufferStack.push(s.pop());
		
		while(!bufferStack.isEmpty())
		{
			int data=bufferStack.pop();
			
			while(!s.isEmpty()&&data<s.peek())			
				bufferStack.push(s.pop());			
			
			s.push(data);
		}
	}
	
	public static void  sort_III(Stack_6_1Extract s)	
	{	if(s.isEmpty())	return;
		
		int data=s.pop();
		sort_III(s);
		insert(s,data);		
	}
	
	public static void insert(Stack_6_1Extract s,int data)	
	{	if( s.isEmpty() )
		{	s.push(data);			return;	
		}		
		int 	current=s.peek();		
		if(data<current)
		{		current=s.pop();
		
				insert(s,data);
				s.push(current);	return;
		}		s.push(data);		
	}
	
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n//ENTER * to STOP!");	//Can Extend # of String Input Prompts

			String sIn="";	
			Stack_6_1Extract stack=new Stack_6_1Extract();
			
			try
			{ while( !( (sIn=sc.next()).equals("*") ) )	  stack.push(Integer.parseInt(sIn));  
			}
			catch(NumberFormatException e)				{ e.printStackTrace(); }
			
							stackPrintByCopy(stack);				  
	  										
				System.out.println("\nStack Sort Applied!");
				
				if(solnNo==1){	  sort_I(stack);					  							
			 	 	 		 }
				if(solnNo==2){	 sort_II(stack);				
				 	 		 }
				if(solnNo==3){	sort_III(stack);				
	 	 		 			 }	
				
							stackPrintByCopy(stack);									
		}   		
	}
}
