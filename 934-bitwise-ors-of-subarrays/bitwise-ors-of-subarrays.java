class Solution {
        public int subarrayBitwiseORs(int[] a) {
        Set<Integer> curr = null, prev = new HashSet<>(), uniqs = new HashSet<>();
        for(int x : a){
            curr = new HashSet<>();
            prev.add(0);
            for(int y : prev){
                curr.add(y | x);
                uniqs.add(y | x);
            }
            prev = curr;
        }
        return uniqs.size();
    }
}