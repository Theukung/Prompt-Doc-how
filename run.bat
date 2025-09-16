@echo off
REM Sets the title of the command prompt window
title To-Do List Application

REM This command ensures the script runs from its own directory,
REM so you can double-click it from anywhere.
cd /d "%~dp0"

echo Compiling Java source files...
javac src\main\java\com\example\todo\*.java

REM Check if compilation failed. The 'if errorlevel 1' checks if the last command had an error.
if errorlevel 1 (
    echo.
    echo Compilation failed! Please review the errors above.
    pause
    exit
)

echo.
echo Compilation successful. Starting the application...
echo.
java -cp src\main\java com.example.todo.ToDoApp

echo.
pause