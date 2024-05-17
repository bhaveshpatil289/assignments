#!/bin/bash
#checking if file exists

if [ -e "myfile.txt" ]; then
	echo "File exits"
else
	echo "File not found"
fi
