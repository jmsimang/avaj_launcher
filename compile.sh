#!/bin/sh

echo "Finding all .java files and saving results in sources.txt file"
find . -name *.java > sources.txt
echo "Compiling all .java files into class files"
javac -sourcepath src @sources.txt

echo "Sources compiled!"
echo "Enter the SRC folder and execute the run.sh file"