import java.util.Scanner;
/**
 * ����һ���ַ���ͳ�Ƴ�������Ŀո�Ӣ����ĸ�������Լ������ַ��ĸ���
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
		ch=s.toCharArray();//�ַ���ת�ַ�����
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
		System.out.println("���ָ�����"+digital);
		System.out.println("Ӣ����ĸ������"+character);
		System.out.println("�ո������"+blank);
		System.out.println("�����ַ�������"+others);
	}

}
