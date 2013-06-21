
import codePuzzles.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CodePuzzleRunner {

	/**
	 * @param args
	 */
private	static boolean interactiveRun=/*false;//*/true;
		static final String puzzlePrefix="codePuzzles.Puzzle";
		static HashMap<Integer,ArrayList<String>> categs=new HashMap<Integer,ArrayList<String>>();
		static String[] categIndex={"Extra","Strings & Arrays","Numbers","Linked Lists","Recursion","Sort & Search","Stacks & Queues","Trees"};
	
		static String getCateg(int no)	{ 	if( no>=1 && 
												no<=categIndex.length )	return categIndex[ no ];    //I-Categ@	pos=1
											if( no==0 )					return "EXIT";
											if( no==-1)					return categIndex[no+1];	//XtraCat@	pos=0
																		return "NONE";
										}
		static String getSubCateg(int no,int subNo)
										{ 	if( subNo>=1 && 
												subNo<=categs.get(no).size())
																		return categs.get(no).get(subNo-1);
											if( subNo==0 )				return "EXIT";
																		return "NONE";									
										}
		
	public static void CodePuzzleRunnerInit()
	{		
		for(int i=-1;i<=categIndex.length;i++)
		if(i!=0)
			categs.put(i,new ArrayList<String>());
		
//		
/*		
		//subcategs of Categ -1:Extra
			categs.get(-1).add("String Substition");
			categs.get(-1).add("Spiral Printing");
			categs.get(-1).add("Ultimate Tic Tac Toe");
//*/		
		//subcategs of Categ 1:Strings & Arrays
			categs.get(1).add("Check Unique Strings");
			categs.get(1).add("Count Words");
			categs.get(1).add("Check Palindromes");
			categs.get(1).add("Check Permutations");
			categs.get(1).add("Compress Strings");
			categs.get(1).add("Shuffle Cards");
		//subcategs of Categ 2:Numbers			
			categs.get(2).add("Find Number Pairs");
			categs.get(2).add("Find Largest Sum");
			categs.get(2).add("Swap Two Numbers");
			categs.get(2).add("Convert to Decimal");
			categs.get(2).add("Convert to Binary");
		//subcategs of Categ 3:Linked Lists
			categs.get(3).add("Reverse");
			categs.get(3).add("Find N-to-Last Element");
			categs.get(3).add("Check Palindromes");
			categs.get(3).add("Remove Duplicates");
			categs.get(3).add("Remove Node");
			categs.get(3).add("Partition");
			categs.get(3).add("Check Cyclic");
		//subcategs of Categ 4:Recursion
			categs.get(4).add("Compute Fibonacci");
			categs.get(4).add("Compute Steps");
			categs.get(4).add("Make Changes");
			categs.get(4).add("Find Subsets");
			categs.get(4).add("Find Permutations");
			
		//subcategs of Categ 5:Sort & Search
			categs.get(5).add("Group Anagrams");
			categs.get(5).add("Merge Two Arrays");
			categs.get(5).add("Find Index");
			
		//subcategs of Categ 6:Stacks & Queues
			categs.get(6).add("Create Stack From Linked List");
			categs.get(6).add("Create Queue From Linked List");
			categs.get(6).add("Create Queue From Two Stacks");
			categs.get(6).add("Sort Stack");
			
		//subcategs of Categ 7:Trees
			categs.get(7).add("Create Tree(Binary Search Tree) From Sorted Array");
			categs.get(7).add("Create Tree(Binary Tree) From Custom String");
//
/*										
			categs.get(7).add("Find Common Ancestor 1");
			categs.get(7).add("Find Common Ancestor 2");
			categs.get(7).add("Check Binary Search Tree");
			categs.get(7).add("Compute Max Height");
//*/			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub						
		
		Scanner scanner=new Scanner(System.in);
		
		String 	selCateg="";		
		int 	categI=0;		
		int		selIndex=0;

		String 	selSubCateg="";
		int 	subCategI=0;
		int		selSubIndex=0;

		int solnCount=1,selSolnCount=1;
		
		if(args.length==3)
		{
			interactiveRun=false;
			try{
			selIndex	=Integer.parseInt(args[0]);
			selSubIndex	=Integer.parseInt(args[1]);
			selSolnCount=Integer.parseInt(args[2]);
			}
			catch(NumberFormatException e1){e1.printStackTrace();scanner.close();return;}			
		}	
		
		if(!interactiveRun)	{//
		/*MY_INIT:*/ selIndex=-1;selSubIndex=3;selSolnCount=1;
		}
		
		CodePuzzleRunnerInit();
		
		do
		{

if(interactiveRun)
{
//--------------------------------------------------------------------------------------------------------			
			System.out.println("\n\nEnter Category of CodePuzzle to execute: <number>\n\n//ENTER 0 to EXIT!");
			categI=-1;
			for(String categ:categIndex)
				if(categI!=-1)
					System.out.println("<"+(++categI)+">"+categ);
				else
					System.out.println("<"+(categI++)+">"+categ);
				
				selIndex=scanner.nextInt();
//--------------------------------------------------------------------------------------------------------
}
				selCateg=getCateg(selIndex);
				System.out.println("Category Selected:"+selCateg);
				
				if(selCateg.equals("EXIT")) break;
				if(selCateg.equals("NONE")) continue;
				
if(interactiveRun)				
{
//--------------------------------------------------------------------------------------------------------											
				
			System.out.println("Enter Puzzle from \""+selCateg+"\" to execute: <number>\n\n//ENTER 0 to EXIT!");
			subCategI=0;
			for(String subCateg:categs.get(selIndex))
				System.out.println("<"+(++subCategI)+">"+subCateg);;
				selSubIndex=scanner.nextInt();
//--------------------------------------------------------------------------------------------------------
}				
				selSubCateg=getSubCateg(selIndex,selSubIndex);
				System.out.println("Puzzle Selected:"+selSubCateg);
				
				if(selSubCateg.equals("EXIT")) 					  		break;
				if(selSubCateg.equals("NONE"))	if(interactiveRun) 	 continue;
												else					break;

				  Class<?> cl=null;
			 try {		if(selIndex!=-1)
				 		cl=Class.forName(puzzlePrefix+selIndex+"_"+selSubIndex);
			 			else			 			
			 			cl=Class.forName(puzzlePrefix+"Minus1"+"_"+selSubIndex);}
			 catch(ClassNotFoundException e1)			  {e1.printStackTrace();}
			
		     try { Method intro=cl.getDeclaredMethod("getIntro");	intro.invoke(null);}
			 catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)	{e1.printStackTrace();}
if(interactiveRun)
{
//--------------------------------------------------------------------------------------------------------				  		 
		     		solnCount=1;selSolnCount=1;
				  
			 try { Method solnCt=cl.getDeclaredMethod("getSolutionCount");solnCount=(int)solnCt.invoke(null);}			 
			 catch(IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e1)						{e1.printStackTrace();}
			 
				 if(solnCount>1)
				 {
					 System.out.println("\nEnter Solution to execute: <number>\n\n//ENTER 0 to EXIT!");
				 	 selSolnCount=scanner.nextInt();
				 	if(selSolnCount==0)break;
				 	if(selSolnCount<0||selSolnCount>solnCount)continue;
				 }	 
				 else
					 selSolnCount=solnCount;//=1
//--------------------------------------------------------------------------------------------------------
}
				  System.out.println("Soln. Selected: #"+selSolnCount);
				  		 
			
			
			try{ Method run=cl.getDeclaredMethod("run",new Class[]{int.class,Scanner.class});	run.invoke(null,selSolnCount,scanner);} 
			catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)		{ e1.printStackTrace();/*TODO Auto-generated catch block*/}
						
if(interactiveRun)
{
//
/*						
			try { Thread.sleep(2000); } 
			catch(InterruptedException e) 
				{ e.printStackTrace();//TODO Auto-generated catch block 
				}
//*/
}
		//
if(!interactiveRun)			break;			
			
		}while(!selCateg.equals("EXIT")&&!selSubCateg.equals("EXIT"));
		
		scanner.close();
	}

}
