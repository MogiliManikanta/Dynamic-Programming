class Solution { 
    public int n; 
    public HashMap<String, Boolean> mp; 
    public boolean isConcat(String word, HashSet<String> st) {
    if (mp.containsKey(word)) {
        return mp.get(word);
    }
    
    int l = word.length();
    
    for (int i = 0; i < l; i++) {
        String prefix = word.substring(0, i + 1);
        String suffix = word.substring(i + 1);
        
        if ((st.contains(prefix) && isConcat(suffix, st)) ||
            (st.contains(prefix) && st.contains(suffix))) {
            mp.put(word, true);
            return true;
        }
    }
    
    mp.put(word, false);
    return false;
}
public List<String> findAllConcatenatedWordsInADict(String[] words) {
    n = words.length; // Get the size of the input array
    mp = new HashMap<>(); // Initialize the hash map
    List<String> result = new ArrayList<>(); // Create a list to store the result
    HashSet<String> st = new HashSet<>(Arrays.asList(words)); // Create a hash set from the input array
    
    for(int i = 0; i < n; i++) { // Loop through the input array
        if(isConcat(words[i], st)) // If the current word is a concatenated word
            result.add(words[i]); // Add it to the result list
    }
    
    return result; // Return the result list
}

}

