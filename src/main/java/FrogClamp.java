import java.util.Scanner;

public class FrogClamp {
	/**
	 * 有n米的一口井,青蛙每天向上爬3米掉下来1米,请问多少天后可以爬出来?用java编程做出来. 
	 */
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		sc.close();
		int n=Integer.valueOf(str);
		//String numStr=String.valueOf(2);
		int i=0,m=0;
		while(m<n){
			m+=3-1;
			i++;
		}
		System.out.println("青蛙需要花"+i+"天才能爬出来");
	}

}
