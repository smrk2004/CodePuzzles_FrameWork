package codePuzzles;

public class Queue_6_2Extract
{	
	public static boolean canPrintLS=true;
	
	int Qsize;								//ADDL Feature after 6_2	
	Node_3_6 head,tail;	
	
	Queue_6_2Extract()	{ this.head=this.tail=null; }
	
	void enqueue(int data)
	{
		if(isEmpty())
				head=tail=new Node_3_6(data,null);
		else
		{		tail.next=new Node_3_6(data,null);
		   tail=tail.next;
		}
		if(canPrintLS)	printLinkedListRep();
		
		++Qsize;							//ADDL Feature after 6_2
		
	}
	
	int dequeue()
	{	int 				dequeueData=Integer.MIN_VALUE;
		if(!isEmpty())	{	dequeueData =head.data;
									head=head.next;
							if(canPrintLS)	printLinkedListRep();
						}
		else 				throw new IllegalStateException("Can't dequeue - EMPTY Queue!");
		
		--Qsize;							//ADDL Feature after 6_2
		
		return dequeueData;
	}
	
	boolean isEmpty()	{ return head==null; }
	
	int	getQsize()		{ return Qsize; }	//ADDL Feature after 6_2
	
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