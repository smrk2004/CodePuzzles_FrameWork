package codePuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle2_2 {//Numbers:Find Largest Sum
	/**
	 * @param args
	 */	
	final static String		question	="Find largest sum of Contiguous Elements in Array";		
	final static String[]   toDoString  ={"To find Largest Sum"}; 		
	final static String[] 	solutionDesc={"Largest Contiguous Seq. Sum/[Trivial Soln]"};//,"+/-Seq Aggregate Lists/[Custom (Wasteful) Soln]"};
											//Solution 1		...			//Solution 2 		...
 
	final static int 		solutionCount=solutionDesc.length;
	final static boolean 	enableIndexPrint=false;
	
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
								

	public static int  maxSum_I(int[] numbers)	
	{	
		int sum=0,maxSum=Integer.MIN_VALUE;
		for(int num:numbers)
		{			
				sum+=num;				
			if(sum>=0){
					   maxSum=Math.max(maxSum, sum);
					  }
			else 	  sum=0;			
		}
					
		if(maxSum==Integer.MIN_VALUE)return 0;
		
		return maxSum;
	}
	
	public static int maxSum_II(int[] numbers)		//SUCKS! Dont DO THIS!	
	{
		int start=0,end=numbers.length-1;
		while(numbers[start]<0 && start<end)start++;
		while(numbers[end]  <0 && start<end) end--;
		
		
		if(start==end)	if(numbers[start]<0)	return 0;
						else 					return numbers[start];
				
		return maxSum_plusMinus(numbers,start,end);											
	}
		
	
	private static int maxSum_plusMinus(int[] no_s,int start,int end)
	{	
		
		ArrayList<PlusMinusNode_2_2> plusSeqs=new ArrayList<PlusMinusNode_2_2>();
		ArrayList<PlusMinusNode_2_2>  negSeqs=new ArrayList<PlusMinusNode_2_2>();
		boolean printPlusMinusNodes=false;
		
		for(int i=start;i<=end;i++)
		{
			int subSt=i,subEnd=i;	
			int sum=0;
			if(no_s[i]>=0)		{
									sum+=no_s[i];
									
									while(i+1<=end&&no_s[i+1]>=0) 
									{	subEnd++;
										sum+=no_s[i+1];i++;
									}
									PlusMinusNode_2_2 p=new PlusMinusNode_2_2(sum,subSt,subEnd);
									plusSeqs.add(p);
								}
			else if(no_s[i]<0)	{	sum+=no_s[i];								
									
									while(i+1<=end&&no_s[i+1]<0)
									{	subEnd++;
										sum+=no_s[i];i++;
									}
									PlusMinusNode_2_2 m=new PlusMinusNode_2_2(sum,subSt,subEnd);
									negSeqs.add(m);
								}
		}
		//PRINT INITIAL-------------------------------------------------------------------------------------------------
		if(printPlusMinusNodes)
		{
			System.out.println("\n\n[INIT]>");
			if(plusSeqs.size()>0)
			{	System.out.println("+Seqs:");
				for(PlusMinusNode_2_2 p:plusSeqs)System.out.print("s:"+p.getSum()+",st:"+p.getStart()+",end:"+p.getEnd()+"|-->");
			}
		
			if(negSeqs.size()>0)
			{	System.out.println("\n-Seqs:");
				for(PlusMinusNode_2_2 n:negSeqs)System.out.print("s:"+n.getSum()+",st:"+n.getStart()+",end:"+n.getEnd()+"|-->");
			}
		}
		//--------------------------------------------------------------------------------------------------------------
		
		if(negSeqs.size()==0)	return plusSeqs.get(0).getSum(); //Only 1 positive Sum Seq Exists!
		
		int tempMaxSum=Integer.MIN_VALUE;
		
		int retMaxI=0;
		
		for(int pI=0;pI<plusSeqs.size();)
		{	
			  int tmp1=Integer.MIN_VALUE;
				
			  if((tmp1=plusSeqs.get(pI).getSum())>tempMaxSum)
			  {	
				if(enableIndexPrint)
					retMaxI=pI;
				tempMaxSum=tmp1;
			  }///*EQV:*/	tempMaxSum=Math.max(tempMaxSum, plusSeqs.get(pI).getSum());
			  
			if(pI+1<plusSeqs.size())
			{
			  int tmp2=Integer.MIN_VALUE;
			
			  if((tmp2=plusSeqs.get(pI+1).getSum())>tempMaxSum)
			  {	
				if(enableIndexPrint)
					retMaxI=pI+1;
				tempMaxSum=tmp2;
			  }	///*EQV:*/	tempMaxSum=Math.max(tempMaxSum, plusSeqs.get(pI+1).getSum()); //pI+1 exists;
			
			int s=Integer.MIN_VALUE;
			if((s=(plusSeqs.get(pI).getSum()+negSeqs.get(pI).getSum()+plusSeqs.get(pI+1).getSum()))>=tempMaxSum)
			{
				if(enableIndexPrint)
					retMaxI=pI;
				
			plusSeqs.get(pI).setSum(s);
			plusSeqs.get(pI).setEnd(plusSeqs.get(pI+1).getEnd());
			
			plusSeqs.remove(pI+1);
			negSeqs.remove(pI);
			tempMaxSum=s;
			}
			else pI++;
			}
			else pI++;
		}
		
		//PRINT FINAL---------------------------------------------------------------------------------------------------
		if(printPlusMinusNodes)
		{
		System.out.println("\n\n[FINAL]>");
				if(plusSeqs.size()>0)
				{	System.out.println("+Seqs:");
					for(PlusMinusNode_2_2 p:plusSeqs)System.out.print("s:"+p.getSum()+",st:"+p.getStart()+",end:"+p.getEnd()+"|-->");
				}
				
				if(negSeqs.size()>0)
				{	System.out.println("\n-Seqs:");
					for(PlusMinusNode_2_2 n:negSeqs)System.out.print("s:"+n.getSum()+",st:"+n.getStart()+",end:"+n.getEnd()+"|-->");
				}
		}
		//--------------------------------------------------------------------------------------------------------------
				
		
		//int max=Integer.MIN_VALUE;
		
		//for(plusMinusNode p:plusSeqs)			if(p.getSum()>=max)max=p.getSum();
		
		if(enableIndexPrint)
			{System.out.println("\n[@Index of MaxSubSeq<st:"+plusSeqs.get(retMaxI).getStart()+",end:"+plusSeqs.get(retMaxI).getEnd()+">]");}
		
		return tempMaxSum;
	}
												
	public static void run(int solnNo, Scanner sc)
	{
		if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n//ENTER -999999999 to STOP!");	//Can Extend # of String Input Prompts
			ArrayList<Integer> numberList=new ArrayList<Integer>();

			int intIn=Integer.MIN_VALUE;
			while( !( (intIn=sc.nextInt()) == -999999999 ) )	{numberList.add(intIn);}
	  
			int[] numbers=null;
			if (numberList.size()!=0)
			{						  
				numbers=new int[numberList.size()];		int i=0;				  
				for(int number:numberList){numbers[i++]=number;}
				
				inputGot=true;
			}
			else
				System.out.println("\nReturned MaxSum:NULL / NO Input Read!\n");
	  
	  
			if(inputGot)
			{				
				System.out.println("\nReturned MaxSum:");
				if(solnNo==1){	System.out.print("\n::"+ maxSum_I(numbers));					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::"+maxSum_II(numbers));		  			  							
				 	 		 }		
			}
		}
	}
}
