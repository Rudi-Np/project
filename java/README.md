## Todo List Java Project

Welcome! This project is a simple Java-based Todo List manager built using **pure Java only**, without external libraries.

Below is a structured guide similar to the VS Code Java template style.

---

## Getting Started

This project demonstrates a basic backend-like service for managing tasks, including:

* Adding tasks
* Updating tasks
* Deleting tasks
* Marking tasks as done
* Searching tasks
* Sorting tasks by status
* Storing tasks inside a local JSON file

It is fully implemented using standard Java classes.

---

## Folder Structure

src/
└── javaTask/
    ├── Main.java
    ├── Task.java
    ├── TaskRepository.java
    ├── TaskService.java
    └── Status.java  (Assumed to be an enum for task status)


> If you use VS Code, the compiled `.class` files will be generated automatically in the default `bin/` or `out/` folder depending on your configuration.

---

## Running the Project

1. Open the project folder in VS Code.
2. Make sure the Java extensions are installed.
3. Open `App.java`.
4. Run the program using the **Run** button or via terminal:

```bash
javac javaTask/*.java
java javaTask.App   
```

---

## How It Works

### **1. Task Class**

Represents a single task with:

* `id`
* `title`
* `description`
* `status` (NEW / IN_PROGRESS / DONE)

### **2. TaskRepository**

Handles saving and loading tasks from `tasks.json`.
Includes methods:

* `addTask()`
* `updateTask()`
* `deleteTask()`
* `getTaskById()`
* `listAll()`

### **3. TaskServices**

Contains additional logic:

* Marking tasks as DONE
* Searching tasks
* Sorting by status

### **4. Main (App.java)**

Provides a simple console UI that lets the user interact with the system.

---

## Example Usage

Once you run the app, you will see this menu:

```
1. Add
2. Update
3. Delete
4. List
5. Mark Done
6. Search
7. Sort by Status
0. Exit
```

You can then input your choices and manage your tasks directly through the terminal.

---

## Notes

* This project uses **standard Java only** — no external libraries.
* JSON is written manually using `FileWriter` and parsed manually using `BufferedReader`.
* Perfect for practicing object-oriented design and basic persistence.



## Algorithms Task: Increasing Subsequences

This project also includes an algorithmic exercise that extracts all strictly increasing contiguous subsequences from an integer array.

### Example Input

```
[1, 2, 3, 1, 2]
```

### Example Output

```
[1, 2, 3]
[1, 2]
```

### Algorithm Explanation

* Iterate through the array while building a temporary sequence.
* If the next number is greater than the previous → continue the sequence.
* Otherwise → store the finished sequence (if length > 1) and start a new one.
* At the end, store the last built sequence.


```
