import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayMaxValue {
	static List<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args){
		int[] array = {1,-2,3,10,-4,7,2,1,-5};
		System.out.println(findMax(array));
		System.out.println(list.toString());
	}
	
	public static int findMax(int arr[]){
		if(arr.length==0){
			return 0;
		}
		int max=arr[0];
		int sum=0;
		for(int i=0;i<arr.length;i++){
			
			if(sum>0){
				sum+=arr[i];
			}
			else{
				sum=arr[i];
			}
			
			if(sum>max){
				max=sum;
				list.add(arr[i]);
			}
		}
		return max;
	}

}
