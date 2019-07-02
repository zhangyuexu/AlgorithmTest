public class StringLC {

	public static void main(String[] args) {
		//求两个字符串的最长的子字符串
		System.out.println(LC("abcdef","klbcdekl"));

	}
	public static String LC(String a,String b){
		String min=b;
		String max=a;
		if(a.length()<b.length()){
			min=a;
			max=b;
		}
		for(int i=0;i<min.length();i++){
			for(int j=0;j<=i;j++){
				String tmp=min.substring(j, min.length()-i+j);//substring这个函数是左包右不包
				//System.out.println(tmp);
				if(max.indexOf(tmp)>=0){
					return tmp;
				}
			}
		}
		return "";
	}

}
