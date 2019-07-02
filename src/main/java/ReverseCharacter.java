import java.util.Scanner;

public class ReverseCharacter {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char[] ch=s.toCharArray();
		String s2="";
		for(int i=ch.length-1;i>=0;i--){
			//System.out.print(ch[i]);
			s2+=ch[i];
		}
		System.out.println(s2);
		sc.close();
	}
	private static void test2(){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		sc.close();
		String s2="";
		for(int i=0;i<s.length();i++){
			s2=s2+s.charAt(s.length()-1-i);//通过s2+charAt可以把char类型自动升为String类型
		}
		System.out.println(s);
		System.out.println(s2);
	}

}
