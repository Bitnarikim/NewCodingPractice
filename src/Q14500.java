import java.util.Scanner;

public class Q14500 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};//0 남 0 북
    static int[] dy = {1,0,-1,0};//동 0 서 0

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
        map[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
              dfs(i,j,0,0);
              cros(i,j);
            }
        }
        System.out.println(max);
    }
    static int max = Integer.MIN_VALUE;
    public static void dfs(int r, int c, int sum,int cnt){

        visited[r][c]=true;
        sum += map[r][c];
        cnt = cnt+1;
        if(cnt==4){//탈출 조건
            max = Math.max(sum,max);
        }else{
      for(int d=0;d<=3;d++){

    int nr = r + dx[d];
    int nc = c + dy[d];
    if(nr>=0&&nr<N&&nc>=0&&nc<M){
        if(!visited[nr][nc]){
            dfs(nr,nc,sum,cnt);
        }
    }
    }
        }

    visited[r][c] = false;

    }

    static void cros(int r,int c){

        int Dcnt = 0;
        int sum = map[r][c];
        for(int d=0;d<=3;d++){

            int nr = r + dx[d];
            int nc = c + dy[d];
            if(nr>=0&&nr<N&&nc>=0&&nc<M){
                Dcnt = Dcnt+1;
                sum += map[nr][nc];
            }
        }

        if(Dcnt==4) {//한 숫자씩 빼면서 진행
            for (int d = 0; d <= 3; d++) {
                int test = sum;
                int nr = r + dx[d];
                int nc = c + dy[d];
                test =  test -  map[nr][nc];
                max = Math.max(test,max);
            }

        }else if(Dcnt==3){
            max = Math.max(sum,max);
        }else{
            return;
        }


        }

    }

