#include <stdio.h>
 
int V, E;
 
typedef struct EdgeType{
    int n1;
    int n2;
    int w;
};
 
EdgeType edge[1000000];
int mst[1000000];
 
void qs(int l, int r);
int kruskal(void);
int rep(int n);
 
int main(void)
{
    //freopen("Text.txt", "r", stdin);
    int T;
     
    scanf("%d", &T);
    for (int tc = 1; tc <= T; tc++)
    {
        scanf("%d %d", &V, &E);
        for (int i = 0; i < E; i++)
        {
            scanf("%d %d %d", &edge[i].n1, &edge[i].n2, &edge[i].w);
        }
        qs(0, E-1);
        printf("#%d %d\n", tc, kruskal());
    }
}
 
void qs(int l, int r)
{
    int i = l;
    int j = r;
    int p = (l + r) / 2;
    while (i <= j)
    {
        while (edge[i].w < edge[p].w)
            i++;
        while (edge[j].w > edge[p].w)
            j--;
        if (i <= j)
        {
            EdgeType tmp = edge[i];
            edge[i] = edge[j];
            edge[j] = tmp;
            i++;
            j--;
        }
    }
    if (l < j)
        qs(l, j);
    if (i < r)
        qs(i, r);
}
 
int kruskal(void)
{
    for (int i = 0; i <= V; i++)
        mst[i] = i;
    int cnt = 0;
    int i = 0;
    int sum = 0;
    while (cnt<V)
    {
 
        int p1 = rep(edge[i].n1);
        int p2 = rep(edge[i].n2);
        if (p1 != p2)
        {
            mst[p2] = p1;
            sum += edge[i].w;
            cnt++;
        }
        i++;
    }
    return sum;
}
 
int rep(int n)
{
    while (mst[n] != n)
    {
        n = mst[n];
    }
    return n;
}
