import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sb=new StringBuffer();
		String s="You are the mananger of an office supplies company. A colleague has received a letter compaining about an order for office furniture. She has left the letter for you to answer and has written some notes on it.";
		StringTokenizer token=new StringTokenizer(s, ", ?.!:\"\"''\n");
		int wordCount=0;
		while(token.hasMoreTokens()){
			wordCount++;
			String word=token.nextToken();
			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}
			else{map.put(word, 1);}
		}
		sb.append("单词的总数：").append(wordCount).append("\n");
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			String k=it.next();
			int v=map.get(k);
			sb.append("单词：").append(k).append("出现的次数").append(v).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
