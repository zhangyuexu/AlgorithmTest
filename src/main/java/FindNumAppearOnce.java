
public class FindNumAppearOnce {

	public static void main(String[] args) {
		int[] arr={1,3,5,1,3};
		findNumAppearOnce(arr);
	}

	public static void findNumAppearOnce(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
	}
}
	
