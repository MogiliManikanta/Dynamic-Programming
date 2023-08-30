class Solution { 
    public int n; // Variable to store the size of the input array
    public HashMap<String, Boolean> mp; // HashMap to store memoization results
    
    // Function to check if a word can be formed by concatenating other words
    public boolean isConcat(String word, HashSet<String> st) {
        if (mp.containsKey(word)) {
            return mp.get(word); // If result for this word is already memoized, return it
        }
        
        int l = word.length(); // Get the length of the word
        
        for (int i = 0; i < l; i++) { // Iterate through possible prefix positions
            String prefix = word.substring(0, i + 1); // Extract the prefix
            String suffix = word.substring(i + 1); // Extract the suffix
            
            if ((st.contains(prefix) && isConcat(suffix, st)) || // If prefix is in the set and suffix is a concatenated word
                (st.contains(prefix) && st.contains(suffix))) { // Or if both prefix and suffix are in the set
                mp.put(word, true); // Memoize the result for this word as true
                return true;
            }
        }
        
        mp.put(word, false); // Memoize the result for this word as false
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        n = words.length; // Get the size of the input array
        mp = new HashMap<>(); // Initialize the hash map for memoization
        List<String> result = new ArrayList<>(); // Create a list to store the result
        HashSet<String> st = new HashSet<>(Arrays.asList(words)); // Create a hash set from the input array
        
        for (int i = 0; i < n; i++) { // Loop through the input array
            if (isConcat(words[i], st)) // If the current word is a concatenated word
                result.add(words[i]); // Add it to the result list
        }
        
        return result; // Return the list of concatenated words
    }
}
