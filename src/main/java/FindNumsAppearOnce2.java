
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindNumsAppearOnce2 {

	public static void main(String[] args) {
		int[] arr={1,3,5,1,3,7};
		int[] result = findNumsAppearOnce1(arr);
		System.out.println(Arrays.toString(result));
		
		findNumsAppearOnce2(arr);

	}
	
	/*
	 �ⷨ1��
	1��˼·��
	(1)���ڳ������ε�Ԫ�أ�ʹ�á���򡱲��������϶�Ϊ0����ô���ǾͿ��Ա���һ�����飬������Ԫ��ʹ������������ô�õ��Ľ��������������һ�ε�Ԫ�ص��������
	(2)��Ϊ������Ԫ�ز���ȣ��������Ľ���϶�����0��Ҳ���ǿ��������Ľ�����ҵ�1λ��Ϊ0��λ����������������һλ��Ϊ0��
	(3)�������ǾͿ������һλ��ԭ����Ԫ�ط�Ϊ���飬һ���λȫΪ1����һ���λȫΪ0��
	(4)�ٴα���ԭ���飬���һλΪ0��һ��������һλΪ1��һ������������Ľ���ֱ��Ӧ�����������
	2�����Ӷȣ�
	  ��1��ʱ�临�Ӷȣ���һ��ѭ����������Ԫ�����õ���Ӧ�����ʱ�俪��ΪO(n)���ڶ���ѭ�����ҳ���һ�������Ϊ1��λ��ʱ�俪��ΪO(32)��������ѭ��������Ϊ1��λ��Ԫ�ط�Ϊ����������õ����������ʱ�临�Ӷ�ΪO(n)�������ܵ�ʱ�临�Ӷ�ΪT(n) = 2*O(n)+O(32) = O(n)��
	  ��2���ռ临�Ӷȣ���������Ϊֻ�����������ռ����ڽ���ı��棬��˿ռ临�Ӷ�Ϊ������
	  
	���������ԣ��������е�����ͷ��β������򣬳���ż���ε������Ϊ0�����ս��������ֻ����һ�ε��������Ľ����
	�������������ֲ�ͬ�����Ľ��һ����Ϊ0����������Ʊ�ʾ��ʽ��һ������ĳһλΪ1���ҵ���һ��Ϊ1��λ�������ǵ�Nλ����ô�ڶ�Ӧ����һλ�ϣ���������һ��Ϊ0��һ��Ϊ1��
	���ݵ�Nλ�Ƿ�Ϊ1����ԭ����ֳ����������飬��������������ж�ֻ����һ��ֻ������һ�ε������������������������Σ������������е�Ԫ�طֱ���򣬾͵õ�������ֻ����һ�ε�����
	 */

	    public static int[] findNumsAppearOnce1(int[] arr) {
	        if(arr.length < 2)
	            return arr;

	        int[] result = new int[2];  //Ҫ���صĽ��  
	        int res = arr[0];  //��һ�ζ�����Ԫ�ؽ������������  
	        for(int i=1; i<arr.length; i++) {
	            res ^= arr[i];
	        }
	        System.out.println(res);//��һ�����Ľ��
	        int bitIndex = 0;
	        for(int i=0; i<32; i++) {  //�ҳ������Ϊ1��λ��  
	            if((res>>i & 1) == 1) {
	                bitIndex = i;
	                break;
	            }
	        }
	        System.out.println(bitIndex);//�ҳ���һ��Ϊ1��λ
	        for(int i=0; i<arr.length; i++) { //����bitIndexΪ1����Ԫ�ط�Ϊ����  
	            if((arr[i] >> bitIndex & 1) == 1)
	                result[0] ^= arr[i];   //��ӦλΪ1�����õ��Ľ��  
	            else
	                result[1] ^= arr[i];   //��ӦλΪ0�����õ��Ľ��  
	        }

	        return result;
	    }
	
	    /*
	    �ⷨ2��
	    ��1��˼·��������Կ���ʹ��һ��Map��Map��Ӧ�ļ�ֵkey���������е�Ԫ�أ�value�������Ԫ�س��ֵĴ�����������
	    ͨ��һ�α��������е�Ԫ�أ����Ԫ�س�����map�У������Ӧ��value��1������Ԫ����ӵ�map�У���������һ�����飬���ǾͿ��Եõ�������ÿ��Ԫ�ض�Ӧ���ֵĴ�����Ȼ����ͨ������һ��map������valueΪ1��Ӧ��key����������Ҫ���Ԫ�ء�
	    ��2��ʱ�临�Ӷȣ���Ϊ������Ҫ����һ�����飬ʱ�俪��ΪO(n)��������map����Ҫ����һ��map�ҵ�valueΪ1��Ԫ�أ���map�ĸ���Ϊn/2��ʱ�俪��ΪO(n/2)�������ܵ�ʱ�俪��ΪO(n)��
	    ��3���ռ临�Ӷȣ���Ϊ��Ҫ����һ��map���������map�Ĵ�СΪn/2�����Կռ临�Ӷ�ΪO(n)��
	    */
	        public static void findNumsAppearOnce2(int[] arr) {
	            //Map��Ӧ�ļ�ֵkey���������е�Ԫ�أ�value�������Ԫ�س��ֵĴ���
	            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	            for (int i : arr) {
	                if (hashMap.containsKey(i)) {
	                    hashMap.put(i, hashMap.get(i) + 1); //������ڣ�valueֵ��1
	                } else {
	                    hashMap.put(i, 1); //��������ڣ�����hashMap,valueֵ����1
	                }
	            }

	            //����һ��map������valueΪ1��Ӧ��key����������Ҫ���Ԫ��
	            Set<Integer> set = hashMap.keySet();
	            for (int i : set) {
	                if (hashMap.get(i) == 1) {
	                    System.out.print(i+" ");
	                }
	            }
	        }

}
