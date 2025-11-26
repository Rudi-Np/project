Java Todo List Project

A simple Java console application for managing a Todo List using plain Java (no external libraries).
Tasks are stored in a local JSON file.

Features

Add, update, delete tasks

Mark tasks as DONE

Search tasks by text

Sort tasks by status

Persistent storage using tasks.json

Folder Structure
src/
 └── javaTask/
       ├── App.java
       ├── Task.java
       ├── Status.java
       ├── TaskRepository.java
       └── TaskService.java
tasks.json

How to Run

From the project root (not inside src):

javac -d bin src/javaTask/*.java
java -cp bin javaTask.App


Requirements

Java 8+

No external dependencies
