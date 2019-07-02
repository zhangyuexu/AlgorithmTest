
public class Excle2Num {
	public static String decimalToShiliu(int num){
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
	
	public static int shiliuToDecimal(String str){
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
		Excle2Num excle2Num=new Excle2Num();
		System.out.println(excle2Num.decimalToShiliu(27));
		System.out.println(excle2Num.shiliuToDecimal("ALL"));
	}

}
