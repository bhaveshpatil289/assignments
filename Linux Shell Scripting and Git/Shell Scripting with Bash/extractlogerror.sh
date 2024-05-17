#!/bin/bash

# File path of the sample log file
log_file="sample.log"

# Use grep to extract all lines containing "ERROR" from the log file
error_lines=$(grep "ERROR" "$log_file")

# Use awk to parse each extracted line and print the date, time, and error message
echo "$error_lines" | awk '{print "Date:", $1, "Time:", $2, "Error:", $0}'
