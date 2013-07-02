CodePuzzles_FrameWork
=====================

INTRO
-----

A Framework for practicing Java Basics+Other Interesting Puzzles+pre-packaged Implementations of Puzzles

This is a work in progress. The Solutions to Puzzles added are by no means final, and corrections & inputs are welcome.

STRUCTURE
---------

The structure loosely follows the organization of topics as in seen within the "Code Puzzles App" available at the Apple 
App Store, but has the ability to be extended.

This repo mirrors the Java Project structure of my Eclipse IDE.

A common launcher for all Puzzles is provided in the form of CodePuzzleRunner.java found in the default package. 
The individual Puzzles are created by modifying the provided template "{CLEAN} Template{PUZZLE[NO]_[NO][DOT]JAVA}",
to create files puzzles with naming structure: 

    Puzzle#_#.java  //             #=Valid Integer 
                    //      first  #=Puzzle Category  
                    //      second #=Individual Puzzle Id
                    // this convention must be followed for proper detection and launch by the launcher
                    
The launcher must be updated to include appropriate Puzzle Category & Individual Puzzle Id as required for new Puzzle.
Launcher can be used in interactive mode to run all Puzzles or in a more individual puzzle based dev mode, for targeted
coding and testing puzzle solutions.

The template provides all necessary drivers for each Code Puzzle exercise and can be readily adapted to include multiple
sub-solutions.

INTENDED USE
------------

* For someone who wants to refer to common solutions to a puzzle; pre-packaged CodePuzzle Solution Implementations are 
provided.

* For anyone who wants ONLY to practice solutions to a puzzle; CodePuzzle Solution Skeletons can be used, and they only
need fill in the logic corresponding to that puzzle title - without worrying about drivers and such.

* People are welcome to contribute new puzzle templates so others can benefit, use, modify, practise and learn using them.

INDEX
-----

Puzzle Launcher	[ Within Path: CodePuzzles_FrameWork / CodePuzzles! / src / ]

```
CodePuzzleRunner.java
```

Solved Puzzles 	[ Within Path: CodePuzzles_FrameWork / CodePuzzles! / src / codePuzzles / ]

