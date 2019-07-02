
public class Num2Excle {
	private static String decimalToShiliu(int num){
		StringBuilder builder=new StringBuilder();
		while(num!=0){
			int tmp=num%26;
			num=num/26;
			if(tmp==0){
				tmp=26;
				num=num-1;
			}
			builder.append((char)(tmp+'A'-1));
		}
		return builder.reverse().toString();
	}
	
	private static int shiliuToDecimal(String str){
		char[] ch=str.toCharArray();
		int exp=0;
		int num=0;
		for(int i=ch.length-1;i>=0;i--){
			num+=(ch[i]-'A'+1)*Math.pow(26, exp);
			exp++;
		}
		return num;
	}
	
	public static void main(String[] args){
		Num2Excle num2Excle=new Num2Excle();
		System.out.println(num2Excle.decimalToShiliu(1000));
		System.out.println(shiliuToDecimal("ALL"));
	}
}
