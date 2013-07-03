package codePuzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PuzzleMinus1_2 {//Extra:Spiral Printing
	/**
	 * @param args
	 */	
	final static String		question	="Print a 2D array<characters/numbers> ( n x m ) in 'Spiral order'(clockwise)!";		
	final static String[]   toDoString  ={"To Print Spiral - \n\t\tENTER: <n> ; <m> ; <val_1> <val_2> <val_3> ... "}; 		
	final static String[] 	solutionDesc={"Simple Divide & Conquer /[Recursive Solution]"};
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
		
	public static void spiralPrinting_I(String s)
	{
		boolean canPrintCheck=true;
		
		if (s==null||s.equals(""))	  return;

		String[] inputs=s.split(";");	String 	check=inputs[2].substring(0,1);

										while( 	check.equals(" ")||check.equals("\t"))	
										{	inputs[2]=inputs[2].substring(1);
												check=inputs[2].substring(0,1);
										}
		
		String[] stringsOfIntegersForArray=inputs[2].split("\\s");
				
		int n,m;
			n=m=0;
			
		String[][] array2D=null;
		
		try
		{	n=Integer.parseInt(inputs[0].trim());
			m=Integer.parseInt(inputs[1].trim());
			
				array2D=new String[n][m];
						
			int intIndex=0;
		
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					array2D[i][j]=stringsOfIntegersForArray[intIndex++];
		}
		catch(NumberFormatException e)	{ e.printStackTrace(); }				
		
		if(canPrintCheck)  {System.out.println();
							printToCheck2DArray_m_n(array2D,n,m);}		
		
		if(n<=0|m<=0)		return;
		if(array2D==null)	return;		
		
		spiralPrinting_I(array2D,0,0,n-1,m-1);					//Recursive call		
	}	
	
	public static void spiralPrinting_I(String[][] arr2D, int startI, int startJ, int endI, int endJ)
	{
		if(startI> endI||startJ> endJ)							return;
		
		if(startI==endI&&startJ==endJ)							//Case0: "Single Element Array"	/Base Case for 'n=m' Array
																// Pertains to: [5] & [1 2 3]
																//					  |4 5 6|
																//					  [7 8 9]
			
		{		System.out.print(arr2D[startI][startJ]+ " ");	return;
		}
		
		if(startI==endI)										//Case1: "Single Row Array"		/Base Case for Rectangular Array with n<m+1
																// Pertains to: [7 8 9] & [ 1  2  3  4  5]
																//					 	  | 6  7  8  9 10|
																//					 	  [11 12 13 14 15]			
		{	
//			for(int m=startJ;m<=endJ;m++)
//				System.out.print(arr2D[startI][m]+ " ");		return;
				printRowLR(arr2D,startI,startJ,endJ+1);			return;
		}
		
		if(startJ==endJ)										//Case2: "Single Column Array"	/Base Case for Rectangular Array with n>m-1
																// Pertains to: [ 5] & 	[ 1  2  3]
																//				| 8|	| 4  5  6|
																//				|11|	| 7  8  9|
																//						|10 11 12|
																//						[13 14 15]			
		{	
//			for(int n=startI;n<=endI;n++)
//				System.out.print(arr2D[n][startJ]+ " ");		return;
				printColTB(arr2D,startJ,startI,endI+1);			return;
		}	
				
		printRowLR(arr2D, startI, startJ  , endJ	);	//Printing Rectangular Outline-Clockwise:Top	Edge	-	  Left-to-Right
		printColTB(arr2D,   endJ, startI  , endI	);	//										:Right	Edge	-	   Top-to-Bottom
		printRowRL(arr2D,   endI,   endJ  , startJ	);	//										:Bottom	Edge	-	 Right-to-Left
		printColBT(arr2D, startJ,   endI  , startI	);	//										:Left	Edge	-	Bottom-to-Top
		
		spiralPrinting_I(arr2D,startI+1,startJ+1,endI-1,endJ-1); //Case 3: Recursive Call-to Divide the Problem; into "Next inner Rectangular array" 
	}	
	
	public static void printRowLR(String[][] arr2D, int n, int startM,int endM){for(int m=startM;m<endM;m++) System.out.print(arr2D[n][m]+" ");}
	public static void printRowRL(String[][] arr2D, int n, int startM,int endM){for(int m=startM;m>endM;m--) System.out.print(arr2D[n][m]+" ");}
	
	public static void printColTB(String[][] arr2D, int m, int startN,int endN){for(int n=startN;n<endN;n++) System.out.print(arr2D[n][m]+" ");}
	public static void printColBT(String[][] arr2D, int m, int startN,int endN){for(int n=startN;n>endN;n--) System.out.print(arr2D[n][m]+" ");}

	public static void printToCheck2DArray_m_n(String[][]arr2D,int n,int m)
	{
		System.out.println("n="+n+"|m="+m+"|");
		System.out.println("Printing Read 2D Array:");
		for(int i=0;i<n;i++)
		{	for(int j=0;j<m;j++)
			System.out.print(arr2D[i][j]+" ");
			System.out.println();
		}		
		System.out.println();
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
					sIn=sc.nextLine();
				
				FileReader 		fr=null;
				BufferedReader 	br =null;
				
				try{
				
				if(!interactiveMode)
				{
						 fr = new FileReader("src\\codePuzzles\\Inputs_Minus1_2.txt");
						 br = new BufferedReader(fr);
				}					
				else
					System.out.println("\n::");
				
				if(solnNo==1){		
					if(!interactiveMode)
								while(br.ready())
								{	System.out.println();
									spiralPrinting_I(br.readLine());
								}
					else			spiralPrinting_I(sIn);														
							 }	
				 									
				if(!interactiveMode)				
					br.close();
				} 
				catch (IOException e)
				{	e.printStackTrace();	}												// TODO Auto-generated catch block
		}
	}
}
