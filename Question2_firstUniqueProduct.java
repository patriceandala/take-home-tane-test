import java.util.*;


// Question 2: First Unique Product
//
// This method finds the first product in an array that occurs only once.
// If no unique products exist, it returns null.


public class Question2_firstUniqueProduct {
    
    /**
     * Finds the first unique product in the array
     */
    public static String firstUniqueProduct(String[] products) {
        if (products == null || products.length == 0) {
            return null;
        }
        
        // Use LinkedHashMap to maintain insertion order
        Map<String, Integer> productCount = new LinkedHashMap<>();
        
        // Count occurrences of each product
        for (String item : products) {
            productCount.put(item, productCount.getOrDefault(item, 0) + 1);
        }
        
        // Find the first product with count = 1
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return null; // No unique product found
    }
    
    

    public static void main(String[] args) {
        // Test case from the example
        String[] products1 = {"Apple", "Computer", "Apple", "Bag"};
        String result1 = firstUniqueProduct(products1);
        System.out.println("First unique product: " + result1);
        // Expected output: "Computer"
        
        System.out.println("\n=== Additional Test Cases ===");
        
        // Test case 1: No unique products
        String[] products2 = {"Apple", "Apple", "Banana", "Banana"};
        String result2 = firstUniqueProduct(products2);
        System.out.println("No unique products result: " + result2);
        // Expected: null
        
        // Test case 2: All unique products
        String[] products3 = {"Apple", "Banana", "Cherry"};
        String result3 = firstUniqueProduct(products3);
        System.out.println("All unique products result: " + result3);
        // Expected: "Apple"
        
        // Test case 3: Single element
        String[] products4 = {"Apple"};
        String result4 = firstUniqueProduct(products4);
        System.out.println("Single element result: " + result4);
        // Expected: "Apple"
        
        // Test case 4: Empty array
        String[] products5 = {};
        String result5 = firstUniqueProduct(products5);
        System.out.println("Empty array result: " + result5);
        // Expected: null
        
        // Test case 5: Multiple duplicates, one unique at end
        String[] products6 = {"Apple", "Apple", "Banana", "Banana", "Cherry"};
        String result6 = firstUniqueProduct(products6);
        System.out.println("Unique at end result: " + result6);
        // Expected: "Cherry"
        
        // Test case 6: Multiple duplicates, one unique in middle
        String[] products7 = {"Apple", "Apple", "Cherry", "Banana", "Banana"};
        String result7 = firstUniqueProduct(products7);
        System.out.println("Unique in middle result: " + result7);
        // Expected: "Cherry"
        
    }
}
