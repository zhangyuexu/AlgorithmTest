import java.util.HashMap;
import java.util.Map;

public class FirstOnceChar {
/**
 * �ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ��ϣ������������ɨ�輴��ʵ�֡���Ҫ��ǰ����һ����ϣ�����ַ�����keyֵ���ѳ��ֵĴ�������valueֵ������ʼ����

                    ��һ��ɨ�裬ͳ�Ƴ��ֵ�ÿ���ַ��Ĵ������浽��ϣ���У�

                    �ڶ���ɨ�裬���ַ�����һλ��ʼ���鿴��Ӧ��value�Ƿ�Ϊ1�����Ϊ1��ֱ�ӷ��ظ��ַ����㷨���������򣬽���ɨ�衣

                    �㷨��ʱ�临�Ӷ�ΪO(n).�ռ临�Ӷ�ΪO(1).���ַ������ڵ��͵Ŀռ任ʱ�䡣
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hheelloworrld";
		char[] arr=s.toCharArray();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}
			else{
				map.put(arr[i], 1);
			}
		}
		for(int i=0;i<arr.length;i++){
			if(map.get(arr[i])==1){
				System.out.println("�ַ����е�һ��ֻ����һ�ε��ַ��ǣ�"+arr[i]);
				return;
			}	
		}
		
	}
	
	
}
