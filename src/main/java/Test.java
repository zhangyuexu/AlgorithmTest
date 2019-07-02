import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String [] args){
		int[] arr={2,1,4,3};
		for(int i=1;i<arr.length;i++){
			int tmp=arr[i];
			int pos=i-1;
			while(pos>=0&&arr[pos]>tmp){
				arr[pos+1]=arr[pos];
				pos--;
			}
			arr[pos+1]=tmp;
		}
		System.out.println(Arrays.toString(arr));
		int[] arr2={2,1,4,3,7,5,6};
		for(int i=0;i<=arr2.length-1;i++){
			for(int j=i+1;j<arr2.length;j++){
				if(arr2[i]>arr2[j]){
					int tmp=arr2[i];
					arr2[i]=arr2[j];
					arr2[j]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
}
