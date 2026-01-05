# Java Collections Framework - Complete Guide

## Table of Contents
1. [Overview](#overview)
2. [Core Interfaces](#core-interfaces)
3. [Collection Interfaces Hierarchy](#collection-interfaces-hierarchy)
4. [List Collections](#list-collections)
5. [Set Collections](#set-collections)
6. [Map Collections](#map-collections)
7. [Queue Collections](#queue-collections)
8. [Comparison Table](#comparison-table)
9. [Usage Examples](#usage-examples)
10. [Best Practices](#best-practices)

---

## Overview

The Java Collections Framework is a unified architecture for representing and manipulating collections. It provides:
- **Interfaces**: Abstract data types representing collections
- **Implementations**: Concrete implementations of collection interfaces
- **Algorithms**: Useful computational methods for searching, sorting, and manipulating collections
- **Thread-Safe Versions**: Synchronized versions for multi-threaded environments

---

## Core Interfaces

### 1. **Collection Interface**
The root interface for all collection classes (except Map).

**Key Methods:**
```java
boolean add(E e)                    // Add element
boolean remove(Object o)            // Remove element
boolean contains(Object o)          // Check if contains
int size()                          // Get size
boolean isEmpty()                   // Check if empty
void clear()                        // Remove all elements
Iterator<E> iterator()              // Get iterator
```

### 2. **List Interface**
Ordered collection that allows duplicates and positional access.

**Key Methods:**
```java
void add(int index, E element)      // Add at index
E get(int index)                    // Get element at index
E remove(int index)                 // Remove at index
E set(int index, E element)         // Replace at index
int indexOf(Object o)               // Get index of element
List<E> subList(int from, int to)   // Get sublist
```

### 3. **Set Interface**
Unordered collection that does NOT allow duplicate elements.

**Key Methods:**
```java
boolean add(E e)                    // Add element (no duplicates)
boolean remove(Object o)            // Remove element
boolean contains(Object o)          // Check membership
int size()                          // Get size
Iterator<E> iterator()              // Get iterator
```

### 4. **Map Interface**
Collection of key-value pairs where each key maps to exactly one value.

**Key Methods:**
```java
V put(K key, V value)               // Put key-value pair
V get(Object key)                   // Get value by key
V remove(Object key)                // Remove by key
boolean containsKey(Object key)     // Check if contains key
Set<K> keySet()                     // Get all keys
Collection<V> values()              // Get all values
Set<Map.Entry<K,V>> entrySet()      // Get all entries
int size()                          // Get size
void clear()                        // Remove all entries
```

### 5. **Queue Interface**
Collection designed for holding elements prior to processing. Follows FIFO principle.

**Key Methods:**
```java
boolean add(E e)                    // Add element (throws exception if full)
boolean offer(E e)                  // Add element (returns false if full)
E remove()                          // Remove and return head (throws exception)
E poll()                            // Remove and return head (returns null)
E element()                         // Return head (throws exception)
E peek()                            // Return head (returns null)
```

### 6. **Deque Interface**
Double-ended queue allowing insertion and removal at both ends.

**Key Methods:**
```java
void addFirst(E e)                  // Add at front
void addLast(E e)                   // Add at back
E removeFirst()                     // Remove from front
E removeLast()                      // Remove from back
E getFirst()                        // Get front
E getLast()                         // Get back
E peekFirst()                       // View front
E peekLast()                        // View back
E pollFirst()                       // Remove and return front
E pollLast()                        // Remove and return back
```

---

## Collection Interfaces Hierarchy

```
                           Iterable<E>
                              |
                        Collection<E>
                    /       |       |      \
                  List    Set    Queue   Deque
                  /       /  \      |       |
            ArrayList  /  \   \    |  LinkedList
            LinkedList/ Hash  Tree |  ArrayDeque
            Vector    \ Set   Set  |
                        |          |
                    HashSet   PriorityQueue
                    LinkedHashSet
                    TreeSet


                           Map<K,V>
                        /    |    \
                    HashMap  TreeMap  LinkedHashMap
                    |
                Hashtable (legacy)
```

---

## List Collections

### 1. **ArrayList**
- Dynamic array-based implementation
- Fast random access O(1)
- Slow insertion/deletion in middle O(n)
- Not synchronized

```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add(0, "Orange");        // Insert at index 0
String item = list.get(1);    // Access by index
list.remove(1);               // Remove by index
```

**Use When:** Need fast random access and mostly add/remove at end

### 2. **LinkedList**
- Doubly-linked list implementation
- Slow random access O(n)
- Fast insertion/deletion O(1)
- Implements Queue and Deque

```java
List<String> list = new LinkedList<>();
list.add("First");
list.add("Second");
list.addFirst("Beginning");   // Add at start
list.addLast("End");          // Add at end
String first = list.removeFirst();
```

**Use When:** Need frequent insertion/deletion or queue operations

### 3. **Vector**
- Legacy synchronized ArrayList
- Thread-safe but slower
- Rarely used in modern code

```java
List<String> vector = new Vector<>();
vector.add("Item");
```

**Use When:** Legacy code requiring thread-safety (use Collections.synchronizedList instead)

### 4. **Stack**
- LIFO (Last-In-First-Out) data structure
- Extends Vector
- Rarely used (use LinkedList or ArrayDeque)

```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
int top = stack.pop();        // Remove and return top
int peek = stack.peek();      // View top
```

**Use When:** Need stack behavior (use ArrayDeque instead)

---

## Set Collections

### 1. **HashSet**
- Unordered set using hash table
- O(1) average performance for add/remove/contains
- Not synchronized
- Allows one null element

```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");              // Duplicate ignored
boolean exists = set.contains("Apple");
set.remove("Apple");
```

**Use When:** Need fast lookup with no duplicates and order doesn't matter

### 2. **TreeSet**
- Sorted set using Red-Black tree
- O(log n) performance for add/remove/contains
- Elements sorted in natural order or custom comparator
- Not synchronized
- Does not allow null elements

```java
Set<Integer> set = new TreeSet<>();
set.add(30);
set.add(10);
set.add(20);
// Automatically sorted: 10, 20, 30

Set<String> customSet = new TreeSet<>((a, b) -> b.compareTo(a)); // Reverse order
```

**Use When:** Need sorted set with fast operations

### 3. **LinkedHashSet**
- Maintains insertion order
- O(1) average performance
- Slightly slower than HashSet due to linked structure
- Not synchronized

```java
Set<String> set = new LinkedHashSet<>();
set.add("First");
set.add("Second");
set.add("Third");
// Maintains insertion order: First, Second, Third
```

**Use When:** Need fast lookup with insertion order preservation

### 4. **EnumSet**
- Specialized set for enum elements
- Very fast and memory-efficient
- Not synchronized

```java
enum Color { RED, GREEN, BLUE }
Set<Color> set = EnumSet.of(Color.RED, Color.BLUE);
```

---

## Map Collections

### 1. **HashMap**
- Unordered map using hash table
- O(1) average performance for put/get/remove
- Not synchronized
- Allows one null key and multiple null values

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 85);
map.put("Bob", 90);
int score = map.get("Alice");
map.remove("Bob");
map.containsKey("Alice");           // true

// Iteration
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}
```

**Use When:** Need fast key-value lookup without order requirements

### 2. **TreeMap**
- Sorted map using Red-Black tree
- O(log n) performance for put/get/remove
- Elements sorted by key in natural order or custom comparator
- Not synchronized
- Does not allow null keys

```java
Map<String, Integer> map = new TreeMap<>();
map.put("Charlie", 85);
map.put("Alice", 90);
map.put("Bob", 88);
// Keys are sorted: Alice, Bob, Charlie

// Get range
NavigableMap<String, Integer> subMap = map.subMap("Alice", true, "Charlie", true);
```

**Use When:** Need sorted map or range queries

### 3. **LinkedHashMap**
- Maintains insertion order
- O(1) average performance
- Slightly slower than HashMap due to linked structure
- Not synchronized

```java
Map<String, Integer> map = new LinkedHashMap<>();
map.put("First", 1);
map.put("Second", 2);
map.put("Third", 3);
// Maintains insertion order

// LRU Cache example with accessOrder = true
Map<Integer, Integer> lruCache = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > 10;  // Keep max 10 entries
    }
};
```

**Use When:** Need insertion order preservation or LRU cache behavior

### 4. **Hashtable**
- Legacy synchronized HashMap
- Thread-safe but slower
- Does not allow null keys or values

```java
Hashtable<String, Integer> table = new Hashtable<>();
table.put("Key", 123);
```

**Use When:** Legacy code (use ConcurrentHashMap instead)

### 5. **ConcurrentHashMap**
- Thread-safe map without full synchronization
- Uses segment-based locking
- O(1) average performance
- Better concurrency than Hashtable

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
map.put("Key1", 10);
map.put("Key2", 20);
map.putIfAbsent("Key1", 30); // Returns 10, no change
```

**Use When:** Need thread-safe map with high concurrency

### 6. **EnumMap**
- Specialized map for enum keys
- Very fast and memory-efficient
- Not synchronized

```java
enum Status { ACTIVE, INACTIVE, PENDING }
Map<Status, String> map = new EnumMap<>(Status.class);
map.put(Status.ACTIVE, "Is active");
```

---

## Queue Collections

### 1. **PriorityQueue**
- Elements ordered by priority
- Min-heap implementation (smallest element has highest priority)
- O(log n) for add/remove, O(1) for peek
- Not synchronized

```java
Queue<Integer> queue = new PriorityQueue<>();
queue.add(30);
queue.add(10);
queue.add(20);
int first = queue.peek();     // 10 (smallest)
int removed = queue.poll();   // 10

// Custom comparator for max-heap
Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
maxHeap.add(30);
maxHeap.add(10);
int max = maxHeap.peek();     // 30 (largest)
```

**Use When:** Need priority-based processing

### 2. **LinkedList as Queue**
- FIFO queue using linked list
- O(1) for add/remove
- Not synchronized

```java
Queue<String> queue = new LinkedList<>();
queue.add("First");
queue.add("Second");
String first = queue.poll();  // FIFO: First
```

**Use When:** Need simple FIFO queue

### 3. **ArrayDeque**
- Double-ended queue using resizable array
- O(1) for add/remove at both ends
- Faster than LinkedList for queue operations
- Not synchronized

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
int first = deque.removeFirst(); // 1
int last = deque.removeLast();   // 2
```

**Use When:** Need fast queue or deque operations

### 4. **DelayQueue**
- Queue of delayed elements
- Elements retrievable only when delay expired
- Requires elements to implement Delayed interface
- Not synchronized

```java
class DelayedElement implements Delayed {
    private long delayTime;
    
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    
    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), 
                           o.getDelay(TimeUnit.MILLISECONDS));
    }
}
```

---

## Comparison Table

| Collection | Ordered | Sorted | Unique | Thread-Safe | Add | Remove | Contains | Use Case |
|-----------|---------|--------|--------|------------|-----|--------|----------|----------|
| ArrayList | Yes | No | No | No | O(1)* | O(n) | O(n) | Fast random access |
| LinkedList | Yes | No | No | No | O(1) | O(1) | O(n) | Frequent insert/delete |
| HashSet | No | No | Yes | No | O(1) | O(1) | O(1) | Unique elements, fast lookup |
| TreeSet | Yes | Yes | Yes | No | O(log n) | O(log n) | O(log n) | Sorted unique elements |
| LinkedHashSet | Yes | No | Yes | No | O(1) | O(1) | O(1) | Unique + insertion order |
| HashMap | No | No | No** | No | O(1) | O(1) | O(1) | Key-value lookup |
| TreeMap | Yes | Yes | No** | No | O(log n) | O(log n) | O(log n) | Sorted key-value |
| LinkedHashMap | Yes | No | No** | No | O(1) | O(1) | O(1) | Key-value + insertion order |
| PriorityQueue | No | Yes | No | No | O(log n) | O(log n) | O(n) | Priority-based access |
| ConcurrentHashMap | No | No | No** | Yes | O(1) | O(1) | O(1) | Concurrent key-value |

*O(1) amortized; O(n) when capacity exceeded
**Maps can have multiple null values but different null key behaviors

---

## Usage Examples

### Example 1: Managing Student Records with List
```java
List<String> students = new ArrayList<>();
students.add("Alice");
students.add("Bob");
students.add("Charlie");

for (String student : students) {
    System.out.println(student);
}

// Remove duplicates using Set
Set<String> uniqueStudents = new HashSet<>(students);
```

### Example 2: Unique Tags with Set
```java
Set<String> tags = new HashSet<>();
tags.add("Java");
tags.add("Programming");
tags.add("Java");  // Ignored

if (tags.contains("Python")) {
    System.out.println("Python is a tag");
} else {
    System.out.println("Python is not a tag");
}
```

### Example 3: Student Grades with Map
```java
Map<String, Integer> grades = new HashMap<>();
grades.put("Alice", 95);
grades.put("Bob", 87);
grades.put("Charlie", 92);

// Get all grades
for (Map.Entry<String, Integer> entry : grades.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Update grade
grades.put("Bob", 90);

// Get specific grade
Integer aliceGrade = grades.get("Alice");
```

### Example 4: Task Queue with Priority
```java
class Task implements Comparable<Task> {
    int priority;
    String name;
    
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}

PriorityQueue<Task> tasks = new PriorityQueue<>();
tasks.add(new Task("High Priority", 1));
tasks.add(new Task("Low Priority", 10));
tasks.add(new Task("Medium Priority", 5));

while (!tasks.isEmpty()) {
    System.out.println(tasks.poll().name); // Processes by priority
}
```

### Example 5: Sorted Inventory
```java
Map<String, Integer> inventory = new TreeMap<>();
inventory.put("Laptop", 50);
inventory.put("Mouse", 200);
inventory.put("Keyboard", 120);

// Displays in alphabetical order
for (String item : inventory.keySet()) {
    System.out.println(item + ": " + inventory.get(item));
}
```

### Example 6: Processing Order Preservation
```java
Map<String, String> orderedMap = new LinkedHashMap<>();
orderedMap.put("Order1", "Delivered");
orderedMap.put("Order2", "Processing");
orderedMap.put("Order3", "Pending");

// Maintains insertion order
for (Map.Entry<String, String> entry : orderedMap.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

---

## Best Practices

### 1. **Choose the Right Collection**
- Need unique elements? → Use **Set**
- Need ordered access? → Use **List**
- Need key-value pairs? → Use **Map**
- Need priority-based processing? → Use **PriorityQueue**

### 2. **Use Interfaces, Not Implementations**
```java
// Good
List<String> list = new ArrayList<>();
Set<String> set = new HashSet<>();
Map<String, Integer> map = new HashMap<>();

// Avoid
ArrayList<String> list = new ArrayList<>();
```

### 3. **Initialize with Capacity**
```java
// Good - avoids resizing
List<String> list = new ArrayList<>(1000);
Map<String, Integer> map = new HashMap<>(500);
```

### 4. **Use Generics to Avoid Casting**
```java
// Good
List<String> list = new ArrayList<String>();
for (String item : list) {
    System.out.println(item);
}

// Avoid (unchecked warnings)
List list = new ArrayList();
```

### 5. **Synchronization When Needed**
```java
// Single-threaded
Map<String, Integer> map = new HashMap<>();

// Multi-threaded
Map<String, Integer> syncMap = new ConcurrentHashMap<>();
// or
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
```

### 6. **Iterator for Concurrent Modification**
```java
// Safe concurrent modification
List<String> list = new ArrayList<>();
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String item = iterator.next();
    if (condition) {
        iterator.remove();  // Safe
    }
}

// Avoid direct modification during iteration
for (String item : list) {
    list.remove(item);  // ConcurrentModificationException
}
```

### 7. **Use Stream API for Functional Operations**
```java
List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Filter and map
List<Integer> squared = numbers.stream()
    .filter(n -> n > 2)
    .map(n -> n * n)
    .collect(Collectors.toList());

// Convert to Set
Set<Integer> uniqueNumbers = numbers.stream()
    .collect(Collectors.toSet());
```

### 8. **Performance Considerations**
- **ArrayList**: Best for random access, avoid frequent middle insertions
- **LinkedList**: Best for frequent insertions/deletions, avoid random access
- **HashMap**: Best average performance for lookups
- **TreeMap**: Use when you need sorted order
- **HashSet**: Fast for uniqueness checks
- **TreeSet**: Use when you need sorted unique elements

### 9. **Memory Management**
```java
// Clear large collections when done
collection.clear();

// Remove all at once instead of one by one
collection.removeAll(toRemove);  // Faster

// Use capacity hints for known sizes
new HashMap<>(expectedSize);
```

### 10. **Null Handling**
```java
// HashMap allows one null key and multiple null values
Map<String, Integer> map = new HashMap<>();
map.put(null, 0);        // Allowed

// TreeMap doesn't allow null keys
Map<String, Integer> map = new TreeMap<>();
map.put(null, 0);        // NullPointerException

// Check before operations
if (!map.containsKey(key)) {
    map.put(key, value);
}
```

---

## Summary

The Java Collections Framework provides a comprehensive set of data structures:

- **For Lists**: Use `ArrayList` for random access, `LinkedList` for frequent modifications
- **For Sets**: Use `HashSet` for speed, `TreeSet` for sorted elements, `LinkedHashSet` for insertion order
- **For Maps**: Use `HashMap` for speed, `TreeMap` for sorted keys, `LinkedHashMap` for insertion order
- **For Queues**: Use `ArrayDeque` for most cases, `PriorityQueue` for priority ordering

Choose based on your specific needs for:
1. Access patterns (random vs sequential)
2. Modification patterns (frequent insertions/deletions)
3. Ordering requirements (none, insertion order, sorted)
4. Thread safety requirements
5. Performance characteristics

