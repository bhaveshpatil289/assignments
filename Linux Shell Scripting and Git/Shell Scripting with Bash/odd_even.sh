#!/bin/bash

while true; do
	echo "Enter a number (enter 0 to stop):"
	read num

	#check if number is 0 if it is than exit loop
	if [ "$num" -eq 0 ]; then
		echo "Exiting..."
		break
	fi

	#check if number is even or odd
	if [ $((num%2)) -eq 0 ]; then
		echo "$num is even"
	else
		echo "$num is odd"
	fi
done
