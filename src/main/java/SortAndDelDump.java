import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAndDelDump {
	public static void main(String[] args){
		int[] arr={1,2,4,2,4,5,7,10,5,5,7,8,9,0,3};	
		List<Integer>list=new ArrayList<Integer>();
		for(int i:arr){
			//������ȥ��
			if(!list.contains(i)){
				list.add(i);
			}
		}
		System.out.println();
		Integer[] newArr=list.toArray(new Integer[list.size()]);//listת���飬���ص���һ��������
		System.out.println("ȥ�غ�������ǣ�"+Arrays.toString(newArr));
		Arrays.sort(newArr);
		System.out.println("�����������ǣ�"+Arrays.toString(newArr));
		
		
		/**
		for(Integer elment:newArr){
			System.out.print((int)elment+" ");
		}
		
		System.out.println();
//��̬static�����в��ܵ��÷Ǿ�̬non-static������׼ȷ��˵�ǲ���ֱ�ӵ���non-static���������ǿ���ͨ����һ����������ô���static�����У���ȥ���øö����non-static����
		array2List();
		*/
	}
	public static void array2List(){
		//����תlist
		Integer[] arr={1,2,4,2,4,5,7,10,5,5,7,8,9,0,3};
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(arr));
//		List<Integer>list=Arrays.asList(arr);
		for(Integer elment:list){
			System.out.print(elment+" ");
		}
	}
}
