package codePuzzles;

import java.util.Random;
import java.util.Scanner;

public class PuzzleMinus1_3 {//Extra:Ultimate Tic Tac Toe
	/**
	 * @param args
	 */	
	final static String		question	="Code an Ultimate Tic Tac Toe Game=\"Tic Tac Toe with a Twist\":(A grid of 9 mini-tic-tac-toes; to win must win three smaller ones in a line; note: opponent picks next mini-tic-tac-toe for you to make a move!)";		
	final static String[]   toDoString  ={"Select your Mark[X or O]"," Grid-spot to place your mark: {1= Top-Left, 2= Top-Center, 3= Top-Right, 4= Middle-Left, 5= Middle-Center, 6= Middle-Right, 7= Bottom-Left, 8= Bottom-Center, 9= Bottom-Right} "," Sub-grid Choice for Opponent's move: {1= Top-Left, 2= Top-Center, 3= Top-Right, 4= Middle-Left, 5= Middle-Center, 6= Middle-Right, 7= Bottom-Left, 8= Bottom-Center, 9= Bottom-Right} "}; 		
	final static String[] 	solutionDesc={"Naive Game /[Simple Solution]"};
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
	
	public static char yourMark='X',opponentsMark='O';
	
	final static int MINI_GRID_ROW_SIZE=3;
	final static int MINI_GRID_COL_SIZE=MINI_GRID_ROW_SIZE;	//Because Tic Tac Toe gets unfair on an asymmetric Board!
	
	private static class miniGrid
	{
		char[][] miniGrid;				
		
		final static int maxOccupancy=MINI_GRID_ROW_SIZE*MINI_GRID_COL_SIZE;
		int currOccupancy;		
		int miniGridState;
		
		miniGrid()
		{							
			miniGrid=new char[MINI_GRID_ROW_SIZE][MINI_GRID_COL_SIZE];
			currOccupancy=0;
			miniGridState=-1;
			
			for(int i=0;i<MINI_GRID_ROW_SIZE;i++)
			for(int j=0;j<MINI_GRID_COL_SIZE;j++)
					miniGrid[i][j]=' ';						
		}		
		
		void printMiniGridRow(int i)
		{				
			for(int j=0;j<MINI_GRID_COL_SIZE;j++)
				System.out.print  (miniGrid[i][j]+" |");																	
		}
		
		static int  getMiniGridSize()		{ return maxOccupancy; }
		void setMiniGridAt(int index,char c){	 	 miniGrid[(index-1)/MINI_GRID_COL_SIZE]
															 [(index-1)%MINI_GRID_COL_SIZE]=c; 	
											  currOccupancy++;									}
		int  getMiniGridAt(int index)		{ return miniGrid[(index-1)/MINI_GRID_COL_SIZE]
												         	 [(index-1)%MINI_GRID_COL_SIZE]; 	}
		
		boolean isFull()					{ return currOccupancy==maxOccupancy; }		
		boolean canMakeMove()				{ return !isFull(); /*miniGridState==-1;*/ }		
		boolean canMakeMove(int pos)	
		{	
			if(pos<1||pos>maxOccupancy)		return false;
			if(!canMakeMove()/*miniGridState!=-1*/)
											return false;	
			if(getMiniGridAt(pos)==' ')		return  true;
						
			return false;
		}
		
		void makeMove(int who,int pos)		 
		{
			if(isFull())					return;			
			if(pos<1||pos>maxOccupancy)		return;
			if(who<1||who>2)				return;
			
			if(who==1)	setMiniGridAt(pos,yourMark);
			else		setMiniGridAt(pos,opponentsMark);											
			
			if(wasNotFinalizedWithWinOrDraw())
			{
				checkIfYouWon();					//Checks & Notes your 		Win (Sets miniGridState=1)
				checkIfOpponentWon();				//Checks & Notes opponent's Win (Sets miniGridState=2)
				checkIfDraw();						//Checks & Notes Draw 			(Sets miniGridState=0)
			}
		}
		
		boolean wasItYourWin()		{ return miniGridState==1;  }
		boolean wasItOpponentsWin()	{ return miniGridState==2;  }
		@SuppressWarnings("unused")
		boolean wasItADraw()		{ return miniGridState==0;  }
		boolean wasNotFinalizedWithWinOrDraw()
									{ return miniGridState==-1; }
		
		void checkIfYouWon()
		{
		  if(checkRowWin(1) |
			 checkColWin(1) |
			 checkDiagWin(1) )		miniGridState=1; 
		}
		
