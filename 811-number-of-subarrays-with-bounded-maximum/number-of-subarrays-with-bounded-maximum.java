class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums,right) - count(nums,left-1);
    }
    public int count(int[] nums,int bound){
        int cnt=0,result=0;
        for(int x : nums){
            cnt = x<=bound?cnt+1:0;
            result+=cnt;
        }
        return result;
    }
}