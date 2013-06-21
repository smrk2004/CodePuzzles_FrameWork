package codePuzzles;

import java.util.Scanner;

public class Puzzle7_2 {//Trees:Create Tree(Binary Search Tree) From Custom String
	/**
	 * @param args
	 */	
	final static String		question	="Construct a Binary Tree from \n\"Custom String\" of Format={ Eg. (A)((B)(C)(D))((E)(F)(null)) represents => [ C <- B -> D ] <-A-> [ F <- D -> null] };\t// using TreeNode Class{public int data;public TreeNode left;public TreeNode right; public TreeNode(int data){this(data,null,null);} public TreeNode(int data,TreeNode left,TreeNode right){this.data=data; this.left=left; this.right=right;}}";		
	final static String[]   toDoString  ={"Formatted Preorder Input-To Construct Binary Tree"}; 		
	final static String[] 	solutionDesc={"Default /[Simple Recursive Solution]"};
											//Solution 1		...			
 
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

	public static boolean printLevels=false;
	
	public static void printTreeInOrder(TreeNode_7_1 T, boolean printRootPt)
	{
						System.out.print("Tree printed inorder");
		if(printLevels)	System.out.print(" (Note: L=Level)");
						System.out.println(":\n");
						System.out.print("::");															
		
		printTreeInOrder(T, 0,printRootPt);
	}
	
	public static void printTreeInOrder(TreeNode_7_1 T, int level,boolean printRootPt)
	{	
		if(T==null)	return;
		
		printTreeInOrder(T.left,level+1,false);
				
							System.out.print(" ");
		if(printRootPt)		System.out.print("(Root:");
							System.out.print(T.data);
		if(printRootPt)		System.out.print(")");
		if(printLevels)		System.out.print("_[L"+level+"]");						
		
		printTreeInOrder(T.right,level+1,false);
	}
	
	public static int findStartOfRightOffset(String s)
	{
		int openParanthCount=0;
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(') openParanthCount++;
			if(s.charAt(i)==')') openParanthCount--;
			if(openParanthCount==0) return i+1;
		}				
		
		return -1;
	}
	
	public static TreeNode_7_1   build_BinaryTree_I(String s)	
	{						
		if(s.equals("null"))			return null;									       
		       
		int endOfRoot = s.indexOf(')');
		if (endOfRoot==-1)				return new TreeNode_7_1(Integer.parseInt(s));
		int      rootData=Integer.parseInt(s.substring(1,endOfRoot)); 
													//Exclude parentheses to Parse: '(root_val)'
		
		int startOfRightOffset = findStartOfRightOffset(s.substring(endOfRoot+1));						
		
	String 	left ="",
			right="";
		
			left =s.substring( (endOfRoot+1)                     +1,((endOfRoot+1)+startOfRightOffset) -1);		   
			right=s.substring(((endOfRoot+1)+startOfRightOffset) +1,						 (s.length()) -1); 	    
	    											// +/-1 excludes enclosing parentheses pair; for 'left' & 'right'
	       
		return new TreeNode_7_1(rootData,build_BinaryTree_I(left),build_BinaryTree_I(right));
	}	
	
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter String ["+toDoString[0]+"]:\nMust represent/be made to represent 'Full Binary Tree', by replacing missing node(s) w/ \"null\"\n\n Eg. (A)((B)(C)(D))((E)(F)(null)) => [ C <- B -> D ] <-A-> [ F <- D -> null]");

			String sIn="";
				   sIn=sc.nextLine().replaceAll(" ","").replaceAll("\t","");
				   
				   						int simpleFullBinTreeCheckCount=0;
			for(char c:sIn.toCharArray())
			{	
				if(c=='('||c==')')			simpleFullBinTreeCheckCount++;				
		   else if(!Character.isDigit(c)){	simpleFullBinTreeCheckCount=-1;	
																//Handle non-integer parse-able   
																//text w/ right # of parentheses
											break;																									
		   								 }	 
			}
	  			
			if (!sIn.equals("")&&simpleFullBinTreeCheckCount%3==0)									  				
				inputGot=true;			
			else
				System.out.println("\nBuilt Tree: NULL / Input Does NOT represent Full Binary Tree!!! / Invalid Input Read!\n");
	  	  
			if(inputGot)
			{				
				System.out.println("\nBuilt Tree:");
				if(solnNo==1){	TreeNode_7_1 root = build_BinaryTree_I(sIn);
				
								printTreeInOrder(root,true);								
			 	 	 		 }				
			}
		}				
	}
}
