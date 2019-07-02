import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PositiveMinusSplit {

	public static void main(String[] args) {
		Integer[] arr={-1,-3,5,-2,2,-7,6,8};
		//asList�������ص��������һ����ͼ����ͼ��ζ�Ŷ����list�����ᷴӳ��ԭ�����ϣ��������list�Ƕ����ģ���֧��add,remove�Ȳ�����
//		List<Integer> list1=Arrays.asList(arr);
//		List<Integer> list2=Arrays.asList(arr);
		
		//��������newһ��list
		List<Integer> list1=new ArrayList<Integer>(Arrays.asList(arr));//����ת�б�
		List<Integer> list2=new ArrayList<Integer>(Arrays.asList(arr));
		//ѭ��ɾ��list�ж��Ԫ�صģ�Ӧ��ʹ�õ�����iterator��ʽ,ע����ǣ�ʹ��iterator��remove����
		Iterator<Integer> it1=list1.iterator();
		while(it1.hasNext()){
			Integer x=it1.next();
			if(x>0){
				it1.remove();
			}
		}
		
		Iterator<Integer> it2=list2.iterator();
		while(it2.hasNext()){
			Integer y=it2.next();
			if(y<0){
				it2.remove();
			}
		}
		list1.addAll(list2);//�����б�ϲ�
		System.out.println(list1.toString());
		
		Integer[] newArr=list1.toArray(new Integer[list1.size()]);//�б�ת����
		Arrays.sort(newArr);
		System.out.println(newArr.toString());//���Ǵ�ӡ������ڴ��ַ
		String arrString=Arrays.toString(newArr);//����ת�ַ���
		System.out.println(arrString);
	}
}
