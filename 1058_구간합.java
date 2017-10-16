
import java.io.FileInputStream;
import java.util.*;

public class Solution {
	static int [] t; // 노드에 구간을 저장하지 않는 방식
	static int [] p;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int tc = 1; tc<=testcase; tc++)
		{
			t = new int [1000000];
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int [N];
			for(int i = 0; i<N; i++)
			{
				p[i] = sc.nextInt();
			}

			make(1, 0, N-1);
			// left~right 구간 합
			int max = 0;
			for(int i=0; i<M; i++)
			{
				int left = sc.nextInt();
				int right = sc.nextInt();
				int ret = sum(1, left, right, 0, N-1);
				if( max<ret)
					max = ret;
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

	public static int make(int n, int s, int e)
	{
		if(s==e) // 잎노드
		{
			t[n] = p[s]; // 잎노드에는 배열에 들어있는 값을 저장.
			return t[n];
		}
		else
		{
			int l = make(n*2, s, (s+e)/2); // 왼쪽 자식 구간의 합
			int r = make(n*2+1, (s+e)/2+1, e); // 오른쪽 자식 구간의 합
			t[n] = l+r; // 중간노드에는 구간의 합을 저장.
			return t[n]; // 
		}
	}
	public static int sum(int n, int L, int R, int s, int e)
	{
		if (R<s || e<L) // 구간을 벗어남  
			return 0;
		else if(L<=s && e<=R) // 노드 구간이 검색 구간 L, R에 포함됨
			return t[n];
		else // 일부 겹치면 계속 검색
		{
			int r1 = sum(n*2, L, R, s, (s+e)/2);
			int r2 = sum(n*2+1, L, R, (s+e)/2+1, e);
			return r1+r2;
		}
	}
	public static void change( int n, int s, int e, int i, int diff)
	{
		if (i<s || e<i) // 구간을 벗어남
			return;
		else if (s==i && i==e) // 잎노드
		{
			t[n] += diff;
			return;
		}
		else if (s<=i && i<=e)
		{
			t[n] += diff;
			change(n*2, s, (s+e)/2, i, diff);
			change(n*2+1, (s+e)/2+1, e, i, diff);
		}
	}
	public static void change2( int n, int s, int e, int i, int diff)
	{
		while(s!=e)
		{
			t[n] += diff;
			int m = (s+e)/2;
			if( i<= m)
			{
				e = m;
				n = 2*n;
			}
			else
			{
				s = m+1;
				n = 2*n+1;
			}
				
		}
		t[n] += diff;
	}
}
