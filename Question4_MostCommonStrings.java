import java.util.*;


// * Question 4: Three Most Common Strings

// Given a sentence, return the three most common strings in it.
// The result should be returned in ascending alphabetical order.


public class Question4_MostCommonStrings {
    
    /**
     * Returns the three most common strings in the sentence
     */
    public static String[] getThreeMostCommonStrings(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new String[0];
        }
        
        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");
        
        // Count frequency of each word
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        // Create list of entries and sort by frequency (descending) then alphabetically (ascending)
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(freq.entrySet());
        sortedEntries.sort((a, b) -> {
            // First sort by frequency (descending)
            int freqCompare = Integer.compare(b.getValue(), a.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            // Then sort alphabetically (ascending)
            return a.getKey().compareTo(b.getKey());
        });
        
        // Extract top 3 strings
        int resultSize = Math.min(3, sortedEntries.size());
        String[] result = new String[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = sortedEntries.get(i).getKey();
        }
        
        return result;
    }
    

    public static void main(String[] args) {
        // Test case from the example
        String sentence1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        String[] result1 = getThreeMostCommonStrings(sentence1);
        System.out.println("Three most common strings: " + Arrays.toString(result1));
        // Expected output: ["algorithm", "or", "to"]
        
        System.out.println("\n=== Additional Test Cases ===");
        
        // Test case 1: Less than 3 unique words
        String sentence2 = "hello hello world";
        String[] result2 = getThreeMostCommonStrings(sentence2);
        System.out.println("Less than 3 unique words: " + Arrays.toString(result2));
        // Expected: ["hello", "world"]
        
        // Test case 2: All words have same frequency
        String sentence3 = "a b c d e f";
        String[] result3 = getThreeMostCommonStrings(sentence3);
        System.out.println("All words same frequency: " + Arrays.toString(result3));
        // Expected: ["a", "b", "c"] (alphabetically first 3)
        
        // Test case 3: Empty sentence
        String sentence4 = "";
        String[] result4 = getThreeMostCommonStrings(sentence4);
        System.out.println("Empty sentence: " + Arrays.toString(result4));
        // Expected: []
        
        // Test case 4: Single word repeated
        String sentence5 = "test test test test test";
        String[] result5 = getThreeMostCommonStrings(sentence5);
        System.out.println("Single word repeated: " + Arrays.toString(result5));
        // Expected: ["test"]
        
        // Test case 5: Complex sentence with ties
        String sentence6 = "the quick brown fox jumps over the lazy dog the quick brown";
        String[] result6 = getThreeMostCommonStrings(sentence6);
        System.out.println("Complex sentence with ties: " + Arrays.toString(result6));
        // Expected: ["the", "brown", "quick"] (sorted by frequency then alphabetically)
        
        // Test case 6: Sentence with punctuation (basic handling)
        String sentence7 = "hello world hello world hello";
        String[] result7 = getThreeMostCommonStrings(sentence7);
        System.out.println("Basic punctuation test: " + Arrays.toString(result7));
        // Expected: ["hello", "world"]
        
        
        // Test null input
        String[] resultNull = getThreeMostCommonStrings(null);
        System.out.println("Null input result: " + Arrays.toString(resultNull));
        // Expected: []
    }
}
