import java.util.*;

// Question 1: Get Longest String
// Find the longest string with no repetitive characters
public class Question1_GetLongestString {
    
    // Returns the longest valid string
    public static String getLongestString(List<Character> characters, String[] strings) {
        // Convert valid characters to a set for O(1) lookup
        Set<Character> validChars = new HashSet<>(characters);
        String longestValidString = null;
        int maxLength = 0;
        
        for (String str : strings) {
            if (isValidString(str, validChars)) {
                if (str.length() > maxLength) {
                    maxLength = str.length();
                    longestValidString = str;
                }
            }
        }
        
        return longestValidString;
    }
    
    // Helper method to check if string is valid
    private static boolean isValidString(String str, Set<Character> validChars) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        // Check for repetitive characters and invalid characters
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            // Check if character is in valid characters set
            if (!validChars.contains(currentChar)) {
                return false;
            }
            
            // Check for consecutive identical characters
            if (i > 0 && currentChar == str.charAt(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
    

    public static void main(String[] args) {
        // Test case from the example
        List<Character> characters = Arrays.asList('A', 'B', 'C', 'D');
        String[] strings = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        
        String result = getLongestString(characters, strings);
        System.out.println("Longest valid string: " + result);
        // Expected output: "ABCDABDCA"
        
        // Additional test cases
        System.out.println("\n== Other Test Cases ===");
        
        // Test case 1: All strings invalid
        String[] invalidStrings = {"AA", "BBCC", "ZZZ"};
        String result1 = getLongestString(characters, invalidStrings);
        System.out.println("All invalid strings result: " + result1);
        // Expected: null
        
        // Test case 2: Single valid string
        String[] singleValid = {"ABCD"};
        String result2 = getLongestString(characters, singleValid);
        System.out.println("Single valid string result: " + result2);
        // Expected: "ABCD"
        
        // Test case 3: Empty array
        String[] emptyArray = {};
        String result3 = getLongestString(characters, emptyArray);
        System.out.println("Empty array result: " + result3);
        // Expected: null
        
        // Test case 4: Multiple valid strings of different lengths
        String[] multipleValid = {"AB", "ABCD", "ABC"};
        String result4 = getLongestString(characters, multipleValid);
        System.out.println("Multiple valid strings result: " + result4);
        // Expected: "ABCD"
    }
}
