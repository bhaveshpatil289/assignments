#!/bin/bash

# File path of the sample log file
log_file="sample.log"

# Create or overwrite the sample log file
cat <<EOF > "$log_file"
2024-05-16 12:00:00 INFO: Application started
2024-05-16 12:01:00 ERROR: Failed to connect to database
2024-05-16 12:02:00 DEBUG: Processing request 1
2024-05-16 12:03:00 ERROR: Invalid input received
2024-05-16 12:04:00 WARNING: Resource low
2024-05-16 12:05:00 ERROR: Server crashed unexpectedly
2024-05-16 12:06:00 INFO: Application stopped
EOF

echo "Sample log file '$log_file' created successfully."
