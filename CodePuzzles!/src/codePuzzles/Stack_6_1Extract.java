package codePuzzles;

public class Stack_6_1Extract
{	
	Node_3_6 top;
	
	Stack_6_1Extract()	{ this.top=null; }
	
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
