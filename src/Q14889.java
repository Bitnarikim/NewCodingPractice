import java.util.Scanner;

public class Q14889 {

static int N;
static int[][] S;
static boolean[][] visited;

    public static void main(String[] args){

        Scanner sc =new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++)S[i][j] = sc.nextInt();
            }
            int[] arr = new int[N/2];
            visited = new boolean[N+1][N+1];
            combina(arr,0,N,N/2,0);
            System.out.println(min);
        }



public static void combina(int[] arr, int index, int n, int r, int target){

        if(r==0){//다 뽑았으면 프린트;
      /*      for(int i=0;i<arr.length;i++){
                System.out.print(" "+arr[i]);
            }
            System.out.println();*/
            sum(arr);
        }else if(target==n){//두번째 combination함수 호출-> 잘 모르겠땅

        }else{
            arr[index]= target+1;
            combina(arr,index+1,n,r-1,target+1);
            combina(arr,index,n,r,target+1);
        }
}

static int min=Integer.MAX_VALUE;
public static void sum(int[] arr){
        //매트릭스에서 우리 팀인 것 비교
    int S_sum = 0;
    int L_sum = 0;
    for (int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            S_sum += S[arr[i]][arr[j]];
            S_sum += S[arr[j]][arr[i]];
        }
    }

    int[] link = new int[N/2];
    int count=0;
    for (int i=1;i<=N;i++){
        boolean flag = false;
        for(int j=0;j<arr.length;j++){
        if(i==arr[j]){flag = true;
        break;}
        }
        if(!flag){link[count] = i;
        count++;}
    }

    for (int i=0;i<link.length;i++){
        for(int j=i+1;j<link.length;j++){
            L_sum += S[link[i]][link[j]];
            L_sum += S[link[j]][link[i]];
        }
    }
int result =Math.abs(Math.subtractExact(L_sum,S_sum));

    min =Math.min(min,result);

}

}
