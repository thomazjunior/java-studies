# Java List Collections

This repository dives deep into Java’s **List** interface and its various implementations within the **Collections Framework**. Lists are ordered collections that allow duplicates and enable indexed access to elements, making them highly versatile for different programming needs. This project explores the key List implementations—`ArrayList`, `LinkedList`, and `Vector`—with examples and best practices.

## Table of Contents

- [Introduction](#introduction)
- [Topics Covered](#topics-covered)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **List** interface in Java provides an ordered sequence of elements. Lists are one of the most commonly used collections due to their flexibility, support for duplicates, and ability to access elements by index. This project is designed to help developers understand when to use each List type (`ArrayList`, `LinkedList`, `Vector`), how they work, and their performance characteristics.

## Topics Covered

### 1. **Overview of List Interface**
   - Understanding the `List` interface and common operations, including adding, removing, and retrieving elements by index.

### 2. **ArrayList**
   - **Characteristics**: Resizable array implementation, fast access by index, slower insertions/deletions (except at the end).
   - **Use Cases**: When random access and fast lookups are required, with fewer insertions and deletions in the middle of the list.
   - **Examples**: Basic operations, iteration, sorting, and best practices for using `ArrayList`.

### 3. **LinkedList**
   - **Characteristics**: Doubly-linked list, efficient for frequent insertions and deletions, especially at the beginning or middle.
   - **Use Cases**: Situations where elements need to be frequently added or removed, and sequential access is preferred over random access.
   - **Examples**: Queue operations (FIFO), stack operations (LIFO), and practical applications.

### 4. **Vector**
   - **Characteristics**: Synchronized version of `ArrayList`, designed for thread-safe operations.
   - **Use Cases**: Legacy applications needing thread-safe operations; generally avoided in modern Java in favor of `ArrayList` or thread-safe alternatives.
   - **Examples**: Thread-safe operations and comparison to `ArrayList`.

### 5. **Performance Comparison**
   - A comparison of time and space complexities for `ArrayList`, `LinkedList`, and `Vector`.
   - When to choose each List type based on the application's performance requirements.

### 6. **List Operations**
   - **Sorting**: Using `Collections.sort()` and `List.sort()` with custom comparators.
   - **Filtering**: Leveraging Java 8+ Streams for filtering and mapping List elements.
   - **Iteration**: Different ways to iterate over lists (e.g., for-loop, enhanced for-loop, iterator, and Stream API).

### 7. **Best Practices**
   - Tips for selecting the appropriate List type based on usage patterns.
   - Avoiding common pitfalls when using lists, such as concurrent modification and memory overhead.

## Requirements

- **Java 8 or higher**: Some examples use Java 8 features such as Streams and lambda expressions.

## Installation

1. Clone this repository:
    ```bash
    git clone https://github.com/your-username/java-list-collections.git
    cd java-list-collections
    ```

2. Compile the project:
    ```bash
    javac -d bin src/**/*.java
    ```

3. Run examples:
    ```bash
    java -cp bin examples.ListExample
    ```

## Usage

This project includes example classes for each type of List implementation. You can run each example to observe different List behaviors and understand their optimal use cases.

## Examples

The `src/examples` directory contains various example files, including:

- **ArrayListExample.java**: Demonstrates basic operations, sorting, and common uses of `ArrayList`.
- **LinkedListExample.java**: Shows queue and stack behavior using `LinkedList`.
- **VectorExample.java**: Highlights thread-safe operations with `Vector` and compares it to `ArrayList`.
- **PerformanceTest.java**: Provides benchmarks comparing `ArrayList`, `LinkedList`, and `Vector` under different operations.

## Contributing

Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request. Make sure your code follows the existing style and includes comments for clarity.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
