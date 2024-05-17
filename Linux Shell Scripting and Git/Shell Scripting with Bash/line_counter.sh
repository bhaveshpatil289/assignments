#!/bin/bash

#Function to count number of lines in a file
count_lines(){
	local filename="$1"
	local num_lines=$(cat "$filename" | wc -l)
	echo "Number of lines in $filename: $num_lines"
}

#Main script
while true; do
	echo "Enter a filename (enter 'exit' to quit)"
	read filename

	#check if user wants to exit
	if [ "$filename" == "exit" ]; then
		echo "Exiting..."
		break;
	fi

	#check if file exits
	if [ ! -f "$filename" ]; then
		echo "File '$filename' not found."
		continue
	fi

	#call the function to count lines in the file
	count_lines "$filename"
done
