package codePuzzles;

public class TreeNode_7_1
{
	public int data;
	public TreeNode_7_1 left;
	public TreeNode_7_1 right;
	
	TreeNode_7_1(int data)	{	this(data,null,null);	//References the next constructor 'implicitly' 
														//	via "this(int,TreeNode,TreeNode)" call
							}
	
	TreeNode_7_1(int data,TreeNode_7_1 left,TreeNode_7_1 right)
							{
								this.data =data;
								this.left =left;
								this.right=right;
							}
}

