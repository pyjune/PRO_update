import java.io.FileInputStream;
import java.util.*;

class Comp1 implements Comparator<int []>
{

	@Override
	public int compare(int []arg0, int[] arg1) {
		// TODO Auto-generated method stub
		if(arg0[1] > arg1[1])
		{
			return 1;
		}
		else if(arg0[1] < arg1[1])
		{
			return -1;
		}
		else
			return 0;
	}
	
}
class Comp2 implements Comparator<int []>
{
	@Override
	public int compare(int [] arg0, int[] arg1) {
		// TODO Auto-generated method stub
		if(arg0[2] > arg1[2])
		{
			return 1;
		}
		else if(arg0[2] < arg1[2])
		{
			return -1;
		}
		else
			return 0;
	}
	
}

public class Main {
	static int N;
	static int [][] p;
	static int [] lis;
	static int [] t;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N][3];
		t = new int [1000000];
		

		for(int i = 0; i<N; i++)
		{
			p[i][1] = sc.nextInt();
			p[i][2] = sc.nextInt();
		}
		Arrays.sort(p, new Comp1()); // 위치를 0 ~ N-1로 변환
		for(int i = 0; i<N; i++)
		{
			p[i][0] = i;
		}
		
		Arrays.sort(p, new Comp2()); // 연결 번호에 대해 오름 차순 정렬
		
		for(int i=0; i<N; i++)
		{
			int lis = findMax(1, p[i][0], 0, N-1) + 1;
			update(1, p[i][0], lis, 0, N-1);
		}
		
		System.out.println(N-t[1]);
	}
	public static int findMax(int n, int idx, int s, int e)
	{
		if(idx<s)
			return 0;
		else
		{
			if(e<=idx)
				return t[n];
			
			else
			{
				int r1 = findMax(n*2, idx, s, (s+e)/2);
				int r2 = findMax(n*2+1, idx, (s+e)/2+1, e);
				return r1>r2?r1:r2;
			}
		}
	}

	public static void update(int n, int i, int LIS, int s, int e)
	{
		while(s!=e)
		{
			t[n] = LIS>t[n]?LIS:t[n];
			int m = (s+e)/2;
			if(i<=m)
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
		t[n] = LIS>t[n]?LIS:t[n];
	}
	
}
