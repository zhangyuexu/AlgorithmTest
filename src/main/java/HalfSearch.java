
public class HalfSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,5,6,7,9,11,13,14,19};
		int min=0;
		int max=arr.length-1;
		int num=19;
		int index=-1;
		while(min<=max){
			int mid=(min+max)/2;
			if(arr[mid]==num){
				index=mid;
				break;
			}
			else if(arr[mid]>num){
				max=mid-1;
			}
			else{
				min=mid+1;
			}
		}
		System.out.println("查找的元素在数组的索引是："+index);
	
	}
}