		void checkIfOpponentWon()
		{ 
		  if(checkRowWin(2) |
			 checkColWin(2) |
			 checkDiagWin(2) )		miniGridState=2; 
		}
		
		void checkIfDraw()
		{ 
		  if(isFull() &&			miniGridState==-1)
			  						miniGridState=0; 
		}
		
		boolean checkRowWin(int who)
		{
			boolean won=false;
			
			for(int r=0;r<MINI_GRID_ROW_SIZE;r++)
					won=won||checkRow(who,r);							
			return 	won;
		}
		
		boolean checkColWin(int who)
		{
			boolean won=false;
			
			for(int c=0;c<MINI_GRID_COL_SIZE;c++)
					won=won||checkCol(who,c);							
			return 	won;
		}
		
		
		boolean checkRow(int who,int row)
		{	
			boolean won=true;
			
			for(int j=0;j<MINI_GRID_COL_SIZE;j++)
			{
				if(who==1)		won=won&&(miniGrid[row][j]==yourMark	 );
				else			won=won&&(miniGrid[row][j]==opponentsMark);	// since "!=yourMark" may also be triggered by grid-spot with ' ' value
			}				
					
			return won;
		}
				
		boolean checkCol(int who,int col)
		{	
			boolean won=true;
			
			for(int i=0;i<MINI_GRID_ROW_SIZE;i++)
			{
				if(who==1)		won=won&&(miniGrid[i][col]==yourMark	 );
				else			won=won&&(miniGrid[i][col]==opponentsMark);	// since "!=yourMark" may also be triggered by grid-spot with ' ' value
			}				
					
			return won;
		}
		
		boolean checkDiagWin(int who)
		{			
			return 	checkForwardDiagonal_I(who) |
					checkReverseDiagonal_II(who);			
		}
		
		boolean checkForwardDiagonal_I(int who)
		{			
			boolean won=true;
			
			for(int i=0;i<MINI_GRID_COL_SIZE;i++)
			{
				if(who==1)		won=won&&(miniGrid[i][i]==yourMark		);
				else			won=won&&(miniGrid[i][i]==opponentsMark	);						// since "!=yourMark" may also be triggered by grid-spot with ' ' value
			}
			return won;
		}
		
		boolean checkReverseDiagonal_II(int who)
		{
			boolean won=true;

			for(int i=0;i<MINI_GRID_ROW_SIZE;i++)
			{
				if(who==1)		won=won&&(miniGrid[i][MINI_GRID_COL_SIZE-1-i]==yourMark		);
				else			won=won&&(miniGrid[i][MINI_GRID_COL_SIZE-1-i]==opponentsMark);	// since "!=yourMark" may also be triggered by grid-spot with ' ' value
			}
			return won;			
		}
	}
		
	final static int _GRID_ROW_SIZE=3;
	final static int _GRID_COL_SIZE=_GRID_ROW_SIZE;	//Because Tic Tac Toe gets unfair on an asymmetric Board!	
	
	private static class grid
	{
		miniGrid gridSet[][];				
		
		final static int maxOccupancy=_GRID_ROW_SIZE*_GRID_COL_SIZE;										
		int currOccupancy;		
		int gridState;								
		
		grid()
		{						
			gridSet=new miniGrid[_GRID_ROW_SIZE][_GRID_COL_SIZE];
			currOccupancy=0;
			gridState=-1;
			
			for(int i=0;i<_GRID_ROW_SIZE;i++)
			for(int j=0;j<_GRID_COL_SIZE;j++)
					gridSet[i][j]=new miniGrid();						
		}		
		
		void printGrid()
		{
			System.out.println("\nGameBoard-State:\n");
			
			String  midBreakFrag="",	terminatorFrag="",  
					midBreak    ="",	terminator    ="";
			
			for(int miniC=0;miniC<(MINI_GRID_COL_SIZE-1);miniC++)
			{	  	midBreakFrag+="---";	terminatorFrag+="___";				}
					midBreakFrag+="--+";	terminatorFrag+="__|";
				  
			for(int c=0;c<_GRID_COL_SIZE;c++)	
			{		midBreak+=midBreakFrag; terminator+=terminatorFrag;			}
			
			System.out.println(midBreak);
			
			for(int i=0;i<_GRID_ROW_SIZE;i++)
				for(int j=0;j<MINI_GRID_ROW_SIZE;j++)
				{	for(int k=0;k<_GRID_COL_SIZE;k++)
						gridSet[i][k].printMiniGridRow(j);						
					
													System.out.println();
					if((j+1)%MINI_GRID_ROW_SIZE==0)	System.out.println(terminator);
											
				}
		}
		
