#!/bin/bash

# Check if correct number of arguments are provided
if [ "$#" -ne 3 ]; then
    echo "Usage: $0 input_file old_text new_text"
    exit 1
fi

input_file="$1"
old_text="$2"
new_text="$3"
output_file="${input_file%.txt}_modified.txt"

# Perform replacement using sed and write the result to a new file
sed "s/$old_text/$new_text/g" "$input_file" > "$output_file"

echo "Replacement completed. Modified content saved to $output_file."
