
// Question 3: Find Distance Between Closest Minimums
// Given an array of integers, find the distance between the two closest minimums.
// It is guaranteed that the minimum value appears at least twice in the array.

public class Question3_FindClosestMinimums {
    
    /**
     * Finds the distance between the two closest minimum values
     */
    public static int findDistanceBetweenClosestMinimums(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        // Find the minimum value
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        
        // Find all positions of the minimum value
        java.util.List<Integer> minPositions = new java.util.ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minValue) {
                minPositions.add(i);
            }
        }
        
        // Find the minimum distance between consecutive minimum positions
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < minPositions.size() - 1; i++) {
            int distance = minPositions.get(i + 1) - minPositions.get(i);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        
        return minDistance;
    }
    
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Test case from the example
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2};
        int result1 = findDistanceBetweenClosestMinimums(arr1);
        System.out.println("Distance between closest minimums: " + result1);
        // Expected output: 3 (positions 0 and 3, distance = 3-0 = 3)
        
        System.out.println("\n=== Additional Test Cases ===");
        
        // Test case 1: Minimum at beginning and end
        int[] arr2 = {1, 5, 3, 4, 2, 1};
        int result2 = findDistanceBetweenClosestMinimums(arr2);
        System.out.println("Min at start and end result: " + result2);
        // Expected: 5 (positions 0 and 5, distance = 5-0 = 5)
        
        // Test case 2: Consecutive minimums
        int[] arr3 = {5, 1, 1, 3, 4};
        int result3 = findDistanceBetweenClosestMinimums(arr3);
        System.out.println("Consecutive minimums result: " + result3);
        // Expected: 1 (positions 1 and 2, distance = 2-1 = 1)
        
        // Test case 3: Multiple minimums with different distances
        int[] arr4 = {3, 1, 4, 1, 5, 1};
        int result4 = findDistanceBetweenClosestMinimums(arr4);
        System.out.println("Multiple minimums result: " + result4);
        // Expected: 2 (positions 1 and 3, distance = 3-1 = 2)
        
        // Test case 4: All same values
        int[] arr5 = {2, 2, 2, 2, 2};
        int result5 = findDistanceBetweenClosestMinimums(arr5);
        System.out.println("All same values result: " + result5);
        // Expected: 1 (consecutive positions)
        
        // Test case 5: Minimum at adjacent positions
        int[] arr6 = {5, 4, 1, 1, 3, 2};
        int result6 = findDistanceBetweenClosestMinimums(arr6);
        System.out.println("Adjacent minimums result: " + result6);
        // Expected: 1 (positions 2 and 3, distance = 3-2 = 1)
        
        
        // Test edge cases
        try {
            int[] emptyArr = {};
            findDistanceBetweenClosestMinimums(emptyArr);
        } catch (IllegalArgumentException e) {
            System.out.println("Empty array exception: " + e.getMessage());
        }
        
        try {
            int[] singleArr = {5};
            findDistanceBetweenClosestMinimums(singleArr);
        } catch (IllegalArgumentException e) {
            System.out.println("Single element exception: " + e.getMessage());
        }
    }
}
