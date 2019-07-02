import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverse1("This is a test"));//test a is This
		System.out.println(reverse2(reverse1("This is a test")));//tset a si sihT
		//ThreadPoolExecutor executor=new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0L, unit, new LinkedBlockingQueue<Runnable>());

	}
//将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
	public static String reverse1(String s){
		StringBuilder sb=new StringBuilder();
		String[] arr=s.split(" ");
		for(int i=arr.length-1;i>=0;i--){
			sb.append(arr[i]);
			if(i!=0){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	public static String reverse2(String s){
		StringBuilder sb=new StringBuilder();
		String[] arr=s.split(" ");
		for(int i=0;i<arr.length;i++){
			String item=arr[i];
			for(int j=item.toCharArray().length-1;j>=0;j--){
				String tmp=item.charAt(j)+"";
				sb.append(tmp);
			}
			if(i!=arr.length-1){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
