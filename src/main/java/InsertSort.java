import java.util.Arrays;

public class InsertSort {
	//÷±Ω”≤Â»Î≈≈–Ú
	public static void main(String[] args) {
		int[] arr={2,1,4,3,6,5};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	public static void insertSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int temp=arr[i];
			int pos=i-1;
			while(pos>=0&&arr[pos]>temp){
				arr[pos+1]=arr[pos];
				pos--;
			}
			arr[pos+1]=temp;
		}
	}

}
