import java.util.Scanner;
/**
 * 输入一行字符，统计出这里面的空格、英文字母、数字以及其他字符的个数
 *
 */
public class CharacterStatistics {
	static int digital=0;
	static int character=0;
	static int others=0;
	static int blank=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch=null;
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		sc.close();
		ch=s.toCharArray();//字符串转字符数组
		for(int i=0;i<ch.length;i++){
			if(ch[i]>='0'&&ch[i]<='9'){
				digital++;
			}
			else if((ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z')){
				character++;
			}
			else if(ch[i]==' '){
				blank++;
			}
			else{
				others++;
			}
		}
		System.out.println("数字个数："+digital);
		System.out.println("英文字母个数："+character);
		System.out.println("空格个数："+blank);
		System.out.println("其他字符个数："+others);
	}

}
