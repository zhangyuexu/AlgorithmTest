import java.util.Scanner;

public class ReverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		String s=Long.toString(a);
		char[]ch=s.toCharArray();
		System.out.println(a+"ÊÇ"+ch.length+"Êý");
		for(int i=ch.length-1;i>=0;i--){
			System.out.print(ch[i]);
		}
		sc.close();
	}

}
