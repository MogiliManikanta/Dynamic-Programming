class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer>set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int x = arr[j],y=arr[i]+arr[j];
                int length=2;
                while(set.contains(y)){
                    int temp = y;
                    y+=x;
                    x=temp;
                    ans=Math.max(ans,++length);
                }
            }
        }
        return ans>=3?ans:0;
    }
}