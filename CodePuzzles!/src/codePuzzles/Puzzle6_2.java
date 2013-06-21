package codePuzzles;

import java.util.Scanner;

public class Puzzle6_2 {//Stacks & Queues:Create Queue From Linked List
	/**
	 * @param args
	 */	
	final static String		question	="Create a Queue Data-structure with methods: 'enqueue()', 'dequeue()' and 'isEmpty()' ; // from Node Class{private int data;private Node next; public Node(int data, Node next){this.data=data; this.next=next;}}";		
	final static String[]   toDoString  ={"To test Created Queue DS <from Linked List>","To 'enqueue()'"}; 		
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

	public static Queue Q;	
	public static boolean canPrintLS=false;
	
	public class Queue
	{	
		Node_3_6 head,tail;
		
		Queue()	{ this.head=this.tail=null; }
		
		void enqueue(int data)
		{
			if(isEmpty())
					head=tail=new Node_3_6(data,null);
			else
			{		tail.next=new Node_3_6(data,null);
			   tail=tail.next;
			}
			if(canPrintLS)	printLinkedListRep();
		}
		
		int dequeue()
		{	int 				dequeueData=Integer.MIN_VALUE;
			if(!isEmpty())	{	dequeueData =head.data;
										head=head.next;
								if(canPrintLS)	printLinkedListRep();
							}
			else 				throw new IllegalStateException("Can't dequeue - EMPTY Queue!");
			
			return dequeueData;
		}
		
		boolean isEmpty()	{ return head==null; }
		
		void printLinkedListRep()
							{	Node_3_6  temp=head;		System.out.print  ("[ @HEAD ] ");
								if(!isEmpty())
										while(temp!=null){	System.out.print  ("-> "+temp.data);
															temp=temp.next;
														 }
								else						System.out.print  ("-> null");
															System.out.println(" [ @TAIL ]");										
							}
	}
															
	public static void run(int solnNo, Scanner sc)
	{			
		if(solnNo==1){
						try
						{		
							Puzzle6_2 p62=new Puzzle6_2();							
									Q=p62.new Queue();
									
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
