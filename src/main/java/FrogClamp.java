import java.util.Scanner;

public class FrogClamp {
	/**
	 * ��n�׵�һ�ھ�,����ÿ��������3�׵�����1��,���ʶ���������������?��java���������. 
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
		System.out.println("������Ҫ��"+i+"�����������");
	}

}
