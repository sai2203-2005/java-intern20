# 🎫 Customer Ticket Support System

A robust, console-based Customer Service Helpdesk and Support Ticketing application built in Java. This project demonstrates core Java Collections Framework concepts (`Queue` interface implemented via `LinkedList`), First-In-First-Out (FIFO) request handling, object-oriented design, input validation, and interactive CLI menu navigation.

---

## 🚀 Features

- **➕ Raise a Ticket**:
  - Registers a new customer support ticket with customer name and issue description.
  - Automatically generates and assigns unique, sequential IDs starting from `101`.
  - Enforces input validation to prevent empty or whitespace-only submissions.

- **⚙️ Process Next Ticket (FIFO)**:
  - Dequeues and resolves the oldest pending ticket from the queue using `poll()`.
  - Ensures fair, chronological service order (First-In, First-Out).
  - Handles empty queue states gracefully with informative feedback.

- **📋 View Pending Tickets**:
  - Displays all unresolved tickets currently awaiting assistance in FIFO order.
  - Formats ticket ID, customer name, and issue description clearly.

- **👁️ View Next Ticket (Peek)**:
  - Previews the upcoming ticket at the front of the queue using `peek()` without removing it.

- **🛡️ Robust Input Handling**:
  - Validates numeric menu inputs to prevent crashes from invalid characters.
  - Trims and validates text entries so tickets cannot have blank customer names or issues.

---

## 🛠️ Technologies Used

- **Language**: Java (JDK 8 or higher, JDK 17/21 recommended)
- **Data Structure**: `java.util.Queue<Ticket>` implemented with `java.util.LinkedList` for $O(1)$ constant-time enqueue (`offer`) and dequeue (`poll`) operations
- **Programming Paradigm**: Object-Oriented Programming (OOP) with clean encapsulation and model separation
- **I/O Handling**: `java.util.Scanner` for interactive command-line navigation and user input parsing

---

## 📂 Project Structure

```text
├── CustomerTicketSupport.java   # Contains Ticket model and CustomerTicketSupport main application
├── README.md                    # Project documentation
└── .gitignore                   # Ignores compiled bytecode (*.class)
```

---

## 🏗️ Architecture & Component Overview

The application is structured in [`CustomerTicketSupport.java`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java):

| Component | Type | Description |
| :--- | :--- | :--- |
| [`Ticket`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L5-L27) | Model Class | Encapsulates ticket attributes (`ticketId`, `customerName`, `issue`), constructor, getter, and formatted `toString()` output. |
| [`CustomerTicketSupport`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L29-L158) | Main Controller Class | Manages the static queue state, ticket ID generator, helper methods, and the interactive CLI menu loop. |
| [`CustomerTicketSupport.raiseTicket()`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L35-L45) | Method | Creates a new `Ticket` instance, increments ID counter, and pushes to queue via `offer()`. |
| [`CustomerTicketSupport.processTicket()`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L48-L59) | Method | Retrieves and removes the head of the queue via `poll()`, confirming resolution. |
| [`CustomerTicketSupport.displayTickets()`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L62-L73) | Method | Traverses and displays all waiting tickets in sequential FIFO order. |
| [`CustomerTicketSupport.main()`](file:///c:/Users/sivas/OneDrive/Desktop/java%20intership/CustomerTicketSupport.java#L75-L157) | Application Entry Point | Drives the command-line menu loop with input validation and user action routing. |

---

## ⚙️ Getting Started

### Prerequisites

Ensure you have the Java Development Kit (JDK) installed and configured on your system:

```powershell
javac -version
java -version
```

### Compilation

Open a terminal in the project directory and compile the Java source file:

```powershell
javac CustomerTicketSupport.java
```

This generates `CustomerTicketSupport.class` and `Ticket.class`.

### Execution

Run the compiled application:

```powershell
java CustomerTicketSupport
```

---

## 🎮 Interactive Menu & Usage

Upon launch, the application presents an interactive menu:

```text
=== CUSTOMER TICKET SUPPORT ===
1. Raise a ticket
2. Process next ticket
3. View pending tickets
4. View next ticket
5. Exit
Enter your choice: 
```

### Step-by-Step Sample Session

#### 1. Raising Tickets
```text
Enter your choice: 1
Customer name: Siva Sekhar
Describe your issue: Login portal authentication failure
Ticket created successfully!
Ticket ID: 101 | Customer: Siva Sekhar | Issue: Login portal authentication failure

Enter your choice: 1
Customer name: John Doe
Describe your issue: Payment gateway timeout
Ticket created successfully!
Ticket ID: 102 | Customer: John Doe | Issue: Payment gateway timeout
```

#### 2. Viewing the Next Ticket in Line (Peek)
```text
Enter your choice: 4
Next ticket:
Ticket ID: 101 | Customer: Siva Sekhar | Issue: Login portal authentication failure
```

#### 3. Processing the Oldest Ticket
```text
Enter your choice: 2
Processing ticket:
Ticket ID: 101 | Customer: Siva Sekhar | Issue: Login portal authentication failure
Ticket resolved successfully.
```

#### 4. Viewing Remaining Pending Tickets
```text
Enter your choice: 3

Pending tickets (FIFO):
Ticket ID: 102 | Customer: John Doe | Issue: Payment gateway timeout
```

#### 5. Exiting the System
```text
Enter your choice: 5
Exiting support system.
```

---

## 🔄 Queue Operations Summary

| Operation | Java Queue Method | Time Complexity | Behavior |
| :--- | :--- | :--- | :--- |
| **Enqueue** | `ticketQueue.offer(ticket)` | $O(1)$ | Inserts new ticket at the tail of the queue. |
| **Dequeue** | `ticketQueue.poll()` | $O(1)$ | Retrieves and removes the ticket at the head; returns `null` if empty. |
| **Peek** | `ticketQueue.peek()` | $O(1)$ | Inspects the front ticket without modifying queue state; returns `null` if empty. |
| **Traversal** | Enhanced `for` loop | $O(N)$ | Iterates through all active tickets in FIFO order. |

---

## 🛡️ Validation & Edge Cases

- **Non-Numeric Menu Choices**: `while (!sc.hasNextInt())` intercepts invalid input and reprompts the user without crashing.
- **Empty Name / Issue Detection**: `name.isBlank() || issue.isBlank()` rejects blank or space-only input.
- **Empty Queue Handling**: Both `processTicket()` and `peek()` verify whether the queue has tickets before attempting operations, outputting clear messages (`"No tickets to process."` / `"No pending tickets."`).

---

## 📄 License & Notes

This project is created for educational and internship training purposes.
