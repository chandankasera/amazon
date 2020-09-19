import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zombie {

    public static int minHours(int rows, int columns, int[][] grid) {
        // todo
        int minHour =0;
        int numZombies=0;
        int numHuman =0;
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,-1,0,1};
        Queue<int[]> queue = new LinkedList<>() ;
       // int j=0;
        for(int i=0;i<grid.length;i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numZombies++;
                    queue.offer(new int[]{i, j});

                } else
                    numHuman++;
            }
        }

       System.out.println(" numHuman "+numHuman);

        if(numZombies==0 || numHuman==0)
            return -1;
        while(!queue.isEmpty() && numHuman>0){
            int size = queue.size();
            System.out.println(" Queue size "+size);
            for(int i=0;i<size;i++){
              int[] indexArray = queue.poll();
              //consume all neighbour human
              for(int k=0;k<4;k++){
                  int x=indexArray[0]+dx[k];
                  int y = indexArray[1]+dy[k];
                  System.out.println("x "+x+" y "+y);
                  if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==0)
                  {  grid[x][y]=1;
                     queue.offer(new int[]{x,y});
                      numZombies++;
                      numHuman--;

                  }
              }

            }
            minHour++;


        }
        System.out.println(" numHuman "+numHuman);


        return minHour;
    }

    public static void main(String[] args) {
        int[][] intGrid = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};


        System.out.println(minHours(4,5,intGrid));
    }

}
