/*
입력
3
1 2
2 3
4 5
출력
1 3 4
1 3 5
2 4
2 5
 */

import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [] sel;
	static int [] unsel;
	static int [][] e;
	
	static int K;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sel = new int [101];
		unsel = new int [101];
		e = new int [K][2];
		for(int i=0; i<K; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			e[i][0] = n1;
			e[i][1] = n2;
		}
		find(0, K);
		find2(0, K);
	}
	public static void find(int n, int k)
	{
		if(n==k)
		{
			for(int i=1; i<=100; i++)
			{
				if(sel[i]==1)
					System.out.print(i+" ");
			}
			System.out.println();
		}
		else
		{
			if(sel[e[n][0]] == 1)
			{
				unsel[e[n][1]] = 1;
				find(n+1, k);
				unsel[e[n][1]] = 1;
			}
			else if(sel[e[n][1]] == 1)
			{
				unsel[e[n][0]] = 1;
				find(n+1, k);
				unsel[e[n][0]] = 1;
			}
			else
			{
				// e[n][0] 선택
				//if(sel[e[n][0]] == 0 && sel[e[n][1]] == 0 && unsel[e[n][0]]==0)
				if(unsel[e[n][0]]==0)
				{
					sel[e[n][0]] = 1;
					unsel[e[n][1]] = 1;
					find(n+1, k);
					sel[e[n][0]] = 0;
					unsel[e[n][1]] = 0;
				}
				// e[n][1] 선택
				//if(sel[e[n][0]] == 0 && sel[e[n][1]] == 0 && unsel[e[n][1]]==0)
				if(unsel[e[n][1]]==0)
				{
					sel[e[n][1]] = 1;
					unsel[e[n][0]] = 1;
					find(n+1, k);
					sel[e[n][1]] = 0;
					unsel[e[n][0]] = 0;
				}
			}
		}
	}
	public static void find2(int n, int k)
	{
		if(n==k)
		{
			for(int i=1; i<=100; i++)
			{
				if(sel[i]==1)
					System.out.print(i+" ");
			}
			System.out.println();
		}
		else
		{
			if(sel[e[n][0]] == 1 || sel[e[n][1]]==2)
			{
        t0 = sel[e[n][0]];
        t1 = sel[e[n][1]];
				sel[e[n][0]] = 1;
				sel[e[n][1]] = 2;
				find2(n+1, k);
				sel[e[n][0]] = t0;
				sel[e[n][1]] = t1;
			}
			else if(sel[e[n][0]]==2 || sel[e[n][1]] == 1)
			{
        t0 = sel[e[n][0]];
        t1 = sel[e[n][1]];
				sel[e[n][0]] = 2;
				sel[e[n][1]] = 1;
				find2(n+1, k);
				sel[e[n][0]] = t0;
				sel[e[n][1]] = t1;
			}
			else if( sel[e[n][0]]==0 && sel[e[n][1]] == 0)
			{
					sel[e[n][0]] = 1;
					sel[e[n][1]] = 2;
					find2(n+1, k);
					sel[e[n][0]] = 2;
					sel[e[n][1]] = 1;
					find2(n+1, k);
					sel[e[n][0]] = 0;
					sel[e[n][1]] = 0;
			
			}
		}
	}
}
