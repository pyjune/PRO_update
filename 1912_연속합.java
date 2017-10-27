import java.util.Scanner;

public class Main{
	static int [] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++)
        {
        	int a = sc.nextInt();
        	d[i] = a;
        	if(d[i-1]+a>d[i])
        		d[i] = d[i-1]+a;
        	if(max<d[i])
        		max = d[i];
        }
        System.out.println(max);
    }
 
}
