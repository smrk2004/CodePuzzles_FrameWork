package codePuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle7_1 {//Trees:Create Tree(Binary Search Tree) From Sorted Array
	/**
	 * @param args
	 */	
	final static String		question	="Construct a Binary Search Tree from a \"Sorted array\"; // using TreeNode Class{public int data;public TreeNode left;public TreeNode right; public TreeNode(int data){this(data,null,null);} public TreeNode(int data,TreeNode left,TreeNode right){this.data=data; this.left=left; this.right=right;}}";		
	final static String[]   toDoString  ={"Sorted Input Array-To Construct Binary Search Tree"}; 		
	final static String[] 	solutionDesc={"Default-Recurse Similar to Binary Search-say: \"Binary Add\"{Algo:Find Mid->Add Root; (Start:Mid-1) for left; (Mid+1:End) for right; recurse} /[Simple Recursive Solution]"};
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
	
	
	public static TreeNode_7_1   build_BinarySearchTree_I(int[] array)	
	{						
		return build_BinarySearchTree_I(array,0,array.length-1);
	}
	
	public static TreeNode_7_1   build_BinarySearchTree_I(int[] array,int start,int end)
	{					
		if      (start>end)		return null;				
		int mid=(start+end)/2;		
		
		return new TreeNode_7_1(array[mid],
								build_BinarySearchTree_I(array,start,mid-1),
								build_BinarySearchTree_I(array,mid+1,  end) );						
	}
	
	
	public static void run(int solnNo, Scanner sc)
	{	

if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{			  
			boolean inputGot=false;
			System.out.println("\nEnter Integer Array ["+toDoString[0]+"]:\n\n(If Not Sorted, Will Auto-Sort & Feed to 'buildTree()')\n//ENTER * to STOP!");	//Can Extend # of String Input Prompts
			ArrayList<Integer> numberList=new ArrayList<Integer>();

			String sIn="";
			while( !( (sIn=sc.next()).equals("*") ) )	{	int intIn=Integer.parseInt(sIn);
															numberList.add(intIn);}
	  
			int[] numbers=null;
			if (numberList.size()!=0)
			{						  
				numbers=new int[numberList.size()];		int i=0;				  
				for(int number:numberList){ numbers[i++]=number; }
								Arrays.sort(numbers);
				inputGot=true;
			}
			else
				System.out.println("\nBuilt Tree: NULL / NO Input Read!\n");
	  
	  
			if(inputGot)
			{				
				System.out.println("\nBuilt Tree:");
				if(solnNo==1){	TreeNode_7_1 root = build_BinarySearchTree_I(numbers);
				
								printTreeInOrder(root,true);								
			 	 	 		 }				
			}
		}				
	}
}
