#!/bin/bash

# Function to print debug messages
debug() {
    if [ "$DEBUG" == "true" ]; then
        echo "DEBUG: $1"
    fi
}

# Function to create files
create_files() {
    debug "Creating files..."
    for ((i=1; i<=10; i++)); do
        filename="File${i}.txt"
        echo "$filename" > "$filename"
        debug "Created $filename"
    done
}

# Main script
# Check for debug mode
if [ "$1" == "--debug" ]; then
    DEBUG="true"
else
    DEBUG="false"
fi

# Check if the TestDir directory already exists
if [ -d "TestDir" ]; then
    echo "Directory 'TestDir' already exists."
    debug "Exiting due to existing directory."
    exit 1
fi

# Attempt to create the directory
mkdir -p TestDir

# Check if the directory was created successfully
if [ $? -ne 0 ]; then
    echo "Failed to create directory 'TestDir'."
    debug "Exiting due to failed directory creation."
    exit 1
else
    echo "Directory 'TestDir' created successfully."
fi

# Change to the TestDir directory
cd TestDir || {
    echo "Failed to change directory to 'TestDir'."
    debug "Exiting due to failed directory change."
    exit 1
}

# Create files
create_files

# Go back to the previous directory
cd ..

echo "Script execution completed successfully."
