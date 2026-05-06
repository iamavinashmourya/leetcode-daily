class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        char[][] ans = new char[n][m];

        for(char[] r : ans){
            Arrays.fill(r,'.');
        }

        for(int i = 0; i < m; i++){
            int last = n-1;
            for(int j = last; j>=0; j--){
                //stone //#endregion 

                //grid[i][j] -> ans[j][m-1-i]
                if(grid[i][j] == '*'){
                    ans[j][m-1-i] = '*';
                    last = j-1;
                } else if(grid[i][j] == '#'){
                    ans[last][m-1-j] = '#';
                    last--;
                }

                //obstacle *

                //empty .
            }
        }
        return ans;
    }
}
