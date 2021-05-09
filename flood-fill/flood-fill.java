class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null)return image;
        //bfs from the starting point 
        //not the current color and stop when this color is not found 
        
        Queue<int[]> queue = new LinkedList<>();
        int og= image[sr][sc];
        if(newColor==og)return image;
        queue.offer(new int[]{sr,sc});
        int dir [][] ={{-1,0},{0,-1},{1,0},{0,1}};
        while(!queue.isEmpty()) {
            
            int x[] = queue.poll();
            image[x[0]][x[1]]=newColor;
            for(int []d:dir){
                int newx=x[0]+d[0];
                int newy = x[1]+d[1];
                if(valid(newx,newy, image) && image[newx][newy]==og){
                    image[newx][newy]=newColor;
                    queue.offer(new int[]{newx,newy});
                }
            }
        }
        return image;
    }
    
    public boolean valid(int a, int b, int image[][]){
        return a>=0 && b>=0 && a<image.length  && b < image[0].length;
    }
}