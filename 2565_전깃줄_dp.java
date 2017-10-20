import java.io.FileInputStream;
import java.util.*;

public class Main{
	static int N;
	static int [] p;
	static int [] lis;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[501];
		lis = new int[501];
		
		for(int i = 0; i<N; i++)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			p[n1] = n2;
		}
		for(int i = 0; i<=500; i++)
		{
			if(p[i]!=0)
				lis[i] = 1;
		}
		int r = find();
		System.out.println(N-r);
	}
	public static int find()
	{
		int max = 0;
		for(int i = 1; i<=500; i++)
		{
			
			if(p[i]!=0)
			{
				for(int j = 0; j<i; j++)
				{
					if(p[i]>p[j] && (lis[j]+1)>lis[i])
					{
						lis[i] = lis[j]+1;
						max = lis[i]>max?lis[i]:max;
					}
				}
			}
		}
		return max;
	}
}
