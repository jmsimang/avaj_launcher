# avaj_launcher
This is the first project in a series of 3 projects with a focus on Java.

## introduction
In order to create great software, one doesn’t only write code, one needs to design it first. 

This project will introduce to you the concept of UML class diagrams and ob- ject oriented design patterns, 
all implemented in the Java language. 

Writing Java code is easy since it’s very similar to C, but the real challenge is to write good OO code in Java.

You will have to implement a minimal aircraft simulation program based on a given UML class diagram. The Unified Modeling Language is used in software engineering for visualizing the design of an application. It offers programmers a standardized way of thinking about Object Oriented software, before writing any line of code.

## project goals
#### You will be provided with:
• a UML class diagram

• the must-have Object Oriented design patterns

#### What you need to know in order to be on the team that develops the simulator is:
• Interpreting class diagrams.

• Observer, Singleton and Factory design patterns.

## instructions
• You are allowed to use language features up to Java 7 included.

• You are not allowed to use any external libraries, build tools or code generators.

• Do not use the default package.

• Create your own relevant packages following the Java package naming conventions.

• Make sure you have javac and java available as commands in your terminal.

• Compile the project running the commands bellow in the root of your project folder:

     $find -name *.java > sources.txt
     $javac -sourcepath @sources.txt
     java za.co.amjsolutions.simulator.Simulator scenario.txt

## bonus
#### Bonus points will be given if:

  • You create your own custom exceptions for treating abnormal behaviour.
  
  • Your program can read the input file contents when they are encrypted in MD5.
