/*
  edge[][0] node1
  edge[][1] node2
  edge[][2] weight
*/
import java.util.*;
import java.io.FileInputStream;


class EdgeCompare implements Comparator<int []>{

	@Override
	public int compare(int [] o1, int [] o2) {
		// TODO Auto-generated method stub
		if(o1[2]>o2[2])
			return 1;
		else if(o1[2]<o2[2])
			return -1;
		else
			return 0;
	}
}
public class Solution {
	static int V;
	static int E;
	static int [] mst;
	static int [][] edge;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			mst = new int[V+1];
			edge = new int [E][3];

			for(int i=0;i<E; i++)
			{
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] =sc.nextInt();
				
			}
			Arrays.sort(edge, new EdgeCompare());
			int sum = Kruskal();
			System.out.println("#"+tc+" "+sum);
		}
	}
	public static int Kruskal()
	{
		int sum = 0;
		for(int i =0 ; i<=V; i++)
			mst[i]= i; // 각자 대표 노드
		int i =0;
		int cnt = 0;
		while(cnt<V)
		{
			
			int p1 = rep(edge[i][0]);
			int p2 = rep(edge[i][1]);
			if(p1!=p2)
			{
				mst[p2] = p1;
				sum += edge[i][2];
				cnt++;
			}
			i++;
		}
		return sum;
	}
	public static int rep(int n)
	{
		while(mst[n]!=n)
		{
			n = mst[n];
		}
		return n;
	}
	
}