		void printWinner()		{ if(canMakeMove())		System.out.println("Game in Progress!");
		
								  if(wasDraw()		  )	System.out.println("Game was a Draw!");
								  if(wasYourWin()	  )	System.out.println("You Won!");
								  if(wasOpponentsWin())	System.out.println("Opponent Won!");
								}		
		
		static int getMiniGridSize() {	return  miniGrid.getMiniGridSize();	}
		static int getGridSize()	 {	return  maxOccupancy;	}	
		miniGrid getGridAt(int index){	return	gridSet[(index-1)/_GRID_COL_SIZE]
													   [(index-1)%_GRID_COL_SIZE]; 	}
				
		boolean isFull()		{ return currOccupancy==maxOccupancy;}
		boolean canMakeMove()	{ return gridState==-1;	}
		boolean canMakeMove(int grid)	
		{ 										
			if(grid<1||grid>maxOccupancy)	return false;
			if(!canMakeMove())				return false;
			
			return getGridAt(grid).canMakeMove();						
		}
		
		boolean canMakeMove(int grid,int pos)	
		{ 	
			if(grid<1||grid>maxOccupancy)	return false;
			if(!canMakeMove())				return false;		
			
			return getGridAt(grid).canMakeMove(pos);						
		}		
				
		void makeMove(int who,int grid,int pos)		//Call ONLY after 'true' from canMakeMove(grid,pos) 
		{
			if(isFull())					return;			
			if(grid<1||grid>maxOccupancy)	return;
			if(who<1||who>2)				return;			

			miniGrid currMiniGrid;
					(currMiniGrid=getGridAt(grid)).makeMove(who, pos);
				  if(currMiniGrid.isFull())		
					  							currOccupancy++;							
				  
			checkIfYouWon();						//Checks & Notes your 		Win (Sets gridState=1)
			checkIfOpponentWon();					//Checks & Notes opponent's Win (Sets gridState=2)
			checkIfDraw();							//Checks & Notes Draw 			(Sets gridState=0)
				  						
			ourGrid.printGrid();
		}
		
		boolean wasYourWin()		{ return gridState==1; }
		boolean wasOpponentsWin()	{ return gridState==2; }
		boolean wasDraw()			{ return gridState==0; }
		
		void checkIfYouWon()
		{			
			if(checkRowWin(1) |
			   checkColWin(1) |
			   checkDiagWin(1) )	gridState=1;			
		}
		
		void checkIfOpponentWon()
		{
			if(checkRowWin(2) |
			   checkColWin(2) |
			   checkDiagWin(2) )	gridState=2;			
		}

		void checkIfDraw()
		{ 
		  if(isFull() &&			gridState==-1)
			  						gridState=0; 
		}						
		
		boolean checkRowWin(int who)
		{
			boolean won=false;
			
			for(int r=0;r<_GRID_ROW_SIZE;r++)			
					won=won||checkRow(who,r);							
			return 	won;
		}
		
		boolean checkColWin(int who)
		{
			boolean won=false;
			
			for(int c=0;c<_GRID_COL_SIZE;c++)
					won=won||checkCol(who,c);							
			return 	won;
		}		
		
		boolean checkRow(int who,int row)
		{				
			boolean won=true;			

			for(int j=0;j<_GRID_COL_SIZE;j++)
			{
				if(who==1)		won=won&&(	gridSet[row][j].wasItYourWin()		);
			    else			won=won&&( 	gridSet[row][j].wasItOpponentsWin() );
			}				
					
			return won;
		}					
		
		boolean checkCol(int who,int col)
		{				
			boolean won=true;

			for(int i=0;i<_GRID_ROW_SIZE;i++)
			{
				if(who==1)		won=won&&(	gridSet[i][col].wasItYourWin()		);
			    else			won=won&&(	gridSet[i][col].wasItOpponentsWin() );
			}									
			return won;
		}
			
		boolean checkDiagWin(int who)
		{			
			return 	checkForwardDiagonal_I(who) |
					checkReverseDiagonal_II(who);			
		}
		
		boolean checkForwardDiagonal_I(int who)
		{			
			boolean won=true;
			
			for(int i=0;i<_GRID_COL_SIZE;i++)
			{
				if(who==1)		won=won&&( gridSet[i][i].wasItYourWin()		 );			
				else			won=won&&( gridSet[i][i].wasItOpponentsWin() );			
			}
		
			return won;
		}
		
		boolean checkReverseDiagonal_II(int who)
		{
			boolean won=true;

			for(int i=0;i<_GRID_ROW_SIZE;i++)
			{
				if(who==1)		won=won&&(	gridSet[i][_GRID_COL_SIZE-1-i].wasItYourWin()		);
				else			won=won&&(	gridSet[i][_GRID_COL_SIZE-1-i].wasItOpponentsWin()	);
			}
			
			return won;			
		}
	}

