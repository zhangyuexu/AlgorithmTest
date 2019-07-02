
public class CharacterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="哈回家看电视hello1234567890";
		int length=str.length();
		int numLength=length-str.replaceAll("\\d", "").length();
		int charLength=length-str.replaceAll("[a-zA-Z]", "").length();
		int chineseLength=length-str.replaceAll("[^x00-xff]", "").length();
		System.out.println("number:"+numLength);
		System.out.println("character:"+charLength);
		System.out.println("chinese:"+chineseLength);
	}

}
