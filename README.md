CodePuzzles_FrameWork
=====================

INTRO

A Framework for practicing Java Basics+Other Interesting Puzzles+pre-packaged Implementations of Puzzles

This is a work in progress. The Solutions to Puzzles added are by no means final, and corrections & inputs are welcome.

STRUCTURE

The structure loosely follows the organization of topics as in seen within the "Code Puzzles App" available at the Apple 
App Store, but has the ability to be extended.

This repo mirrors the Java Project structure of my Eclipse IDE.

A common launcher for all Puzzles is provided in the form of CodePuzzleRunner.java found in the default package. 
The individual Puzzles are created by modifying the provided template "{CLEAN} Template{PUZZLE[NO]_[NO][DOT]JAVA}",
to create files puzzles with naming structure: 

  Puzzle#_#.java    // # = valid integer ; first #=Puzzle Category ; second #=Individual Puzzle Id
                    // this convention must be followed for proper detection and launch by the launcher
                    
The launcher must be updated to include appropriate Puzzle Category & Individual Puzzle Id as required for new Puzzle.

The template provides all necessary drivers for each Code Puzzle exercise and can be readily adapted to include multiple
sub-solutions.

INTENDED USE

* For someone who wants to refer to common solutions to a puzzle; pre-packaged CodePuzzle Solution Implementations are 
provided.

* For anyone who wants ONLY to practice solutions to a puzzle; CodePuzzle Solution Skeletons can be used, and they only
need fill in the logic corresponding to that puzzle title - without worrying about drivers and such.

* People are welcome to contribute new puzzle templates so others can benefit, use, modify, practise and learn using them.
