# Todo List Application

This basic Todo List Application allows users to manage their tasks with simple add, edit, delete, and search functionality.

## Features

* **Click to Display Data:** Core functionality for viewing to-do items.
* **Add New Todo List:** Create and add new tasks.
* **Edit Existing Todo List:** Modify tasks as needed.
* **Delete Existing Todo List:** Remove completed or irrelevant tasks.
* **Search Existing Todo List:** Locate specific tasks using the following search parameters:
    * Task content
    * Completion status (isDone)

## Technical Overview

* **TodoListDataSource:** A configuration class providing a static `ArrayList` as a basic data source for the Todo List repository.

## Getting Started

### Prerequisites

* Java Development Kit (JDK): [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/) (version X or later)
* Build tool (Maven or Gradle): [https://maven.apache.org/](https://maven.apache.org/) [https://gradle.org/](https://gradle.org/)
* Web Server (Embedded like Tomcat or standalone): [https://tomcat.apache.org/](https://tomcat.apache.org/)

### Installation

1. Clone this repository.
2. Build the project using your chosen build tool (e.g., `mvn clean install`)
3. Deploy the resulting artifact (typically a .war file) to your web server.

### Usage

1. Start the web server.
2. Access the application in your web browser, typically at `http://localhost:8080/` (adjust the port as needed).

## API Endpoints

* **GET /todo** - Displays all todo-list items.
* **GET /todo/{id}** - Displays a todo-list item by ID.
* **GET /todo/new** - Provides a form to add a new todo-list item.
* **GET /todo/edit/{id}** - Provides a form  to edit a todo-list item by ID.
* **GET /todo/delete/{id}** - Deletes a todo-list item by ID.
* **GET /todo/search** - Searches todo-list items by task and isDone (`?task=someTaskText&isDone=true/false`)

## Contributing

We welcome contributions to the Todo List Application! Please see our contributing guidelines (CONTRIBUTING.md or a similar file) for details.

## Future Enhancements

* Implement a persistent data store (e.g., database).
* Advanced search and filtering options.
* User authentication and authorization.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

**Let me know if you have any specific frameworks in mind (Spring Boot, etc.), and I can tailor the README further!** 
