import java.io.FileInputStream;
import java.util.*;

class Node implements Comparator<Node>
{
    int node;
    int cost;
 
    public Node()
    {
    }
 
    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }
 
    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}

public class Main {
	static int [] d;
	static int [] u;
	static int [][] adj;
	static int V, E;
	static int [] t;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			d = new int [V+1];
			u = new int [V+1];
			adj = new int [V+1][V+1];
			for (int i = 0; i <= V; i++)
			{
				for (int j = 0; j <= V; j++)
				{
					if (i == j)
						adj[i][j] = 0;
					else
						adj[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < E; i++)
			{
				int n1, n2, w;
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				w = sc.nextInt();
				adj[n1][n2] = w;
			}
			
			dij();
			System.out.println("#"+tc+" "+d[V]);
		}
	}

  public static void dij()
	{
		PriorityQueue <Node> pq = new PriorityQueue<Node>(new Node());
		
		for(int i=1; i<=V; i++)
		{
			d[i] = adj[0][i];
			if(adj[0][i]!=0 && adj[0][i]!=Integer.MAX_VALUE)
			{
				pq.offer(new Node(i, d[i]));
			}
		}
		
		while(!pq.isEmpty())
		{
			Node t = pq.poll();
			
			for(int i=0; i<=V; i++)
			{
				if(adj[t.node][i]!=0 && adj[t.node][i]!=Integer.MAX_VALUE)
				{
					if (d[i] > (d[t.node] + adj[t.node][i])) // 갱신이 되면
					{
						d[i] = d[t.node] + adj[t.node][i];
						pq.add(new Node(i, d[i]));
					}
				}
			}
		}
	}
}
