class Solution {
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2Profit = 0;
        for(int currPrice : prices){
            t1Cost = Math.min(t1Cost,currPrice);
            t1Profit = Math.max(t1Profit,currPrice-t1Cost);
            t2Cost = Math.min(t2Cost,currPrice-t1Profit);
            t2Profit=Math.max(t2Profit,currPrice-t2Cost);
        }
        return t2Profit;
    }
}