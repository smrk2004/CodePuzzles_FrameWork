package codePuzzles;

import java.util.Scanner;

public class Puzzle6_1 {//Stacks & Queues:Create Stack From Linked List
	/**
	 * @param args
	 */	
	final static String		question	="Create a Stack Data-structure with methods: 'push()', 'pop()', 'isEmpty()' and 'peek()' ; // from Node Class{private int data;private Node next; public Node(int data, Node next){this.data=data; this.next=next;}}";		
	final static String[]   toDoString  ={"To test Created Stack DS <from Linked List>","To 'push()'"}; 		
	final static String[] 	solutionDesc={"Default /[Simple Solution]"};
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

	public static Stack s;	
	
	public class Stack
	{	
		Node_3_6 top;
		
		Stack()	{ this.top=null; }
		
		void push(int data)
		{
			if(isEmpty())					top =new Node_3_6(data,null);			
			else			{	Node_3_6 	temp=new Node_3_6(data,top);
										top=temp;
							}
		}
		
		int pop()
		{	
			int 				popData=Integer.MIN_VALUE;			
			if(!isEmpty())	{	popData=top.data;				
									top=top.next;								
							}
			else				throw new IllegalStateException("Can't Pop - Empty Stack!");				
			return 				popData;
		}
		
		boolean isEmpty()	{ return top==null; }
		
		int peek()
		{						
			if(isEmpty())		throw new IllegalStateException("Can't Peek - Empty Stack!");				
			return 				top.data;
		}	
	}			
												
	public static void run(int solnNo, Scanner sc)
	{			
		if(solnNo==1){
						try
						{		
							Puzzle6_1 p61=new Puzzle6_1();							
									s=p61.new Stack();
									
									int opCode=5;							
							do
							{	System.out.println("\nEnter Operation Code ["+toDoString[0]+"]:\n\n1.push()\n2.pop()\n3.isEmpty()\n4.peek()\n5.EXIT\n");
							
									opCode=sc.nextInt();							
								if( opCode<1 || opCode>5 )
														System.out.println("\n::Invalid Operation Code!");
								else 
								{																	
								if(opCode==1)	  	{	System.out.println("\nEnter Integer["+toDoString[1]+"]:");
														s.push(sc.nextInt());
						  							}
								if(opCode==2)			System.out.println("\npop():: "+s.pop());  
								if(opCode==3)			System.out.println("\nisEmpty():: "+s.isEmpty());
								if(opCode==4)			System.out.println("\npeek():: "+s.peek());						  					  	
								}
							}while(opCode!=5);
						}
						catch(IllegalStateException e)	{ System.err.println("\nDatastructure Error: "+e.getMessage()); }
					 }   
   		else System.out.println("\n!!![Invalid Solution #]!!!");
	}
}
