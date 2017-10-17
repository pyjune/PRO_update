import java.util.*;
import java.io.FileInputStream;

class Edge{
	int n1;
	int n2;
	int w;
	Edge(int n1, int n2, int w)
	{
		this.n1 = n1;
		this.n2 = n2;
		this.w = w;
	}
}
class EdgeCompare implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		// TODO Auto-generated method stub
		if(o1.w>o2.w)
			return 1;
		else if(o1.w<o2.w)
			return -1;
		else
			return 0;
	}
}
public class Solution {
	static int V;
	static int E;
	static int [] mst;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			mst = new int[V+1];

			pq = new PriorityQueue<Edge>(new EdgeCompare());
			for(int i=0;i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int w = sc.nextInt();
				pq.offer(new Edge(n1,n2,w));
			}
			int sum = Kruskal();
			System.out.println("#"+tc+" "+sum);
		}
	}
	public static int Kruskal()
	{
		int sum = 0;
		for(int i =0 ; i<=V; i++)
			mst[i]= i; // 각자 대표 노드

		int cnt = 0;
		while(cnt<V)
		{
			Edge edge = pq.poll();
			int p1 = rep(edge.n1);
			int p2 = rep(edge.n2);
			if(p1!=p2)
			{
				mst[p2] = p1;
				sum += edge.w;
				cnt++;
			}
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