	private static grid ourGrid=new grid();
	
	private static class randomResponsePlayer
	{
		static int target;
		static boolean canStart;
		final static Random r=new Random();				
		
		boolean canStart()					{ return 	canStart;						}
		randomResponsePlayer()				{ 			canStart=r.nextBoolean();
															  
												do	{ target=0+r.nextInt(grid.getGridSize()+1); }
												while(!ourGrid.canMakeMove(target));	
											}				
		
		void 	setTarget(int targ)			{			target=targ; }
		int 		getTarget()				{ return 	target;		 }
		
		void makeMove()
		{
			if(ourGrid.canMakeMove())
			{	
				int pos;
				do		{ pos=   0+r.nextInt(grid.getMiniGridSize()+1); } 
				while( !ourGrid.canMakeMove(target,pos));
						ourGrid.makeMove(2, target, pos);				
						
				if(ourGrid.canMakeMove())
				{					
					do	{ target=0+r.nextInt(    grid.getGridSize()+1); } 
					while(!ourGrid.canMakeMove(target));
				}
										
			}
		}		
	}
	
	private static randomResponsePlayer opponent=new randomResponsePlayer();
	
	private static String readKeyedInput(int toDoStringId,Scanner sc)
	{
		System.out.print("\nEnter Integer["+toDoString[toDoStringId]+"]:");
		return sc.next();
	}
	
	public static void run(int solnNo, Scanner sc)
	{			
		
if(solnNo<1||solnNo>getSolutionCount())
			  System.out.println("\n!!![Invalid Solution #]!!!");
		else
		{				
				System.out.print("\nEnter Character["+toDoString[0]+"]:"); 
				
				char   cIn=sc.next().charAt(0);
				
					if(cIn=='X')	{/* Do NOTHING! default vals hold */}
			   else if(cIn=='O')	{	yourMark=opponentsMark;
			   									 opponentsMark='X';		}
			   else					{	yourMark=cIn;					}										
				
				if(solnNo==1){
								/*//
								   	<Custom INPUT Format>:
								   										 
										while(!ourGrid.canMakeMove());ourGrid.makeMove(<int:playerID>,<int:miniGridID>,<int:smallGridSpotID>);
								//*/
					
									 ourGrid.printGrid();
					
								if(!(ourGrid.wasYourWin()|ourGrid.wasOpponentsWin()|ourGrid.wasDraw()))
								{	
									String 	inter="";
									
									if(opponent.canStart())
									{	int targ;
										do
										{	boolean isNumber=true;
										
											do
											{	inter=readKeyedInput(2,sc);
																					isNumber=true; 		
												for(char c: inter.toCharArray())
													if(!Character.isDigit(c))		isNumber=false;
										
											}while(!isNumber);
											
											targ=sc.nextInt();
											
										}while(targ<1||targ>grid.getGridSize());
										opponent.setTarget(targ);

										opponent.makeMove();
									
									}
								
									
									while(ourGrid.canMakeMove())
									{
										int targetSubGrid=opponent.getTarget();

										int target;
											
											System.out.print("\nOpponent Chose subGrid \'# "+targetSubGrid+"\' for Your Move!");
											
										do
										{	boolean isNumber=true;
										
											do
											{	inter=readKeyedInput(1,sc);
																				isNumber=true; 		
											for(char c: inter.toCharArray())
												if(!Character.isDigit(c))		isNumber=false;
											
											}while(!isNumber);
											
											target=Integer.parseInt(inter);
											
										}while((target<1||target>grid.getMiniGridSize())||!ourGrid.canMakeMove(targetSubGrid,target));
										
											ourGrid.makeMove(1, targetSubGrid, target);
											
										if(!ourGrid.canMakeMove()) break;
											
										do
										{	
											boolean isNumber=true;
											
											do
											{	inter=readKeyedInput(2,sc);												   		
																				isNumber=true;											
											for(char c: inter.toCharArray())
												if(!Character.isDigit(c))		isNumber=false;
											
											}while(!isNumber);																							
											
											targetSubGrid=Integer.parseInt(inter);
											
										}while((target<1||target>grid.getGridSize())||!ourGrid.canMakeMove(targetSubGrid));
											
											opponent.setTarget(targetSubGrid);
											opponent.makeMove();
									}
								}									
									System.out.print("\n::");
									ourGrid.printWinner();
							 }	
				 											
		}
	}
}