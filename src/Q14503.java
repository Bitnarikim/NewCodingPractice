import java.util.Scanner;

public class Q14503 {
    //로봇 청소기
    //dfs
    static int[][] map;
    static boolean[][] visited;
    static int sizeR, sizeC;
    static int r, c, d;
    static int[] dX = {-1, 0, +1, 0};// 북 동 남 서
    static int[] dY = {0, +1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        sizeR = sc.nextInt();
        sizeC = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();


        map = new int[sizeR][sizeC];
        visited = new boolean[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(r,c,d);
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                if(visited[i][j]==true)count++;
            }
            //System.out.println();
        }
        System.out.println(count);


    }

    static int count = 0;

    //빈칸 0 청소된 빈칸  visited = true 벽 1
    public static void dfs(int x, int y, int dir) {
        //현재 위치 청소
        visited[x][y] = true;
        //count++;
        //현재 방향에서 왼쪽 탐색
        if (dir == 0) {//북
            if (map[x + dX[3]][y + dY[3]] != 1 && !visited[x + dX[3]][y + dY[3]]) {//서
                dfs(x + dX[3], y + dY[3], 3);
            } else if (map[x + dX[2]][y + dY[2]] != 1 && !visited[x + dX[2]][y + dY[2]]) {//남
                dfs(x + dX[2], y + dY[2], 2);
            } else if (map[x + dX[1]][y + dY[1]] != 1 && !visited[x + dX[1]][y + dY[1]]) {//동
                dfs(x + dX[1], y + dY[1], 1);
            } else if (map[x + dX[0]][y + dY[0]] != 1 && !visited[x + dX[0]][y + dY[0]]) {//북
                dfs(x + dX[0], y + dY[0], 0);
            } else if (map[x + dX[2]][y + dY[2]] != 1) {
                //후진
                dfs(x + dX[2], y + dY[2], 0);
            }
        }else if (dir == 1) {//동
                if (map[x + dX[0]][y + dY[0]] != 1 && !visited[x + dX[0]][y + dY[0]]) {//북
                    dfs(x + dX[0], y + dY[0], 0);
                } else if (map[x + dX[3]][y + dY[3]] != 1 && !visited[x + dX[3]][y + dY[3]]) {//서
                    dfs(x + dX[3], y + dY[3], 3);
                } else if (map[x + dX[2]][y + dY[2]] != 1 && !visited[x + dX[2]][y + dY[2]]) {//남
                    dfs(x + dX[2], y + dY[2], 2);
                } else if (map[x + dX[1]][y + dY[1]] != 1 && !visited[x + dX[1]][y + dY[1]]) {//동
                    dfs(x + dX[1], y + dY[1], 1);
                } else if (map[x + dX[3]][y + dY[3]] != 1) {
                    //후진
                    dfs(x + dX[3], y + dY[3], 1);
                }

            }else if (dir == 2) {//남
                if (map[x + dX[1]][y + dY[1]] != 1 && !visited[x + dX[1]][y + dY[1]]) {//동
                    dfs(x + dX[1], y + dY[1], 1);
                } else if (map[x + dX[0]][y + dY[0]] != 1 && !visited[x + dX[0]][y + dY[0]]) {//북
                    dfs(x + dX[0], y + dY[0], 0);
                } else if (map[x + dX[3]][y + dY[3]] != 1 && !visited[x + dX[3]][y + dY[3]]) {//서
                    dfs(x + dX[3], y + dY[3], 3);
                } else if (map[x + dX[2]][y + dY[2]] != 1 && !visited[x + dX[2]][y + dY[2]]) {//남
                    dfs(x + dX[2], y + dY[2], 2);
                }
                else if (map[x + dX[0]][y + dY[0]] != 1) {
                    //후진
                    dfs(x + dX[0], y + dY[0], 2);
                }

            }else if (dir == 3) {//서
                if (map[x + dX[2]][y + dY[2]] != 1 && !visited[x + dX[2]][y + dY[2]]) {//남
                    dfs(x + dX[2], y + dY[2], 2);
                } else if (map[x + dX[1]][y + dY[1]] != 1 && !visited[x + dX[1]][y + dY[1]]) {//동
                    dfs(x + dX[1], y + dY[1], 1);
                } else if (map[x + dX[0]][y + dY[0]] != 1 && !visited[x + dX[0]][y + dY[0]]) {//북
                    dfs(x + dX[0], y + dY[0], 0);
                } else if (map[x + dX[3]][y + dY[3]] != 1 && !visited[x + dX[3]][y + dY[3]]) {//서
                    dfs(x + dX[3], y + dY[3], 3);
                }
                else if (map[x + dX[1]][y + dY[1]] != 1) {
                    //후진
                    dfs(x + dX[1], y + dY[1], 3);
                }
            }

        }

    }