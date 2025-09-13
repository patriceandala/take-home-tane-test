/**
 Use this to test all solutions
 */
public class TestRunner {
    
    public static void main(String[] args) {
        System.out.println("TUFIN TECHNICAL ASSESSMENT TESTS\n");
        
        testQuestion1();
        
        testQuestion2();
        
        testQuestion3();
        
        testQuestion4();
        
        testQuestion5();
        
        System.out.println("\n=== ALL TESTS COMPLETED :) ===");
    }
    
    private static void testQuestion1() {
        System.out.println("Testing Question 1: Get Longest String");
        System.out.println("-----------------------------------------------------");
        
        // Test case from example
        java.util.List<Character> characters = java.util.Arrays.asList('A', 'B', 'C', 'D');
        String[] strings = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        String result = Question1_GetLongestString.getLongestString(characters, strings);
        System.out.println("Input: " + java.util.Arrays.toString(strings));
        System.out.println("Expected: ABCDABDCA");
        System.out.println("Actual: " + result);
        System.out.println("Test " + ("ABCDABDCA".equals(result) ? "PASSED" : "FAILED"));
        
        // Additional edge cases
        String[] edgeCase1 = {"AA", "BB", "CC"};
        String result1 = Question1_GetLongestString.getLongestString(characters, edgeCase1);
        System.out.println("Edge case (all invalid): " + result1 + " (should be null)");
        System.out.println("Edge case test " + (result1 == null ? "PASSED" : "FAILED"));
        
        System.out.println();
    }
    
    private static void testQuestion2() {
        System.out.println("Testing Question 2: First Unique Product");
        System.out.println("-----------------------------------------------------====");
        
        // Test case from example
        String[] products = {"Apple", "Computer", "Apple", "Bag"};
        String result = Question2_firstUniqueProduct.firstUniqueProduct(products);
        System.out.println("Input: " + java.util.Arrays.toString(products));
        System.out.println("Expected: Computer");
        System.out.println("Actual: " + result);
        System.out.println("Test " + ("Computer".equals(result) ? "PASSED" : "FAILED"));
        
        // Edge case: no unique products
        String[] edgeCase1 = {"Apple", "Apple", "Banana", "Banana"};
        String result1 = Question2_firstUniqueProduct.firstUniqueProduct(edgeCase1);
        System.out.println("Edge case (no unique): " + result1 + " (should be null)");
        System.out.println("Edge case test " + (result1 == null ? "PASSED" : "FAILED"));
        
        System.out.println();
    }
    
    private static void testQuestion3() {
        System.out.println("Testing Question 3: Find Closest Minimums");
        System.out.println("-----------------------------------------------------====");
        
        // Test case from example
        int[] array = {1, 2, 3, 1, 4, 5, 2};
        int result = Question3_FindClosestMinimums.findDistanceBetweenClosestMinimums(array);
        System.out.println("Input: " + java.util.Arrays.toString(array));
        System.out.println("Expected: 3");
        System.out.println("Actual: " + result);
        System.out.println("Test " + (result == 3 ? "PASSED" : "FAILED"));
        
        // Edge case: consecutive minimums
        int[] edgeCase1 = {5, 1, 1, 3, 4};
        int result1 = Question3_FindClosestMinimums.findDistanceBetweenClosestMinimums(edgeCase1);
        System.out.println("Edge case (consecutive): " + result1 + " (should be 1)");
        System.out.println("Edge case test " + (result1 == 1 ? "PASSED" : "FAILED"));
        
        System.out.println();
    }
    
    private static void testQuestion4() {
        System.out.println("Testing Question 4: Most Common Strings");
        System.out.println("-----------------------------------------------------==");
        
        // Test case from example
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        String[] result = Question4_MostCommonStrings.getThreeMostCommonStrings(sentence);
        System.out.println("Input: \"" + sentence + "\"");
        System.out.println("Expected: [algorithm, or, to]");
        System.out.println("Actual: " + java.util.Arrays.toString(result));
        System.out.println("Test " + (java.util.Arrays.equals(result, new String[]{"algorithm", "or", "to"}) ? "PASSED" : "FAILED"));
        
        // Edge case: less than 3 unique words
        String edgeCase1 = "hello hello world";
        String[] result1 = Question4_MostCommonStrings.getThreeMostCommonStrings(edgeCase1);
        System.out.println("Edge case (2 unique words): " + java.util.Arrays.toString(result1));
        System.out.println("Edge case test " + (java.util.Arrays.equals(result1, new String[]{"hello", "world"}) ? "PASSED" : "FAILED"));
        
        System.out.println();
    }
    
    private static void testQuestion5() {
        System.out.println("Testing Question 5: Rotate List");
        System.out.println("===============================");
        
        // Test case from example
        String[] values = {"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"};
        Question5_RotateList.ListNode head = Question5_RotateList.createList(values);
        System.out.println("Original: " + Question5_RotateList.printList(head));
        
        Question5_RotateList.ListNode rotated = Question5_RotateList.rotateRight(head, 2);
        System.out.println("After rotate by 2: " + Question5_RotateList.printList(rotated));
        
        String[] result = Question5_RotateList.listToArray(rotated);
        String[] expected = {"ID_A05", "ID_A06", "ID_A01", "ID_A02", "ID_A03", "ID_A04"};
        System.out.println("Expected: " + java.util.Arrays.toString(expected));
        System.out.println("Actual: " + java.util.Arrays.toString(result));
        System.out.println("Test " + (java.util.Arrays.equals(result, expected) ? "PASSED" : "FAILED"));
        
        // Edge case: rotate by 0
        String[] edgeValues = {"A", "B", "C"};
        Question5_RotateList.ListNode edgeHead = Question5_RotateList.createList(edgeValues);
        Question5_RotateList.ListNode edgeResult = Question5_RotateList.rotateRight(edgeHead, 0);
        String[] edgeArray = Question5_RotateList.listToArray(edgeResult);
        System.out.println("Edge case (rotate by 0): " + java.util.Arrays.toString(edgeArray));
        System.out.println("Edge case test " + (java.util.Arrays.equals(edgeArray, edgeValues) ? "PASSED" : "FAILED"));
        
        System.out.println();
    }
}
