#!/bin/bash

#create a directory named TestDir
mkdir -p TestDir

#change to the TestDir directory
cd TestDir

#create ten files named File1.txt, File2.txt, ..., File10.txt
for ((i=1; i<=10; i++)); do
	filename="File${i}.txt"
	echo "$filename" > "$filename"
	echo "Created $filename"
done

#go back to the previos directory
cd ..
