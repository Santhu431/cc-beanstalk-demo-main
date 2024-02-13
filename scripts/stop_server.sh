#!/bin/bash

# Find the PID (Process ID) of the running Spring Boot application
PID=$(ps -ef | grep 'java -jar contacts-app.jar' | grep -v grep | awk '{print $2}')

# Check if the PID is not empty (indicating the application is running)
if [ -n "$PID" ]; then
    # Stop the Spring Boot application by sending a SIGTERM signal
    kill -15 $PID
    
    # Wait for the application to stop (adjust timeout as needed)
    sleep 10
    
    # Check if the application is still running
    if ps -p $PID > /dev/null; then
        # If the application is still running after the timeout, force kill it
        kill -9 $PID
    fi
    
    echo "Spring Boot application stopped successfully."
else
    echo "Spring Boot application is not running."
fi
