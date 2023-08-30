/*class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==0){
            return 0;
        }
        int largest=0;
        int[][] dp = new int[rows+1][cols+1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                    if(largest<dp[i][j]){
                        largest=dp[i][j];
                    }
                }
            }
        }
        return largest*largest;
    }
}*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==0){
            return 0;
        }
        int largest=0;
        int[] prev = new int[cols+1];
        int[] curr = new int[cols+1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1]=='1'){
                    curr[j]=1+Math.min(prev[j],Math.min(prev[j-1],curr[j-1]));
                    if(largest<curr[j]){
                        largest=curr[j];
                    }
                }
                else{
                        curr[j]=0;
                    }
            }
            prev=curr.clone();
        }
        return largest*largest;
    }
}
