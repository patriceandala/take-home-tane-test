# Tufin Developer Technical Assessment

## Programming Language and Version
- **Language**: Java
- **Version**: Java 17 (compatible with Java 8+)

## Project Structure
This project contains solutions to 5 technical assessment questions:

1. `Question1_GetLongestString.java` - Find longest valid string with no repetitive characters
2. `Question2_firstUniqueProduct.java` - Find first unique product in array
3. `Question3_FindClosestMinimums.java` - Find distance between closest minimum values
4. `Question4_MostCommonStrings.java` - Find three most common strings in sentence
5. `Question5_RotateList.java` - Rotate linked list by n positions

## How to Run the Code

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation and Execution
For each question file, use the following commands:

```bash
# Compile the Java file
javac Question1_GetLongestString.java

# Run the compiled class
java Question1_GetLongestString
```

Repeat this process for each question file:
- `Question2_firstUniqueProduct.java`
- `Question3_FindClosestMinimums.java`
- `Question4_MostCommonStrings.java`
- `Question5_RotateList.java`

### Quick Test All Solutions
You can also run all solutions at once using:

```bash
# Compile all files
javac *.java

# Run each solution
java Question1_GetLongestString
java Question2_firstUniqueProduct
java Question3_FindClosestMinimums
java Question4_MostCommonStrings
java Question5_RotateList
```

## Solution Explanations

### Question 1: Get Longest String
**Approach**: 
- Validate each string by checking for repetitive characters and valid character set
- Use HashSet for O(1) character lookup
- Return the longest valid string

**Time Complexity**: O(n*m) where n is number of strings, m is average string length
**Space Complexity**: O(k) where k is number of valid characters

### Question 2: First Unique Product
**Approach**: 
- Use LinkedHashMap to maintain insertion order and count occurrences
- Find first element with count = 1
- Alternative implementation uses HashMap with separate iteration

**Time Complexity**: O(n)
**Space Complexity**: O(n)

### Question 3: Find Closest Minimums
**Approach**: 
- Find minimum value in array
- Track positions of minimum values
- Calculate minimum distance between consecutive minimum positions
- Optimized version uses single pass

**Time Complexity**: O(n)
**Space Complexity**: O(k) where k is number of minimums

### Question 4: Most Common Strings
**Approach**: 
- Split sentence into words
- Count frequency using HashMap
- Sort by frequency (descending) then alphabetically (ascending)
- Return top 3 strings

**Time Complexity**: O(n log n) due to sorting
**Space Complexity**: O(n)

### Question 5: Rotate List
**Approach**: 
- Calculate effective rotation (n % list_length)
- Find new tail position
- Break list at new tail and reconnect
- Handle edge cases (empty list, single element, etc.)

**Time Complexity**: O(n)
**Space Complexity**: O(1)

## Test Cases
Each solution includes comprehensive test cases covering:
- Basic functionality from examples
- Edge cases (empty inputs, single elements, etc.)
- Boundary conditions
- Error handling

## Additional Notes
- All solutions include detailed comments explaining the approach
- Multiple implementations provided where applicable (optimized versions)
- Comprehensive error handling and input validation
- Clean, readable code with meaningful variable names 

