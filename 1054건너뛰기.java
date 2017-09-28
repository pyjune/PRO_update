import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	static int [][] A;
	static int [][]	D;
	static int N, M;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N+1][M+1];
			D = new int[N+1][M+1];
			for(int i = 1; i<=N; i++)
				for(int j = 1; j<=M; j++)
					A[i][j] = sc.nextInt();
			find();
			System.out.println("#"+tc+" "+D[N][M]);
		}
	}
	public static void find()
	{
		D[1][1] = 1;
		for(int i = 1; i<=N; i++)
		{
			for(int j = 1; j<=M; j++)
			{
				for(int k=1; k<=3;k++)
				{
					if(j-k>0 && A[i][j-k]==k)
						D[i][j] += D[i][j-k];
				
					if(i-k>0 && A[i-k][j]==k)
						D[i][j] += D[i-k][j];
				}
			}
		}
	}
}
