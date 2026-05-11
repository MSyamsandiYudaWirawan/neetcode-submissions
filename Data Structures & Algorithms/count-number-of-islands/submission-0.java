class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1'){
                    bfs(grid,r,c);
                    island++;
                }
            }
        }
        return island;
    }
    private static void bfs(char[][] grid,int r,int c){
        final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] direction:directions){
                int nr=row+direction[0];
                int nc=col+direction[1];
                if(nc>=0 && nr>=0 && nc<grid[0].length && 
                nr<grid.length && grid[nr][nc]=='1'){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                } 
            }
        }
    }
}
