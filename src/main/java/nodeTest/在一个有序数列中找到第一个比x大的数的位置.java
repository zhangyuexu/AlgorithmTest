package nodeTest;

public class ��һ�������������ҵ���һ����x�������λ�� {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,7,9};
		System.out.println(search(arr, 4));

	}
	public static int search(int[] arr,int target){
		int min=0,max=arr.length-1;
		int index=-1;
		while(min<=max){
			int mid=(min+max)/2;
			if(arr[mid]<target){
				min=mid+1;
			}
			else{
				index=mid;
				break;
			}
		}
		return index;
	}

}
