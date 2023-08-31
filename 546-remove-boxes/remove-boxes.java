class Solution {
    public int removeBoxes(int[] boxes) {
        // Check for edge cases: if boxes array is null or empty, return 0.
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        // Get the size of the boxes array.
        int size = boxes.length;
        
        // Create a 3D array to store computed values using memoization.
        int[][][] dp = new int[size][size][size];
        
        // Call the helper function to calculate the maximum score.
        return get(dp, boxes, 0, size - 1, 0);
    }

    private int get(int[][][] dp, int[] boxes, int left, int right, int streak) {
        // Base case: If left index is greater than right index, return 0.
        if (left > right) {
            return 0;
        }
        // Base case: If left and right indices are equal, return the square of the streak.
        else if (left == right) {
            return (streak + 1) * (streak + 1);
        }
        // If the value for the current parameters is already calculated, return it.
        else if (dp[left][right][streak] != 0) {
            return dp[left][right][streak];
        }
        // If none of the base cases apply, calculate the maximum score.
        else {
            // Initialize max score with the scenario where the leftmost box is removed.
            int max = get(dp, boxes, left + 1, right, 0) + (streak + 1) * (streak + 1);
            
            // Iterate through all possible partition points within the subsequence.
            for (int i = left + 1; i <= right; i++) {
                // If the color of the leftmost box matches the color of the box at index i.
                if (boxes[left] == boxes[i]) {
                    // Calculate score by combining boxes before i and after i.
                    max = Math.max(max, get(dp, boxes, left + 1, i - 1, 0) + get(dp, boxes, i, right, streak + 1));
                }
            }
            
            // Store the computed maximum score in the memoization array.
            dp[left][right][streak] = max;
            
            // Return the calculated maximum score.
            return max;
        }
    }
}
