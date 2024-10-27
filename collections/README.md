# Java Collections Framework

This repository provides a comprehensive overview of Java’s **Collections Framework**, demonstrating how to use various collections to efficiently manage, store, and manipulate groups of objects. The project includes examples of `List`, `Set`, `Map`, and `Queue` implementations, along with advanced usage of the `Stream API` and best practices for selecting and using collections.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **Java Collections Framework** provides a standard way to handle groups of data objects. It includes interfaces, implementations, and algorithms that make it easier to work with collections of data without needing to design data structures from scratch. This project covers the main types of collections and demonstrates real-world scenarios to help understand their benefits, trade-offs, and appropriate use cases.

## Features

- **List**: Explore `ArrayList`, `LinkedList`, and `Vector` for ordered data storage.
- **Set**: Understand `HashSet`, `LinkedHashSet`, and `TreeSet` for unique element collections.
- **Map**: Learn about `HashMap`, `LinkedHashMap`, and `TreeMap` for key-value pair management.
- **Queue**: Use `LinkedList` and `PriorityQueue` for FIFO data handling.
- **Stream API**: Functional-style data processing with Java’s `Stream` API.
- **Utility Class**: Utility methods from `Collections` for sorting, searching, and synchronizing collections.

## Requirements

- **Java 8 or higher**: This project uses Java 8 features like `Stream API` and `default` methods in interfaces.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/java-collections-framework.git
    cd java-collections-framework
    ```

2. Compile the project:
    ```bash
    javac -d bin src/**/*.java
    ```

3. Run the examples:
    ```bash
    java -cp bin examples.CollectionsExample
    ```

## Usage

Each collection type has its own example demonstrating how it works in practical scenarios. Check the examples folder to see individual classes implementing:

- Lists for ordered and indexed storage
- Sets for unique element storage
- Maps for key-value pairs
- Queues for FIFO order handling
- Stream operations for filtering, mapping, and aggregating data

Feel free to use or modify these examples to experiment with different collection types.

## Examples

### 1. Working with Lists

- **ArrayList Example**: Demonstrates how to store and access elements by index.
- **LinkedList Example**: Shows efficient insertion and deletion operations.

### 2. Using Sets

- **HashSet Example**: Efficiently store unique elements without order.
- **TreeSet Example**: Store sorted unique elements with natural ordering.

### 3. Exploring Maps

- **HashMap Example**: Map unique keys to values, supporting fast lookups.
- **TreeMap Example**: Maintain a sorted map for ordered data retrieval.

### 4. Queue Implementations

- **LinkedList as Queue**: Demonstrates FIFO behavior in queue operations.
- **PriorityQueue**: Process elements based on natural ordering or custom comparators.

### 5. Stream API

- Examples of filtering, mapping, and reducing data using the Stream API for functional-style programming.

## Contributing

We welcome contributions! Please fork the repository, create a new branch, and submit a pull request with your improvements. Ensure code follows the project style and includes comments for clarity.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
