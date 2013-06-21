package codePuzzles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Puzzle4_4 {//Recursion:Find Subsets
	/**
	 * @param args
	 */	
	final static String		question	="Find all subsets of a Given Set";		
	final static String[]   toDoString  ={"Comma-separated Elements of Set (eg: elem1, elem2) - To Find Subsets"}; 		
	final static String[] 	solutionDesc={"BitMask Method to exhaustively assemble subset combo.s /[Iterative Soln]","ArrayList Accumulation - Pick First(or)Last; find subsets of Remaining; Aggregate w/ picked /[Recursive Soln]"};
											//Solution 1		...			//Solution 2 		...			//Solution 3 		...
 
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
	
	public static void  findSubsets_I(String s)	
	{	
		if(s==null)						return;

		String[] str=s.split(",");				 		
		
		int  noOfSubsets=(int) Math.pow(2,str.length);
		String[] subSets=new String[noOfSubsets]; 
		
		int currIndex=0;		
		   		
	    for(int i=0;i<noOfSubsets;i++)
	    {
	    	int bitmask=i;
	    	int pos=0;		//OR 'str.length-1';
	    	
	    	if(bitmask==0) 
	    		subSets[currIndex++]="{}";	    	
	    	else
	    	{
	    		String temp;			temp="{";
	    		while(bitmask>0)
	    		{		
	    			if((bitmask&1)==1){	temp+=str[pos];	    			
	    							   	int  t=bitmask;
	    						       	if( (t>>1)!=0 )	temp+=",";	    						       
	    						      }	    		
	    			bitmask>>=1;
	    			pos++;	//OR 'pos--';
	    		}
	    								temp+="}";
	    		subSets[currIndex++]=temp;
	    	}	    		    	
	    }  		    		
		
			System.out.print(    "[ ");				
		for(String set:subSets)
			System.out.print(set+ " ");
			System.out.print(     "]");
		
	}		
	
	public static ArrayList<ArrayList<String>>  findSubsets_II(ArrayList<String> set)	
	{							
		if(set==null)	return null;
		if(set.size()==0)	{	ArrayList<ArrayList<String>>subsets=new ArrayList<ArrayList<String>>();
															subsets.add(new ArrayList<String>());
													 return subsets;
							}
		
		return findSubsets_II(set,set.size()-1);	
										//OR '0' in place of "set.size()-1"
	}
	
	public static ArrayList<ArrayList<String>>  findSubsets_II(ArrayList<String> set,int index)
	{		
		ArrayList<ArrayList<String>> subsets=new ArrayList<ArrayList<String>>();
		
		if(index<0) 					//OR 'index==set.size()'
		{	subsets.add(new ArrayList<String>());
			return subsets;
		}
		
		String lastElem=set.get(index);	//OR 'firstElem'
		ArrayList<ArrayList<String>> subsetsWithoutLast=findSubsets_II(set,index-1); 
										//OR subsetsWithoutFirst			//OR 'index+1'
		
		subsets.addAll(subsetsWithoutLast);
		
		for(ArrayList<String> subset:subsetsWithoutLast)
		{
			ArrayList<String> subsetWithLast=new ArrayList<String>(subset);	//OR 'subsetWithFirst'
			subsetWithLast.add(lastElem);
			subsets.add(subsetWithLast);			
		}
		
		return subsets;
	}
		
	public static void run(int solnNo, Scanner sc)
	{

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{						System.out.print("\nEnter String ["+toDoString[0]+"]:");
								String setIn=sc.next();
				if(solnNo==1){	System.out.print("\n::");  	findSubsets_I(setIn);					  							
			 	 	 		 }
				if(solnNo==2){	System.out.print("\n::");								
								ArrayList<String> 				set=new ArrayList<String>();
								for(String s:setIn.split(","))	set.add(s);
								
															System.out.print("[ ");													
								for(ArrayList<String> ls:	findSubsets_II(set))
								{	Iterator<String> it=ls.iterator();
															System.out.print("{");
									while(it.hasNext())
									{						System.out.print(it.next());
										if(it.hasNext())	System.out.print(",");
									}						System.out.print("} ");	
								}							System.out.print("]");
				 	 		 }		
		}
	}
}

