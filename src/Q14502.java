import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14502 {

        static  int N,M;
        static  int[][] map;
        static  int[][] copymap;
        static  boolean[][] visited;
        static  boolean[][] virus;
        static int[] dx = {0,1,0,-1};//동남서북
        static int[] dy ={1,0,-1,0};

        public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

       /* 첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
        둘째 줄부터 N개의 줄에 지도의 모양이 주어진다.
        0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다.
        2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
        빈 칸의 개수는 3개 이상이다.*/

       N = sc.nextInt();
       M = sc.nextInt();

       map = new int[N][M];
       virus = new boolean[N][M];

       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
              int num =  sc.nextInt();
              map[i][j] = num;
              if(num==2){
                  virus[i][j] =true;
              }
               }
       }

        int[] arr = new int[3];
        combina(arr,N*M,3,0,0);
        System.out.println(max);
        }

     static  int max = Integer.MIN_VALUE;
     static void combina(int[] arr,int n,int r,int index,int target){

        if(r==0){
            copymap = new int[N][M];
            visited =  new boolean[N][M];
            //다 골랐음 -> 다음 메소드로 이동
            for(int i=0;i<N;i++){//맵 복사
                for(int j=0;j<M;j++){
                    copymap[i][j] = map[i][j];
                }
            }

            boolean flag = true;

            for(int i=0;i<3;i++) {//복사한 맵에 벽 세우기
                if(copymap[arr[i] / M][arr[i] % M]!=0){//벽을 세울 자리가 바이러스거나, 벽이면 이번 조합은 Pass
                    flag=false;
                    break;
                }
                else//벽을 세우기 위해 선택된 자리가 0 일 경우에 벽을 세운다
                    copymap[arr[i] / M][arr[i] % M] = 1;
            }

            if(flag){

            for(int i=0;i<N;i++){//바이러스 있는 곳부터 dfs
                for(int j=0;j<M;j++){
                    if(virus[i][j]){
                        //copymap = dfs(i,j,copymap);
                    copymap = bfs(i,j,copymap);
                    }
                }
            }
                int count =0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(copymap[i][j]==0)count++;
                    }
                }

                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                       System.out.print(copymap[i][j]);
                    }System.out.println();
                }
                max = Math.max(max,count);

            }



        }else if(target==n)return;
        else{
            arr[index] = target;
            combina(arr,n,r-1,index+1,target+1);
            combina(arr,n,r,index,target+1);
        }
     }

     static int[][] dfs(int r,int c,int[][] copy_map){

        for(int i=0;i<=3;i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr>=0 && nr<N && nc>=0 && nc<M){
                if(!visited[nr][nc]&&copy_map[nr][nc]==0){//벽이 아니면?
                    visited[nr][nc] = true;
                    copy_map[nr][nc] = 2;
                    dfs(nr,nc,copy_map);
                }
            }
        }
        return copy_map;
     }


     static int[][] bfs(int r,int c, int[][] copy_map){

         Queue qR = new LinkedList<Queue>();
         Queue qC = new LinkedList<Queue>();

         qR.offer(r);
         qC.offer(c);

         while(!qR.isEmpty()){

             r = (int) qR.poll();
             c = (int) qC.poll();

             for(int i=0;i<=3;i++) {
                 int nr = r + dx[i];
                 int nc = c + dy[i];
                 if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                     if (!visited[nr][nc] && copy_map[nr][nc] == 0) {//벽이 아니면?
                         visited[nr][nc] = true;
                         copy_map[nr][nc] = 2;

                         qR.offer(nr);
                         qC.offer(nc);
                     }
                 }
             }
         }

return  copy_map;
     }
}
