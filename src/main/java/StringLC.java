public class StringLC {

	public static void main(String[] args) {
		//�������ַ�����������ַ���
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
				String tmp=min.substring(j, min.length()-i+j);//substring�������������Ҳ���
				//System.out.println(tmp);
				if(max.indexOf(tmp)>=0){
					return tmp;
				}
			}
		}
		return "";
	}

}
