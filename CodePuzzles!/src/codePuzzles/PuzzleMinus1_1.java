package codePuzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PuzzleMinus1_1 {//Extra:String Substitution
	/**
	 * @param args
	 */	
	final static String		question	="Find all Permutations of a Given String";		
	final static String[]   toDoString  ={"To Substitute Strings"}; 		
	final static String[] 	solutionDesc={"Naive Iteration - for one occurence of each 'toFind' String ONLY - \"Incomplete wrt. multiple Occurences\" /[Iterative Soln]", "Natural Recursion - Mulitiple Occurences of 'toFind' String /[Recursive Soln]"};
																																			//Solution 1		...			//Solution 2														 
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
	
	public static String stringSubstitution_I(String s)	
	{			
		if(s==null||s.equals(""))return s;
		String[] inputs=s.split(";");
		String[] Find_Rep=inputs[1].split(",");												
			
		String temp=inputs[0];
		int start=0,end=-1;
		boolean doPrint=false;
		boolean startBackI=true;
		
		String tempEnd="";
		String tempBeg="";
		
		if(doPrint)System.out.println();
		
		for(int i=0;i<(Find_Rep.length/2);i++)
		{
			String find=Find_Rep[i*2];
			String repl=Find_Rep[i*2+1];
									
			int startOfFound=temp.indexOf(find,start);
			
			if(startOfFound==-1)	continue;
			
			if(i==0)
			{            end=startOfFound-1;			             
			          if(end==-1)
			        	  	 startBackI=false;
			}
															
			if(!startBackI&&start>=temp.length())break;
			 if(doPrint)System.out.println("I___["+i+"]:tempBeg="+tempBeg+"\t|tempEnd="+tempEnd+"|temp="+temp);				
			if(startOfFound>=start)
			{
						tempBeg=temp.substring(0,startOfFound);
						tempBeg+=repl;
						tempBeg+=temp.substring(startOfFound+find.length());
																
						start=startOfFound+find.length();								
							temp=tempBeg;								
			}if(doPrint)System.out.println("II__["+i+"]:tempBeg="+tempBeg+"\t|tempEnd="+tempEnd+"|temp="+temp);
				
			if(startBackI&&start>=temp.length()) 
			{			
					   start=0;
					   tempEnd=temp.substring(end+1);
					   tempBeg=temp.substring(0,end+1);						   						   						   
					   		temp=tempBeg;					
						startBackI=false;																	
			}if(doPrint)System.out.println("III_["+i+"]:tempBeg="+tempBeg+"\t|tempEnd="+tempEnd+"|temp="+temp);									
		}	 if(doPrint){System.out.println();
						System.out.println("End-1:tempBeg="+tempBeg+"\t|tempEnd="+tempEnd+"|temp="+temp);}
							temp=tempBeg+tempEnd;
			 if(doPrint){System.out.println("End__:tempBeg="+tempBeg+"\t|tempEnd="+tempEnd+"|temp="+temp);
						System.out.println();}
		return temp;
	}				
	
	public static boolean boolStringSubstitution_II(String s)
	{
		if (s==null||s.equals(""))	  return false;
		
		String[] inputs=s.split(";");
		String[] Find_Rep=inputs[1].split(",");
		
		return inputs[2].equals(stringSubstitution_II(inputs[0],Find_Rep,0));		
	}
	
	public static String stringSubstitution_II(String s)
	{
		if (s==null||s.equals(""))	  return s;

		String[] inputs=s.split(";");
		String[] Find_Rep=inputs[1].split(",");

		return stringSubstitution_II(inputs[0],Find_Rep,0);		
	
	}
	
	public static String stringSubstitution_II(String s,String[] fr,int index)
	{					
		if(s.equals(""))		 return s;
		if(index>=(fr.length/2)) return s;
		
								   int fIndex=index*2,			 rIndex=fIndex+1;					
		String[] subStrings=s.split(fr[fIndex]); 				
		String 		temp   ="";			

		if(subStrings.length==0)								//Check to see if may consists of repeated seq of 'toFind' String (@fIndex of fr)
																//Case0:with 100100;100,1=>"" ret'd & 100100 Not repld. as 11
		{
				int   times	=  s.length()/fr[fIndex].length();
				while(times-->0)	temp+=fr[rIndex];
		}
		
   else if(subStrings.length==1)
		{		temp=stringSubstitution_II(subStrings[0],fr,index+1);
																//if conditional for Case1_2 below NOT triggered,this temp val ret'd
																//reduces to Case1_1
																//Case1_1:with 1111;1000,1=>'1111' should be ret'd
		
			if(subStrings[0].length()<s.length())				//Check for OMITTED 'to-Find-String' sequence at end
																//Case1_2:with 111100100;100,1=>'111'ret'd & 100100 Not repld. as 11
																//
																//Therefore do:temp=ret'd '111'+{case0(remaining) via recursive call}
			{
				String remg=s.substring(subStrings[0].length());
				temp+=stringSubstitution_II(remg,fr,index);
			}
		}		
	else{	
			for(int i=0;i<subStrings.length;i++)
			{										temp+=stringSubstitution_II(subStrings[i],fr,index+1);
				 if(i!=subStrings.length-1)			temp+=fr[rIndex];
			}		
		
																		//if conditional for Case2_2 below NOT triggered,this temp val ret'd
																		//reduces to Case2_1
																		//Case2_1:with 1001111;100,0=>'01111' should be ret'd
			
			String 						 lastOfSubStrings=subStrings[subStrings.length-1];			//Get the LAST-split-String
			String 						 lastSubStringOfS_SameLengthAsLastOfSubStrings=s.substring(s.length()-lastOfSubStrings.length());
			if( !lastOfSubStrings.equals(lastSubStringOfS_SameLengthAsLastOfSubStrings) )	
																		//  To Check if 'LAST-split-String'=='END-String-of-orig'; 
																	   	//  if Not => some 1 / more 'toFind-strings' OMITTED @end!
																	   	//							 i.e. these need to REPLACED!
																		//  To Catch Inputs of Case2_2;
																		//
																		//Case2_2:with 100111100100;100,0=>'1111'ret'd & 100100 Not repld. as 11
																		//
																		//Therefore do:temp=ret'd '0111'+{case0(remaining) via recursive call}
			
			{	String  remg=s.substring(s.indexOf(lastOfSubStrings)+lastOfSubStrings.length());
																		//	The 'remaining' string to be substituted																		
						temp=temp+stringSubstitution_II(remg,fr,index);;
			}		
		}
		
		return temp;
	}
	
	public static void run(int solnNo, Scanner sc)
	{	
		boolean interactiveMode=true;//*/false;
		
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{	if(interactiveMode)
				System.out.print("\nEnter String"/*File-name & path*/+"["+toDoString[0]+"]:");
				
				String sIn="";
				if(interactiveMode)
					sIn=sc.next();
				
				FileReader 		fr=null;
				BufferedReader 	br =null;
				
				try{
				if(!interactiveMode)
				{
						 fr = new FileReader("src\\codePuzzles\\Inputs_Minus1_1.txt");
						 br = new BufferedReader(fr);
				}												 
				if(solnNo==1){		
					if(!interactiveMode)
								while(br.ready())								
									System.out.println(stringSubstitution_I(br.readLine()));								
					else			System.out.println(stringSubstitution_I(sIn));														
							 }	
				 
				if(solnNo==2){	boolean doBoolean=false;
								
					if(!interactiveMode)
								while(br.ready())
								{								
								if(!doBoolean)
									System.out.println(stringSubstitution_II(br.readLine()));		/*fname));//*/
								else
									System.out.println(boolStringSubstitution_II(br.readLine()));									
								}
					else		{								
								if(!doBoolean)
									System.out.println(stringSubstitution_II(sIn));
								else
									System.out.println(boolStringSubstitution_II(sIn));
								}
							}					
				if(!interactiveMode)				
					br.close();
				} 
				catch (IOException e)
				{	e.printStackTrace();	}												// TODO Auto-generated catch block
		}
	}
}
