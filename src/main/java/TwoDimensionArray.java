
public class TwoDimensionArray {
	public static void main(String[] args){
		int[][] arr=new int[3][3];
		int num=0;
		//�����鸳ֵ
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=num;
				num++;
			}
		}
		outArray(arr);
		
		int[][] arrRotate=rotateArr(arr);
		outArray(arrRotate);
	}
	
	//����ת��
	public static int[][] rotateArr(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				int tmp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=tmp;
			}
		}
		return arr;
	}
	//�������
	public static void outArray(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