```
// Category 1:Strings & Arrays

Puzzle1_1.java	-	"Check Unique Strings"				<2 solution(s): "ASCII Strings/[Flag Array Soln]" , "Unicode Strings/[HashMap Soln]" >

Puzzle1_2.java	-	"Count Words"						<1 solution(s): "Simple/[HashMap Soln]" >

Puzzle1_3.java	-	"Check Palindromes"					<2 solution(s): "Check subString=palindrome?/[Recursive Soln]" , "Check front=back? repeatedly/[Iterative Soln]" >

Puzzle1_4.java	-	"Check Permutations"				<2 solution(s): "Sort & Compare/[Character Array Soln]" , "Counting Character Frequencies/[HashMap Soln]" >

Puzzle1_5.java	-	"Compress Strings"					<1 solution(s): "Simple/[Loop Soln]" >

Puzzle1_6.java	-	"Shuffle Cards"						<1 solution(s): "Simple Shuffle by Swap with Random/[Bounded Index Gen. Soln]" >


// Category 2:Numbers

Puzzle2_1.java	-	"Find Number Pairs"					<3 solution(s): "BruteForce/[Simple Soln]" , "Sort & Search/[Intelligent Iterative Soln]" , "Hash & Search/[HashMap Soln]" >

Puzzle2_2.java	-	"Find Largest Sum"					<1 solution(s): "Largest Contiguous Seq. Sum/[Trivial Soln]" >		

Puzzle2_3.java	-	"Swap Two Numbers"					<2 solution(s): "+/- based/[Heterogenous op-seq Soln]" , "XOR based/[Homogenous op-seq Soln]" >

Puzzle2_4.java	-	"Convert to Decimal"				<2 solution(s): "Trivial/[Exhaustive expansion Soln]" , "Double+add/[Iterative Soln]" >

Puzzle2_5.java	-	"Convert to Binary"					<2 solution(s): "%,/ & Reverse StringBuilder/[Iterative Soln]" , "% & / /[Recursive Soln]" >


// Category 3:Linked Lists

Puzzle3_1.java	-	"Reverse"							<2 solution(s): "prev,next ptrs/[Iterative Soln]" , "tail/[Recursive Soln]" >

Puzzle3_2.java	-	"Find N-to-Last Element"			<2 solution(s): "Count Nodes & Traverse /[Bruteforce - Embedded Sys. Soln]" , "2-Pointers/[Runner Soln]" >

Puzzle3_3.java	-	"Check Palindromes"					<2 solution(s): "Make Reversed List & Compare /[Simple Soln]" , "Make 'Half' of Reversed List & Compare/[Space Optimizatn. Soln]" >

Puzzle3_4.java	-	"Remove Duplicates"					<2 solution(s): "HashMap(Non-ASCII)/Flag(ASCII) Checking/[Time Efficient Soln]" , "Nested 'for' Checking/[Space Efficient Soln]" >

Puzzle3_5.java	-	"Remove Node"						<1 solution(s): "Copy Next to Curr & Delete Next/[Slide-List-to-Delete Soln]" >

Puzzle3_6.java	-	"Partition"							<1 solution(s): "2-List Compose & Merge/[Simple Composition Soln]" >

Puzzle3_7.java	-	"Check Cyclic"						<1 solution(s): "2-Pointer Solution /[Runner Soln]" >


// Category 4:Recursion

Puzzle4_1.java	-	"Compute Fibonacci"					<3 solution(s): "Redundant Computation/[Naive-Recursive Soln]" , "Cache Optimized <HashMap> /[Dynamic Programming-Recursive Soln]" , "'savePrevious'/[Iterative Soln]" >				

Puzzle4_2.java	-	"Compute Steps"						<2 solution(s): "Redundant Computation/[Naive-Recursive Soln]..." , "Cache Optimized <HashMap> /[Dynamic Programming-Recursive Soln]" >

Puzzle4_3.java	-	"Make Changes"						<2 solution(s): "Subtract Highest denom once & call recurse - proceed to lower start denoms for recursion via loop /[Recursive Soln]" , "Optimized iterative subtract(subtract upto max possib # of max denom coin) & recurse /[Optimized-Recursive Soln]" >

Puzzle4_4.java	-	"Find Subsets"						<2 solution(s): "BitMask Method to exhaustively assemble subset combo.s /[Iterative Soln]" , "ArrayList Accumulation - Pick First(or)Last; find subsets of Remaining; Aggregate w/ picked /[Recursive Soln]" >

Puzzle4_5.java	-	"Find Permutations"					<2 solution(s): "'Take Mid; Permute Rest; Append to I' Method /[Recursive Soln 1]" , "'Take I; Permute Rest; Insert to Mid' Method /[Recursive Soln 2]" >


// Category 5:Sort & Search

Puzzle5_1.java	-	"Group Anagrams"					<1 solution(s): "Simple - Sort, Hash & Group Approach /[HashMap Soln]" >

Puzzle5_2.java	-	"Merge Two Arrays"					<1 solution(s): "MergeSort Approach/[Simple Soln]" >

Puzzle5_3.java	-	"Find Index"						<3 solution(s): "Bruteforce-Linear Search Approach /[Naive Iteration]" , "Binary Search Approach /[Iterative Solution]" , "Binary Search Approach /[Recursive Solution]" >

// Category 6:Stacks & Queues

Puzzle6_1.java	-	"Create Stack From Linked List"		<1 solution(s): "Default /[Simple Solution]" >

Puzzle6_2.java	-	"Create Queue From Linked List"		<1 solution(s): "Default /[Simple Solution]" >

Puzzle6_3.java	-	"Create Queue From Two Stacks"		<1 solution(s): "Via the use of Inbox & Outbox Stacks /[Simple Solution]" >

Puzzle6_4.java	-	"Sort Stack"						<3 solution(s): "Using intermediate Sort-Friendly Datastructure /[Simple Solution]" , "Using 2 Stacks-Insertion Sort /[Iterative Solution]" , "Using Program Stack \"implicitly\" /[Recursive Solution]" >


// Category 7:Trees

Puzzle7_1.java	-	"Create Tree(Binary Search Tree) From Sorted Array"			
														<1 solution(s): "Default-Recurse Similar to Binary Search-say: \"Binary Add\"{Algo:Find Mid->Add Root; (Start:Mid-1) for left; (Mid+1:End) for right; recurse} /[Simple Recursive Solution]" >
								
Puzzle7_2.java	-	"Create Tree(Binary Tree) From Custom String"
														<1 solution(s): "Default /[Simple Recursive Solution]" >																
```
