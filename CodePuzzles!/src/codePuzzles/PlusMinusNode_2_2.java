package codePuzzles;

public class PlusMinusNode_2_2
		{
			private int sum;
			private int st;
			private int end;			
			private boolean isPlus=false;
			
			public PlusMinusNode_2_2(int sum,int st,int end)
			{
				this.sum=sum;
				this.st=st;
				this.end=end;
				
				if(sum>0)
					isPlus=true;													 
			}
			public int getSum()		{return 	sum;}
			public int getStart()	{return  	 st;}
			public int getEnd()		{return 	end;}
			
			public boolean isPlus()	{return  isPlus;}
			
			public void setSum(int sum){this.sum=sum;}
			public void setStart(int st){this.st=st;}
			public void setEnd(int end){this.end=end;}
		}

