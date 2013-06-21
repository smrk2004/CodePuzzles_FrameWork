package codePuzzles;

import java.util.Scanner;

public class Puzzle6_3 {//Stacks & Queues:Create Queue From Two Stacks
	/**
	 * @param args
	 */	
	final static String		question	="Create a Queue Data-structure from Two Stacks {Take Stack implem from Puzzle 6_1} with methods: 'enqueue()', 'dequeue()' and 'isEmpty()'";		
	final static String[]   toDoString  ={"To test Created Queue DS <from Two Stacks>","To 'enqueue()'"}; 		
	final static String[] 	solutionDesc={"Via the use of Inbox & Outbox Stacks /[Simple Solution]"};
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

	public static Queue Q;	
	
	public class Queue
	{
		Stack_6_1Extract inboxStack,outboxStack;		
		
		Queue()	{ inboxStack =new Stack_6_1Extract();
				  outboxStack=new Stack_6_1Extract();}				
		
		void enqueue(int data)	{  	inboxStack.push(data);	}

		int  dequeue()			{ if(isEmpty()) throw new IllegalStateException("Can't dequeue - EMPTY Queue!");										
								  if	  (outboxStack.isEmpty())									
									 while(!inboxStack.isEmpty())	
										   outboxStack.push(inboxStack.pop());
								  
									return outboxStack.pop(); }
		
		boolean isEmpty()		{ return inboxStack.isEmpty()&&outboxStack.isEmpty(); }			
	}
															
	public static void run(int solnNo, Scanner sc)
	{			
		if(solnNo==1){
						try
						{		
							Puzzle6_3 p6_3=new Puzzle6_3();							
									Q=p6_3.new Queue();
									
									int opCode=5;							
							do
							{	System.out.println("\nEnter Operation Code ["+toDoString[0]+"]:\n\n1.enqueue()\n2.dequeue()\n3.isEmpty()\n4.EXIT\n");
							
									opCode=sc.nextInt();							
								if( opCode<1 ||	opCode>4)	
														System.out.println("\n::Invalid Operation Code!");
								else 
								{																	
								if(opCode==1)	  	{	System.out.println("\nEnter Integer["+toDoString[1]+"]:");
														Q.enqueue(sc.nextInt());
						  							}
								if(opCode==2)			System.out.println("\ndequeue():: "+Q.dequeue());  
								if(opCode==3)			System.out.println("\nisEmpty():: "+Q.isEmpty());											  					  	
								}
							}while(opCode!=4);
						}
						catch(IllegalStateException e)	{ System.err.println("\nDatastructure Error: "+e.getMessage()); }
					 }   
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}
