class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int result[][] = new int[r][c];
        result[r-1][c-1] = dungeon[r-1][c-1]>0?1:1-dungeon[r-1][c-1];
        for(int i=r-2;i>=0;--i){
            result[i][c-1] = Math.max(result[i+1][c-1]-dungeon[i][c-1],1);
        }
        for(int i=c-2;i>=0;--i){
            result[r-1][i] = Math.max(result[r-1][i+1]-dungeon[r-1][i],1);
        }
        for(int i=r-2;i>=0;--i){
            for(int j=c-2;j>=0;--j){
                result[i][j] = Math.max(Math.min(result[i+1][j],result[i][j+1])-dungeon[i][j],1);
            }
        }
        return result[0][0];
    }
}