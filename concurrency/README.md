# Concurrency in Java (up to Java 17)

This repository contains an overview of concurrency in Java, covering topics up to Java 17. Concurrency enables Java programs to handle multiple tasks simultaneously, making applications faster and more efficient. This document provides a summary of fundamental concepts and recent enhancements.

## Contents
1. [Introduction to Concurrency](#introduction-to-concurrency)
2. [Thread Management](#thread-management)
3. [Concurrency Utilities (`java.util.concurrent`)](#concurrency-utilities-javautilconcurrent)
4. [Atomic Variables](#atomic-variables)
5. [Advanced Concurrency Mechanisms](#advanced-concurrency-mechanisms)
6. [Recent Additions up to Java 17](#recent-additions-up-to-java-17)
7. [Best Practices](#best-practices)

---

## Introduction to Concurrency
Concurrency in Java enables multiple tasks to run simultaneously, improving the performance of applications. In Java, concurrency is managed through:
- **Threads**: Independent units of execution.
- **Processes**: Separate programs that run independently but may communicate.

Java provides built-in classes and interfaces such as `Thread` and `Runnable` to support multithreading.

## Thread Management
### Thread Lifecycle
Threads have distinct states: 
- **NEW**
- **RUNNABLE**
- **BLOCKED**
- **WAITING**
- **TIMED_WAITING**
- **TERMINATED**

### Basic Thread Operations
- **Start**: Using `start()` to run a thread.
- **Pause & Stop**: Control execution with `sleep()`, `join()`, and `interrupt()`.

### Thread Safety
Java ensures thread safety through:
- **Synchronization**: Using `synchronized` blocks or methods.
- **Locks**: Intrinsic locks prevent concurrent access to resources.

## Concurrency Utilities (`java.util.concurrent`)
The `java.util.concurrent` package provides tools to manage concurrency at a higher level than traditional threading.

### Executors
- **Executors**: Manages thread pools via `ExecutorService` and `ScheduledExecutorService`.
- **Futures & Callables**: Manage asynchronous tasks with `Future`, `Callable`, and `CompletableFuture`.

### Concurrent Collections
Thread-safe versions of collections include:
- **ConcurrentHashMap**
- **CopyOnWriteArrayList**
- **BlockingQueue**

### Locking Mechanisms
Java provides additional locking options:
- **Lock**: Interface that allows flexible locking.
- **ReentrantLock**: A lock with re-entrant capabilities.
- **ReadWriteLock**: Allows multiple readers or exclusive write access.

## Atomic Variables
The `java.util.concurrent.atomic` package offers lock-free, thread-safe operations on single variables, such as:
- **AtomicInteger**
- **AtomicBoolean**
- **AtomicReference**

These variables improve efficiency by reducing contention compared to synchronized blocks.

## Advanced Concurrency Mechanisms
Java provides additional tools for managing complex concurrency requirements.

### Fork/Join Framework
The Fork/Join Framework is suitable for data parallelism and divides tasks into smaller, recursive tasks. Key classes:
- **ForkJoinPool**
- **ForkJoinTask**

### Synchronization Barriers
Synchronization tools to coordinate multiple threads include:
- **CountDownLatch**: Blocks until a certain count reaches zero.
- **CyclicBarrier**: Allows a fixed number of threads to wait for each other.
- **Phaser**: Manages multiple phases of thread execution.

### CompletableFuture
Introduced in Java 8, `CompletableFuture` allows for non-blocking asynchronous programming with chained tasks.

## Recent Additions up to Java 17
Java 17 introduces lightweight concurrency mechanisms through Project Loom.

### Virtual Threads
Virtual threads are lightweight, high-throughput threads that aim to simplify concurrency management. They enable scaling applications without requiring heavy resources.

### Structured Concurrency
Structured concurrency (part of Project Loom) organizes tasks in a hierarchical structure, improving error handling and observability.

## Best Practices
To write efficient and error-free concurrent code:
- **Avoid Shared Mutable State**: Favor immutable data structures.
- **Use High-Level Utilities**: Prefer `java.util.concurrent` utilities over low-level threading.
- **Avoid Deadlocks**: Ensure lock ordering and use timeouts when necessary.
- **Profile and Test**: Use profilers to detect thread contention and concurrency issues.

---

## Sample Code and Exercises
Check the `examples` folder for sample code illustrating each of these concepts, including:
- **Thread Pool Usage**
- **Concurrent Collections**
- **Fork/Join Framework**
- **CompletableFuture Chaining**

For more detailed information, refer to the [Java Concurrency Documentation](https://docs.oracle.com/javase/tutorial/essential/concurrency/).

---
