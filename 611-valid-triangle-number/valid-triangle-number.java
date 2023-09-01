class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int k = nums.length-1; k>1; k--) {
            int i = 0;
            int j = k-1;
            while (i<j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j-i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
/**This problem is very similar to 3-Sum, in 3-Sum, we can use three pointers (i, j, k and i < j < k) to solve the problem in O(n^2) time for a sorted array, the way we do in 3-Sum is that we first lock pointer i and then scan j and k, if nums[j] + nums[k] is too large, k--, otherwise j++, once we complete the scan, increase pointer i and repeat.

For this problem, once we sort the input array nums, the key to solve the problem is that given nums[k], count the combination of i and j where nums[i] + nums[j] > nums[k] (so that they can form a triangle). If nums[i] + nums[j] is larger than nums[k], we know that there will be j - i combination. */